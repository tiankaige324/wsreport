package com.wsxd.main.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wsxd.main.dao.RepayPlanMapper;
import com.wsxd.main.entity.ExtendPlan;
import com.wsxd.main.entity.ExtendRepayPlan;
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
	public Map<String, ResultBean> reportUnflagExtendRepayPlan(List<ExtendRepayPlan> rpl) {
		
		Map<String,ResultBean> resultmap=new HashMap<String, ResultBean>();
		ObjectMapper om=new ObjectMapper();
		om.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, true);
		
		for(ExtendRepayPlan rp:rpl) {
			try {
				String data = om.writeValueAsString(rp);
				logger.info("ExtendRepayPlan:{}",data);
				ResultBean result = RestTemplateUtils.post(url, data);
				if(result.getResultCode().equals("0")) {
					RepayPlanExample lie=new RepayPlanExample();
					lie.createCriteria().andContractNumberEqualTo(rp.getContractNumber()).andExtendCountEqualTo(rp.getCount());
					RepayPlan rp2=new RepayPlan();
					rp2.setFlag(1);
					int su=rpm.updateByExampleSelective(rp2, lie);
					logger.info("合同号：{} 第{}次展期: 还款计划上报成功! {}",rp.getContractNumber(),rp.getCount(),su);
				}else {
					logger.info("合同号：{} 第{}次展期: 还款计划上报失败! {}",rp.getContractNumber(),rp.getCount(),result.getResultMsg());
				}
				resultmap.put(rp.getContractNumber()+"-"+rp.getCount(), result);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return resultmap;
	}
	
	
	@Override
	public List<ExtendRepayPlan> getUnflagExtendRepayPlan() {

		RepayPlanExample exa=new RepayPlanExample();
		exa.createCriteria().andFlagEqualTo(0).andExtendCountGreaterThan(0);
		exa.or(exa.createCriteria().andFlagIsNull().andExtendCountGreaterThan(0));
		List<RepayPlan> list=rpm.selectByExample(exa);

		Map<String,List<ExtendPlan>> emap=new HashMap<String, List<ExtendPlan>>();
		
		for(RepayPlan rp:list) {
			String key=rp.getContractNumber()+"-"+rp.getExtendCount();
			if(emap.containsKey(key)) {
				List<ExtendPlan> epl=emap.get(key);
				ExtendPlan ep=new ExtendPlan();
				ep.setPrincipal(rp.getMoney());
				ep.setInterest(rp.getInterest());
				ep.setEndDate(rp.getEndDate());
				epl.add(ep);
				emap.put(key, epl);
			}else {
				List<ExtendPlan> epl=new ArrayList<>();
				ExtendPlan ep=new ExtendPlan();
				ep.setPrincipal(rp.getMoney());
				ep.setInterest(rp.getInterest());
				ep.setEndDate(rp.getEndDate());
				epl.add(ep);
				emap.put(key, epl);
			}
		}
		
		
		List<ExtendRepayPlan> res=new ArrayList<>();
		for(Entry<String,List<ExtendPlan>> entry:emap.entrySet()) {
			ExtendRepayPlan erp=new ExtendRepayPlan();
			erp.setContractNumber(entry.getKey().substring(0, entry.getKey().lastIndexOf("-")));
			erp.setCount(Integer.valueOf(entry.getKey().substring(entry.getKey().lastIndexOf("-")+1)));			
			erp.setPlans(entry.getValue());
			String reqId=trustcode+"ER"+entry.getKey();
			erp.setReqId(reqId);
			logger.info("ExtendRepayPlan_reqId:{}",reqId);
			
			//组装签名
			String str="clientId="+erp.getClientId()+"&contractNumber="+erp.getContractNumber()+"&count="+erp.getCount()+"&reqId="+erp.getReqId()+"&roundStr="+erp.getRoundStr()+"&token="+erp.getToken()+"&appKey="+erp.getAppKey();
			logger.info("ExtendRepayPlan签名字段：{}",str);
			String sign=Md5ToolUtil.getMd5Code(str);
			erp.setSign(sign);
			logger.info("ExtendRepayPlan签名结果：{}",sign);
						
			res.add(erp);
		}
			
		return res;
	}
}
