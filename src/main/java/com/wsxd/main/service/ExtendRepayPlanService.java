package com.wsxd.main.service;

import java.util.List;
import java.util.Map;

import com.wsxd.main.entity.RepayPlan;
import com.wsxd.main.entity.ResultBean;

public interface ExtendRepayPlanService {
	public Map<String, ResultBean> reportUnflagExtendRepayPlan(List<RepayPlan> rpl);
	public List<RepayPlan> getUnflagExtendRepayPlan();
}
