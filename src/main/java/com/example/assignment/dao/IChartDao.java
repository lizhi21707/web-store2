package com.example.assignment.dao;

import com.example.assignment.meta.ChartItem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface IChartDao {

	public void addChartItem(ChartItem chart);

	public List<ChartItem> getChartItems(Integer userId);

	public void deleteChartItem(Integer itemId);

	public void updateChartItem(ChartItem chartItem);
}
