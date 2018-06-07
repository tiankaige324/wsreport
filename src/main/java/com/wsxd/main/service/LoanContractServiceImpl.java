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
import com.wsxd.main.dao.LoanContractMapper;
import com.wsxd.main.dao.RepayPlanMapper;
import com.wsxd.main.entity.BaseReqBean;
import com.wsxd.main.entity.LoanContract;
import com.wsxd.main.entity.LoanContractExample;

import com.wsxd.main.entity.PersonBorrower;
import com.wsxd.main.entity.RepayPlan;
import com.wsxd.main.entity.RepayPlanExample;
import com.wsxd.main.entity.ResultBean;
import com.wsxd.main.utils.Md5ToolUtil;
import com.wsxd.main.utils.PropertyUtil;
import com.wsxd.main.utils.RestTemplateUtils;



@Service
public class LoanContractServiceImpl implements LoanContractService {
	
	@Autowired
	LoanContractMapper lcm;

	@Autowired
	RepayPlanMapper rpm;
	private String url=PropertyUtil.getProperty("url")+"loan-contract";
	
	private String trustcode=PropertyUtil.getProperty("trustcode");
	
	private static final Logger logger = LoggerFactory.getLogger(LoanContractServiceImpl.class);
	
	/**
	 * 批量上报贷款合同
	 */
	@Override
	public Map<String,ResultBean> reportLoanContract(List<LoanContract> LoanContracts) {
		
		Map<String,ResultBean> resultmap=new HashMap<String, ResultBean>();
		ObjectMapper om=new ObjectMapper();
		om.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, true);
		
