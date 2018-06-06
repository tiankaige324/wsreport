package com.wsxd.main.controller;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wsxd.main.entity.LoanContract;
import com.wsxd.main.entity.ResultBean;
import com.wsxd.main.service.LoanContractService;
import com.wsxd.main.service.LoanInfoService;
import com.wsxd.main.service.RepayService;
//import com.wsxd.main.service.LoanContractService;
import com.wsxd.main.utils.PropertyUtil;
import com.wsxd.main.utils.RestTemplateUtils;






@Controller
@RequestMapping("/")
public class MainControl {
	@Autowired
	LoanContractService lcs;
	@Autowired
	LoanInfoService lis;
	@Autowired
	RepayService rps;

	String url=PropertyUtil.getProperty("url");
	
	@RequestMapping("test")
	@ResponseBody
	public String test(@RequestBody String req) {
		System.out.println("收到请求");

		return "success";
	}
	
	@RequestMapping("t")
	@ResponseBody
	public Map<String,ResultBean> ss() throws Exception {	
		return lcs.reportLoanContract(lcs.getUnflagLoanContractData());
	//	return null;
	}
	
	@RequestMapping("li")
	@ResponseBody
	public Map<String,ResultBean> loanInfo() throws Exception {	
		return lis.reportLoanInfo(lis.getUnflagLoanInfo());
	//	return null;
	}
	
	@RequestMapping("rp")
	@ResponseBody
	public Map<String,ResultBean> repayInfo() throws Exception {	
		return rps.reportRepay(rps.getUnflagRepayInfo());
	//	return null;
	}
}
