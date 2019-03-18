package com.netease.assignment.service;

import com.netease.assignment.meta.ChartItem;

import java.util.Map;

public interface ChartService {

	public void addChartItem(ChartItem chart);

	public Map<Integer, ChartItem> getChartItems(Integer userId);

	public void clearChart(Integer userId);

	public void updateChartItem(ChartItem chart);

	public void buyAll(Integer userId);
}
