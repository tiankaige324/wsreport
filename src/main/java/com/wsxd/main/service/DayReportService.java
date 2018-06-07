package com.wsxd.main.service;

import java.util.List;
import java.util.Map;

import com.wsxd.main.entity.DayReport;
import com.wsxd.main.entity.ResultBean;

public interface DayReportService {
	public Map<String,ResultBean> reportDayReport(List<DayReport> drl);
	public List<DayReport> getUnflagDayReportData();
}
