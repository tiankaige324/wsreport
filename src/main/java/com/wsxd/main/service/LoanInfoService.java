package com.wsxd.main.service;

import java.util.List;
import java.util.Map;

import com.wsxd.main.entity.LoanInfo;
import com.wsxd.main.entity.ResultBean;

public interface LoanInfoService {
	public Map<String, ResultBean> reportLoanInfo(List<LoanInfo> lis);
	public Map<String, ResultBean> deleteLoanInfo(String id);
	public List<LoanInfo> getUnflagLoanInfo();
}
