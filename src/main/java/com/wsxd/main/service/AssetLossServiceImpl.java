package com.wsxd.main.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wsxd.main.dao.AssetLossMapper;
import com.wsxd.main.entity.AssetLoss;
import com.wsxd.main.entity.AssetLossExample;
import com.wsxd.main.entity.BaseReqBean;
import com.wsxd.main.entity.ResultBean;
import com.wsxd.main.utils.Md5ToolUtil;
import com.wsxd.main.utils.PropertyUtil;
import com.wsxd.main.utils.RestTemplateUtils;
@Service
public class AssetLossServiceImpl implements AssetLossService{
	@Autowired
	AssetLossMapper alm;
	
	private String url=PropertyUtil.getProperty("url")+"asset-loss";
	
	private String trustcode=PropertyUtil.getProperty("trustcode");
	
	private static final Logger logger = LoggerFactory.getLogger(AssetLossServiceImpl.class);
	
	/**
	 * 批量上报计提信息
	 */
	@Override
	public Map<String,ResultBean> reportAssetLoss(List<AssetLoss> all) {
		// TODO Auto-generated method stub
		Map<String,ResultBean> resultmap=new HashMap<String, ResultBean>();
		ObjectMapper om=new ObjectMapper();
		om.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, true);
		
		for(AssetLoss al:all) {
			try {
				String data=om.writeValueAsString(al);
				ResultBean rb = RestTemplateUtils.post(url, data);
				//上报成功后修改对应Flag
				if(rb.getResultCode().equals("0")){
					AssetLossExample ale=new AssetLossExample();
					//依据月份
					ale.createCriteria().andDateMonthEqualTo(al.getDateMonth());

					AssetLoss al2=new AssetLoss();
					al2.setFlag(1);
					int su=alm.updateByExampleSelective(al2, ale);
					logger.info("计提月份:{}上报成功! {}",al.getDateMonth(),su);
				}else {
					logger.info("计提月份:{}上传失败! {}",al.getDateMonth(),rb.getResultMsg());
				}
				//以主键为key，返回结果为result存入map
				resultmap.put(al.getDateMonth(), rb);
				logger.info("AssetLoss: {}",data);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultmap;
	}
	
	
	/**
	 * 根据年月(YYYYMM)申请删除计提信息
	 */
	@Override
	public Map<String, ResultBean> deleteAssetLoss(List<String> dateMonths) {
		
		Map<String,ResultBean> resultmap=new HashMap<String, ResultBean>();
		BaseReqBean brb=new BaseReqBean();
		for(String dt:dateMonths) {
			String reqId=trustcode+"AL"+dt;
			brb.setReqId(reqId);
			String str="clientId="+brb.getClientId()+"&reqId="+brb.getReqId()+"&roundStr="+brb.getRoundStr()+"&token="+brb.getToken()+"&appKey="+brb.getAppKey();
			String sign=Md5ToolUtil.getMd5Code(str);
			brb.setSign(sign);		
			ResultBean rb=RestTemplateUtils.delete(url, brb);
			resultmap.put(dt, rb);
		}
		return resultmap;
	}
	
	/**
	 * 获取未上报的计提信息
	 */
	@Override
	public List<AssetLoss> getUnflagAssetLossData() {
		
		AssetLossExample ale=new AssetLossExample();
		ale.createCriteria().andFlagIsNull();
		ale.or(ale.createCriteria().andFlagEqualTo(0));
		List<AssetLoss> all=alm.selectByExample(ale);
		
		for(AssetLoss al:all) {
			String reqId=trustcode+"CL"+al.getDateMonth();
			al.setReqId(reqId);
			logger.info("AssetLoss_reqId:{}",reqId);
			
			//组装签名
			String str="clientId="+al.getClientId()+"&dateMonth="+al.getDateMonth()+"&followBalance="+al.getFollowBalance()+"&followRate="+al.getFollowRate()+"&followReal="+al.getFollowReal()+"&lossBalance="+al.getLossBalance()+"&lossRate="+al.getLossRate()+"&lossReal="+al.getLossReal()+"&minorBalance="+al.getMinorBalance()+"&minorRate="+al.getMinorRate()+"&minorReal="+al.getMinorReal()+"&normalBalance="+al.getNormalBalance()+"&normalRate="+al.getNormalRate()+"&normalReal="+al.getNormalReal()+"&reqId="+al.getReqId()+"&roundStr="+al.getRoundStr()+"&suspiciousBalance="+al.getSuspiciousBalance()+"&suspiciousRate="+al.getSuspiciousRate()+"&suspiciousReal="+al.getSuspiciousReal()+"&token="+al.getToken()+"&appKey="+al.getAppKey();
			logger.info("AssetLoss签名字段：{}",str);
			String sign=Md5ToolUtil.getMd5Code(str);
			al.setSign(sign);
			logger.info("AssetLoss签名结果：{}",sign);
		}
		return all;
	}
}
