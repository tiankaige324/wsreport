package com.wsxd.main.service;

import java.util.List;
import java.util.Map;

import com.wsxd.main.entity.ContractLoss;
import com.wsxd.main.entity.ResultBean;

public interface ContractLossService {
	public Map<String,ResultBean> reportContractLoss(List<ContractLoss> cll);
	public List<ContractLoss> getUnflagContractLossData();
	public Map<String, ResultBean> deleteContractLoss(List<String> contractNumberList);
}
