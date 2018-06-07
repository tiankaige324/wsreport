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
import com.wsxd.main.dao.RepayInfoMapper;

import com.wsxd.main.entity.RepayInfo;
import com.wsxd.main.entity.RepayInfoExample;
import com.wsxd.main.entity.ResultBean;
import com.wsxd.main.utils.Md5ToolUtil;
import com.wsxd.main.utils.PropertyUtil;
import com.wsxd.main.utils.RestTemplateUtils;

@Service
public class RepayServiceImpl implements RepayService{
	
	@Autowired
	RepayInfoMapper rim;
	
	private String url=PropertyUtil.getProperty("url");
	
	private String trustcode=PropertyUtil.getProperty("trustcode");	
	
	private static final Logger logger = LoggerFactory.getLogger(RepayServiceImpl.class);

	@Override
	public Map<String, ResultBean> reportRepay(List<RepayInfo> ril) {
		Map<String,ResultBean> resultmap=new HashMap<String, ResultBean>();
		ObjectMapper om=new ObjectMapper();
		om.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, true);
		
		for(RepayInfo ri:ril) {
			try {
				String lcs=om.writeValueAsString(ri);
				if(ri.getExtendFlag()!=null && ri.getExtendFlag()>0) {
					ResultBean rb = RestTemplateUtils.post(url+"extend-repay", lcs);
					if(rb.getResultCode().equals("0")){
						RepayInfoExample exa=new RepayInfoExample();
						exa.createCriteria().andIdEqualTo(ri.getId());
						RepayInfo ri2=new RepayInfo();
						ri2.setFlag(1);
						int su=rim.updateByExampleSelective(ri2, exa);
						logger.info("展期还款ID:{}上报成功! {}",ri.getId(),su);
					}else {
						logger.info("展期还款ID:{}上传失败! {}",ri.getId(),rb.getResultMsg());
					}
					resultmap.put(ri.getId().toString(), rb);
				} else {
					ResultBean rb = RestTemplateUtils.post(url+"repay", lcs);
					if(rb.getResultCode().equals("0")){
						RepayInfoExample exa=new RepayInfoExample();
						exa.createCriteria().andIdEqualTo(ri.getId());
						RepayInfo ri2=new RepayInfo();
						ri2.setFlag(1);
						int su=rim.updateByExampleSelective(ri2, exa);
						logger.info("还款ID:{}上报成功! {}",ri.getId(),su);
					}else {
						logger.info("还款ID:{}上传失败! {}",ri.getId(),rb.getResultMsg());
					}
					resultmap.put(ri.getId().toString(), rb);
				}
				logger.info("RepayInfo: {}",ri);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return resultmap;
	}
	
	@Override
	public List<RepayInfo> getUnflagRepayInfo() {

		RepayInfoExample exa=new RepayInfoExample();
		exa.createCriteria().andFlagEqualTo(0);
		exa.or(exa.createCriteria().andFlagIsNull());
		List<RepayInfo> list=rim.selectByExample(exa);
		
		for(RepayInfo ri:list) {
			//组装reqId
			String reqId=trustcode+"RI"+ri.getId();
			ri.setReqId(reqId);
			logger.info("RepayInfo_reqId:{}",reqId);
			
			//组装签名
			String str="clientId="+ri.getClientId()+"&contractNumber="+ri.getContractNumber()+"&interest="+ri.getInterest()+"&money="+ri.getMoney()+"&otherCharge="+ri.getOtherCharge()+"&penalty="+ri.getPenalty()+"&penaltyInterest="+ri.getPenaltyInterest()+"&repayTime="+ri.getRepayTime()+"&reqId="+ri.getReqId()+"&roundStr="+ri.getRoundStr()+"&serviceCharge="+ri.getServiceCharge()+"&token="+ri.getToken()+"&appKey="+ri.getAppKey();
			logger.info("RepayInfo签名字段：{}",str);
			String sign=Md5ToolUtil.getMd5Code(str);
			ri.setSign(sign);
			logger.info("RepayInfo签名结果：{}",sign);
		}
		return list;
	}

}
