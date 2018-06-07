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
import com.wsxd.main.dao.ContractLossMapper;
import com.wsxd.main.entity.BaseReqBean;
import com.wsxd.main.entity.ContractLoss;
import com.wsxd.main.entity.ContractLossExample;
import com.wsxd.main.entity.ResultBean;
import com.wsxd.main.utils.Md5ToolUtil;
import com.wsxd.main.utils.PropertyUtil;
import com.wsxd.main.utils.RestTemplateUtils;

@Service
public class ContractLossServiceImpl implements ContractLossService{
	@Autowired
	ContractLossMapper clm;
	
	private String url=PropertyUtil.getProperty("url")+"contract-loss";
	
	private String trustcode=PropertyUtil.getProperty("trustcode");
	
	private static final Logger logger = LoggerFactory.getLogger(ContractLossServiceImpl.class);
	
	/**
	 * 批量上报坏账信息
	 */
	@Override
	public Map<String,ResultBean> reportContractLoss(List<ContractLoss> cll) {
		// TODO Auto-generated method stub
		Map<String,ResultBean> resultmap=new HashMap<String, ResultBean>();
		ObjectMapper om=new ObjectMapper();
		om.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, true);
		
		for(ContractLoss cl:cll) {
			try {
				String data=om.writeValueAsString(cl);
				ResultBean rb = RestTemplateUtils.post(url, data);
				//上报成功后修改对应Flag
				if(rb.getResultCode().equals("0")){
					ContractLossExample cle=new ContractLossExample();
					//依据ID更新
					cle.createCriteria().andContractNumberEqualTo(cl.getContractNumber());

					ContractLoss cl2=new ContractLoss();
					cl2.setFlag(1);
					int su=clm.updateByExampleSelective(cl2, cle);
					logger.info("坏账合同编号:{}上报成功! {}",cl.getContractNumber(),su);
				}else {
					logger.info("坏账合同编号:{}上传失败! {}",cl.getContractNumber(),rb.getResultMsg());
				}
				//以主键为key，返回结果为result存入map
				resultmap.put(cl.getContractNumber(), rb);
				logger.info("ContractLoss: {}",data);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultmap;
	}
	
	/**
	 * 根据合同号申请删除坏账信息
	 */
	@Override
	public Map<String, ResultBean> deleteContractLoss(List<String> contractNumberList) {
		
		Map<String,ResultBean> resultmap=new HashMap<String, ResultBean>();
		BaseReqBean brb=new BaseReqBean();
		for(String cn:contractNumberList) {
			String reqId=trustcode+"CL"+cn;
			brb.setReqId(reqId);
			String str="clientId="+brb.getClientId()+"&reqId="+brb.getReqId()+"&roundStr="+brb.getRoundStr()+"&token="+brb.getToken()+"&appKey="+brb.getAppKey();
			String sign=Md5ToolUtil.getMd5Code(str);
			brb.setSign(sign);		
			ResultBean rb=RestTemplateUtils.delete(url, brb);
			if(rb.getResultCode().equals("0")){
				clm.deleteContractLoss(cn);
				logger.info("坏账合同编号:{}删除成功!",cn);
			}else{
				logger.info("坏账合同编号:{}删除失败! {}",cn,rb.getResultMsg());
			}
			resultmap.put(cn, rb);
		}
		return resultmap;
	}
	
	
	/**
	 * 获取所有未上传的坏账信息
	 */
	@Override
	public List<ContractLoss> getUnflagContractLossData() {
		
		ContractLossExample cle=new ContractLossExample();
		cle.createCriteria().andFlagIsNull();
		cle.or(cle.createCriteria().andFlagEqualTo(0));
		List<ContractLoss> cll=clm.selectByExample(cle);
		
		for(ContractLoss cl:cll) {
			String reqId=trustcode+"CL"+cl.getContractNumber();
			cl.setReqId(reqId);
			logger.info("ContractLoss_reqId:{}",reqId);
			
			//组装签名
			String str="badMoney="+cl.getBadMoney()+"&clientId="+cl.getClientId()+"&contractNumber="+cl.getContractNumber()+"&lossDate="+cl.getLossDate()+"&reqId="+cl.getLossDate()+"&roundStr="+cl.getRoundStr()+"&token="+cl.getToken()+"&appKey="+cl.getAppKey();
			logger.info("ContractLoss签名字段：{}",str);
			String sign=Md5ToolUtil.getMd5Code(str);
			cl.setSign(sign);
			logger.info("ContractLoss签名结果：{}",sign);
		}
		return cll;
	}
}
