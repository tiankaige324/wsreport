package com.wsxd.main.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wsxd.main.entity.ResultBean;
import com.wsxd.main.service.AssetLossService;
import com.wsxd.main.service.ContractLossService;
import com.wsxd.main.service.DayReportService;
import com.wsxd.main.service.ExtendRepayPlanService;
import com.wsxd.main.service.LoanContractService;
import com.wsxd.main.service.LoanInfoService;
import com.wsxd.main.service.RepayService;



@Controller
@RequestMapping("/")
public class MainControl {
	@Autowired
	private LoanContractService lcs;
	@Autowired
	private LoanInfoService lis;
	@Autowired
	private RepayService rps;
	@Autowired
	private ExtendRepayPlanService erps;
	@Autowired
	private AssetLossService als;
	@Autowired
	private ContractLossService cls;
	@Autowired
	private DayReportService drs;
	
	@RequestMapping("test")
	@ResponseBody
	public String test(@RequestBody String req) {
		System.out.println("收到请求");

		return "success";
	}
	
	@RequestMapping("lc")
	@ResponseBody
	public Map<String,ResultBean> loanContract() throws Exception {	
		return lcs.reportLoanContract(lcs.getUnflagLoanContractData());
	}
	
	@RequestMapping("li")
	@ResponseBody
	public Map<String,ResultBean> loanInfo() throws Exception {	
		return lis.reportLoanInfo(lis.getUnflagLoanInfo());
	}
	
	@RequestMapping("rp")
	@ResponseBody
	public Map<String,ResultBean> repayInfo() throws Exception {	
		return rps.reportRepay(rps.getUnflagRepayInfo());
	}
	
	@RequestMapping("er")
	@ResponseBody
	public Map<String,ResultBean> extendRepayPlan() throws Exception {	
		return erps.reportUnflagExtendRepayPlan(erps.getUnflagExtendRepayPlan());
	}
	
	@RequestMapping("al")
	@ResponseBody
	public Map<String,ResultBean> assetLoss() throws Exception {	
		return als.reportAssetLoss(als.getUnflagAssetLossData());
	}
	
	@RequestMapping("cl")
	@ResponseBody
	public Map<String,ResultBean> contractLoss() throws Exception {	
		return cls.reportContractLoss(cls.getUnflagContractLossData());
	}
	
	@RequestMapping("dr")
	@ResponseBody
	public Map<String,ResultBean> dayReport() throws Exception {	
		return drs.reportDayReport(drs.getUnflagDayReportData());
	}
}
