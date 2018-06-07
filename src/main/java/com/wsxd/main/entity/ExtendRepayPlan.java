package com.wsxd.main.entity;

import java.util.List;

public class ExtendRepayPlan extends BaseReqBean{
	private List<ExtendPlan> plans;
	private String contractNumber;
	private Integer count;
	public List<ExtendPlan> getPlans() {
		return plans;
	}
	public void setPlans(List<ExtendPlan> plans) {
		this.plans = plans;
	}
	public String getContractNumber() {
		return contractNumber;
	}
	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
}
