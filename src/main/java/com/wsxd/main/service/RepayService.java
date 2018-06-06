package com.wsxd.main.service;

import java.util.List;
import java.util.Map;

import com.wsxd.main.entity.RepayInfo;
import com.wsxd.main.entity.ResultBean;

public interface RepayService {
	public Map<String, ResultBean> reportRepay(List<RepayInfo> ril);
	public List<RepayInfo> getUnflagRepayInfo();
}
