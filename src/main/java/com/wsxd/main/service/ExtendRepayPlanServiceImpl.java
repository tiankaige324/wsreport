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
import com.wsxd.main.dao.RepayPlanMapper;
import com.wsxd.main.entity.RepayPlan;
import com.wsxd.main.entity.RepayPlanExample;
import com.wsxd.main.entity.ResultBean;
import com.wsxd.main.utils.Md5ToolUtil;
import com.wsxd.main.utils.PropertyUtil;
import com.wsxd.main.utils.RestTemplateUtils;
@Service
public class ExtendRepayPlanServiceImpl implements ExtendRepayPlanService{
	@Autowired
	RepayPlanMapper rpm;
	
	private String url=PropertyUtil.getProperty("url")+"extend-repay-plan";
	
	private String trustcode=PropertyUtil.getProperty("trustcode");	
	
	private static final Logger logger = LoggerFactory.getLogger(ExtendRepayPlanServiceImpl.class);
	
	@Override
	public Map<String, ResultBean> reportUnflagExtendRepayPlan(List<RepayPlan> rpl) {
		
		Map<String,ResultBean> resultmap=new HashMap<String, ResultBean>();
		ObjectMapper om=new ObjectMapper();
		om.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, true);
		
		for(RepayPlan rp:rpl) {
			try {
				String data = om.writeValueAsString(rp);
				logger.info("ExtendRepayPlan:{}",data);
				ResultBean result = RestTemplateUtils.post(url, data);
				if(result.getResultCode().equals("0")) {
					RepayPlanExample lie=new RepayPlanExample();
					lie.createCriteria().andIdEqualTo(rp.getId());
					RepayPlan rp2=new RepayPlan();
					rp2.setFlag(1);
					int su=rpm.updateByExampleSelective(rp2, lie);
					logger.info("展期还款计划ID:{}上报成功! {}",rp.getId(),su);
				}else {
					logger.info("展期还款计划ID:{}上传失败! {}",rp.getId(),result.getResultMsg());
				}
				resultmap.put(rp.getId().toString(), result);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return resultmap;
	}
	
	
	@Override
	public List<RepayPlan> getUnflagExtendRepayPlan() {

		RepayPlanExample exa=new RepayPlanExample();
		exa.createCriteria().andFlagEqualTo(0).andExtendCountGreaterThan(0);
		exa.or(exa.createCriteria().andFlagIsNull().andExtendCountGreaterThan(0));
		List<RepayPlan> list=rpm.selectByExample(exa);
		
		for(RepayPlan rp:list) {
			//组装reqId
			String reqId=trustcode+"ER"+rp.getId();
			rp.setReqId(reqId);
			logger.info("ExtendRepayPlan_id:{}",reqId);
			
			//组装签名
			String str="clientId="+rp.getClientId()+"&contractNumber="+rp.getContractNumber()+"&count="+rp.getExtendCount()+"&reqId="+rp.getReqId()+"&roundStr="+rp.getRoundStr()+"&token="+rp.getToken()+"&appKey="+rp.getAppKey();
			logger.info("ExtendRepayPlan签名字段：{}",str);
			String sign=Md5ToolUtil.getMd5Code(str);
			rp.setSign(sign);
			logger.info("ExtendRepayPlan签名结果：{}",sign);
		}
		return list;
	}
}
