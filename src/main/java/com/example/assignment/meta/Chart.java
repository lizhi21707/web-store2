package com.example.assignment.meta;

import java.util.HashMap;
import java.util.Map;

public class Chart {

    private static ThreadLocal<Chart> localChart = new ThreadLocal<>();

    private Map<Integer, ChartItem> chartItems;

    public Chart() {
        chartItems = new HashMap<>();
    }

    public static Chart getChart() {
        return localChart.get();
    }

    public static void removeLocalChart() {
        localChart.remove();
    }

    public static void setLocalChart(Chart chart) {
        localChart.set(chart);
    }

    public void addChartItem(ChartItem chartItem) {

        chartItems.put(chartItem.getItemId(), chartItem);
    }

    public ChartItem getChartItem(Integer itemId) {

        return chartItems.get(itemId);
    }

    public void deleteChartItem(Integer itemId) {

        chartItems.remove(itemId);
    }

    public void updateChartItem(ChartItem chartItem) {

        chartItems.put(chartItem.getItemId(), chartItem);
    }

    public void clearChart() {

        chartItems.clear();
    }

    public Map<Integer, ChartItem> getChartItems() {

        return chartItems;
    }

}
