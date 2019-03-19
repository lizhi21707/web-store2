package com.example.assignment.service;

import com.example.assignment.meta.ChartItem;

import java.util.Map;

public interface ChartService {

	public void addChartItem(ChartItem chart);

	public Map<Integer, ChartItem> getChartItems(Integer userId);

	public void clearChart(Integer userId);

	public void updateChartItem(ChartItem chart);

	public void buyAll(Integer userId);
}