		for(LoanContract lc:LoanContracts) {
			try {
				String lcs=om.writeValueAsString(lc);
				ResultBean rb = RestTemplateUtils.post(url, lcs);
				if(rb.getResultCode().equals("0")){
					LoanContractExample lce=new LoanContractExample();
					lce.createCriteria().andContractNumberEqualTo(lc.getContractNumber());
					LoanContract lc2=new LoanContract();
					lc2.setFlag(1);
					int su=lcm.updateByExampleSelective(lc2, lce);
					logger.info("合同编号:{}上报成功! {}",lc.getContractNumber(),su);
				}else {
					logger.info("合同编号:{}上传失败! {}",lc.getContractNumber(),rb.getResultMsg());
				}
				resultmap.put(lc.getContractNumber(), rb);
				logger.info("LoanContract: {}",lcs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultmap;
	}
	
	/**
	 * 通过合同号申请删除已上报合同数据
	 */
	@Override
	public Map<String,ResultBean> deleteLoanContract(List<String> ContractNumberList) {
		
		Map<String,ResultBean> resultmap=new HashMap<String, ResultBean>();
		BaseReqBean brb=new BaseReqBean();
		for(String cn:ContractNumberList) {
			String reqId=trustcode+cn;
			brb.setReqId(reqId);
			String str="clientId="+brb.getClientId()+"&reqId="+brb.getReqId()+"&roundStr="+brb.getRoundStr()+"&token="+brb.getToken()+"&appKey="+brb.getAppKey();
			String sign=Md5ToolUtil.getMd5Code(str);
			brb.setSign(sign);		
			ResultBean rb=RestTemplateUtils.delete(url, brb);
			if(rb.getResultCode().equals("0")){
				lcm.deleteContract(cn);
				logger.info("合同编号:{}删除成功!",cn);
			}else{
				logger.info("合同编号:{}删除失败! {}",cn,rb.getResultMsg());
			}
			resultmap.put(cn, rb);
		}
		return resultmap;
	}
	
	/**
	 *  通过合同号获取合同数据
	 */
	public LoanContract getLoanContractDataByNumber(String ContractNumber) {
		
		//获取基本数据
		LoanContract lcb=lcm.selectByPrimaryKey(ContractNumber);
		
		String reqId=trustcode+lcb.getContractNumber();
		lcb.setReqId(reqId);
		logger.info("reqId:{}",reqId);
		
		//组装签名
		String str="borrowerType="+lcb.getBorrowerType()+"&clientId="+lcb.getClientId()+"&business="+lcb.getBusiness()+"&money="+lcb.getMoney()+"&contractNumber="+lcb.getContractNumber()+"&contractName="+lcb.getContractName()+"&endDate="+lcb.getEndDate()+"&startDate="+lcb.getStartDate()+"&loanMethod="+lcb.getLoanMethod()+"&repayMethod="+lcb.getRepayMethod()+"&term="+lcb.getTerm()+"&termType="+lcb.getTermType()+"&purpose="+lcb.getPurpose()+"&rate="+lcb.getRate()+"&rateType="+lcb.getRateType()+"&repaySource="+lcb.getRepaySource()+"&reqId="+lcb.getReqId()+"&roundStr="+lcb.getRoundStr()+"&signTime="+lcb.getSignTime()+"&token="+lcb.getToken()+"&appKey="+lcb.getAppKey();
		logger.info("签名字段：{}",str);
		String sign=Md5ToolUtil.getMd5Code(str);
		lcb.setSign(sign);
		logger.info("签名结果：{}",sign);
		
		//组装借款人信息
		PersonBorrower pb=new PersonBorrower();
		pb.setName(lcb.getName());
		pb.setSex(lcb.getSex());
		pb.setCardType(lcb.getCardType());
		pb.setCardNumber(lcb.getCardNumber());
		pb.setPhone(lcb.getPhone());
		pb.setIsFarmer(lcb.getIsFarmer());
		pb.setEducation(lcb.getEducation());
		pb.setEmail(lcb.getEmail());
		pb.setIsMarry(lcb.getIsMarry());
		pb.setNationality(lcb.getNationality());
		pb.setBirthday(lcb.getBirthday());
		pb.setNation(lcb.getNation());
		pb.setAddress(lcb.getAddress());
		pb.setPostCode(lcb.getPostCode());
		pb.setRegisteredAddress(lcb.getRegisteredAddress());
		pb.setNativePlace(lcb.getNativePlace());
		pb.setWorkUnit(lcb.getWorkUnit());
		pb.setPosition(lcb.getPosition());
		
		lcb.setPersonBorrower(pb);
		
		//组装还款计划
		RepayPlanExample rpe=new RepayPlanExample();
		rpe.createCriteria().andContractNumberEqualTo(lcb.getContractNumber());
		List<RepayPlan> rpl=rpm.selectByExample(rpe);
		lcb.setRepayPlans(rpl);
		
		return lcb;
	}
	
	/**
	 * 获取所有未上报合同数据
	 */
	@Override
	public List<LoanContract> getUnflagLoanContractData() {
		// TODO Auto-generated method stub
		LoanContractExample lce=new LoanContractExample();
		lce.createCriteria().andFlagEqualTo(0);
		lce.or(lce.createCriteria().andFlagIsNull());
		List<LoanContract> lcl=lcm.selectByExample(lce);
		
		for(LoanContract lc:lcl) {
			String reqId=trustcode+"LC"+lc.getContractNumber();
			lc.setReqId(reqId);
			logger.info("reqId:{}",reqId);
			
			//组装签名
			String str="borrowerType="+lc.getBorrowerType()+"&clientId="+lc.getClientId()+"&business="+lc.getBusiness()+"&money="+lc.getMoney()+"&contractNumber="+lc.getContractNumber()+"&contractName="+lc.getContractName()+"&endDate="+lc.getEndDate()+"&startDate="+lc.getStartDate()+"&loanMethod="+lc.getLoanMethod()+"&repayMethod="+lc.getRepayMethod()+"&term="+lc.getTerm()+"&termType="+lc.getTermType()+"&purpose="+lc.getPurpose()+"&rate="+lc.getRate()+"&rateType="+lc.getRateType()+"&repaySource="+lc.getRepaySource()+"&reqId="+lc.getReqId()+"&roundStr="+lc.getRoundStr()+"&signTime="+lc.getSignTime()+"&token="+lc.getToken()+"&appKey="+lc.getAppKey();
			logger.info("签名字段：{}",str);
			String sign=Md5ToolUtil.getMd5Code(str);
			lc.setSign(sign);
			logger.info("签名结果：{}",sign);
			
			//组装借款人信息
			PersonBorrower pb=new PersonBorrower();
			pb.setName(lc.getName());
			pb.setSex(lc.getSex());
			pb.setCardType(lc.getCardType());
			pb.setCardNumber(lc.getCardNumber());
			pb.setPhone(lc.getPhone());
			pb.setIsFarmer(lc.getIsFarmer());
			pb.setEducation(lc.getEducation());
			pb.setEmail(lc.getEmail());
			pb.setIsMarry(lc.getIsMarry());
			pb.setNationality(lc.getNationality());
			pb.setBirthday(lc.getBirthday());
			pb.setNation(lc.getNation());
			pb.setAddress(lc.getAddress());
			pb.setPostCode(lc.getPostCode());
			pb.setRegisteredAddress(lc.getRegisteredAddress());
			pb.setNativePlace(lc.getNativePlace());
			pb.setWorkUnit(lc.getWorkUnit());
			pb.setPosition(lc.getPosition());
			lc.setPersonBorrower(pb);

			//组装还款计划
			RepayPlanExample rpe=new RepayPlanExample();
			rpe.createCriteria().andContractNumberEqualTo(lc.getContractNumber());
			lc.setRepayPlans(rpm.selectByExample(rpe));
		}
		return lcl;
	}


}
