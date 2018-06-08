package com.wsxd.main.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.wsxd.main.service.AssetLossService;
import com.wsxd.main.service.ContractLossService;
import com.wsxd.main.service.DayReportService;
import com.wsxd.main.service.ExtendRepayPlanService;
import com.wsxd.main.service.LoanContractService;
import com.wsxd.main.service.LoanContractServiceImpl;
import com.wsxd.main.service.LoanInfoService;
import com.wsxd.main.service.RepayService;

@Component
public class Tasks {
	
	private static final Logger logger = LoggerFactory.getLogger(Tasks.class);
	
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
	
	
	@Scheduled(cron="0/5 * * * * ?")
	public void mission() {
		System.out.println("定时任务启动");
	}
	
	@Scheduled(cron="0 0/1 * * * ?")
	public void day() {
		logger.info("合同上报定时任务启动");
		lcs.reportLoanContract(lcs.getUnflagLoanContractData());
		logger.info("放款信息上报定时任务启动");
		lis.reportLoanInfo(lis.getUnflagLoanInfo());
		logger.info("还款信息上报定时任务启动");
		rps.reportRepay(rps.getUnflagRepayInfo());
		logger.info("展期还款计划上报定时任务启动");
		erps.reportUnflagExtendRepayPlan(erps.getUnflagExtendRepayPlan());
		logger.info("坏账上报定时任务启动");
		cls.reportContractLoss(cls.getUnflagContractLossData());
		logger.info("日结信息上报定时任务启动");
		drs.reportDayReport(drs.getUnflagDayReportData());
	}
	
	@Scheduled(cron="0 0/1 * * * ?")
	public void moon() {
		logger.info("计提上报定时任务启动");
		als.reportAssetLoss(als.getUnflagAssetLossData());		
	}
}
