package com.wsxd.main.service;

import java.util.List;
import java.util.Map;

import com.wsxd.main.entity.AssetLoss;
import com.wsxd.main.entity.ResultBean;

public interface AssetLossService {
	public Map<String,ResultBean> reportAssetLoss(List<AssetLoss> all);
	public List<AssetLoss> getUnflagAssetLossData();
	public Map<String, ResultBean> deleteAssetLoss(List<String> dateMonths);
}
