package com.wsxd.main.service;


import java.util.List;
import java.util.Map;

import com.wsxd.main.entity.LoanContract;
import com.wsxd.main.entity.ResultBean;

public interface LoanContractService {
	/**
	 * 贷款合同上报
	 */
	public Map<String,ResultBean> reportLoanContract(List<LoanContract> LoanContracts);
	/**
	 * 贷款合同删除上报
	 * @return
	 */
	public Map<String,ResultBean> deleteLoanContract(List<String> ContractNumber);
	/**
	 * 获取所有未上报贷款合同
	 * @return
	 */
	public List<LoanContract> getUnflagLoanContractData();
	/**
	 * 通过合同号获取合同信息
	 * @param ContractNumber
	 * @return
	 */
	public LoanContract getLoanContractDataByNumber(String ContractNumber);
}
