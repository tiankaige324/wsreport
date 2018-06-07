package com.wsxd.main.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wsxd.main.dao.LoanInfoMapper;

import com.wsxd.main.entity.LoanInfo;
import com.wsxd.main.entity.LoanInfoExample;

import com.wsxd.main.entity.ResultBean;
import com.wsxd.main.utils.Md5ToolUtil;
import com.wsxd.main.utils.PropertyUtil;
import com.wsxd.main.utils.RestTemplateUtils;

@Service
public class LoanInfoServiceImpl implements LoanInfoService{
	
	@Autowired
	LoanInfoMapper lfm;
	
	private String url=PropertyUtil.getProperty("url")+"loan-info";
	
	private String trustcode=PropertyUtil.getProperty("trustcode");	
	
	private static final Logger logger = LoggerFactory.getLogger(LoanInfoServiceImpl.class);
	
	@Override
	public Map<String, ResultBean> reportLoanInfo(List<LoanInfo> lis) {
		
		Map<String,ResultBean> resultmap=new HashMap<String, ResultBean>();
		ObjectMapper om=new ObjectMapper();
		om.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, true);
		
		for(LoanInfo li:lis) {
			try {
				String data = om.writeValueAsString(li);
				logger.info("LoanInfo:{}",data);
				ResultBean result = RestTemplateUtils.post(url, data);
				if(result.getResultCode().equals("0")) {
					LoanInfoExample lie=new LoanInfoExample();
					lie.createCriteria().andIdEqualTo(li.getId());
					LoanInfo li2=new LoanInfo();
					li2.setFlag(1);
					int su=lfm.updateByExampleSelective(li2, lie);
					logger.info("放款ID:{}上报成功! {}",li.getId(),su);
				}else {
					logger.info("放款ID:{}上传失败! {}",li.getId(),result.getResultMsg());
				}
				resultmap.put(li.getId().toString(), result);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return resultmap;
	}
	
	
	@Override
	public Map<String, ResultBean> deleteLoanInfo(String id) {
		int lid=Integer.valueOf(id);
		
		return null;
	}
	
	@Override
	public List<LoanInfo> getUnflagLoanInfo() {

		LoanInfoExample exa=new LoanInfoExample();
		exa.createCriteria().andFlagEqualTo(0);
		exa.or(exa.createCriteria().andFlagIsNull());
		List<LoanInfo> list=lfm.selectByExample(exa);
		
		for(LoanInfo li:list) {
			//组装reqId
			String reqId=trustcode+"LI"+li.getId();
			li.setReqId(reqId);
			logger.info("LoanInfo_reqId:{}",reqId);
			
			//组装签名
			String str="clientId="+li.getClientId()+"&reqId="+li.getReqId()+"&roundStr="+li.getRoundStr()+"&token="+li.getToken()+"&contractNumber="+li.getContractNumber()+"&money="+li.getMoney()+"&loanTime="+li.getLoanTime()+"&appKey="+li.getAppKey();
			logger.info("LoanInfo签名字段：{}",str);
			String sign=Md5ToolUtil.getMd5Code(str);
			li.setSign(sign);
			logger.info("LoanInfo签名结果：{}",sign);
		}
		return list;
	}
	
}
