package com.netease.assignment.dao;

import com.netease.assignment.meta.TradeItem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ITradeDao {

	// 账务
	// 获取所有的交易记录
	public List<TradeItem> getTrades(Integer userId);

	// 从购物车购买，转换为交易
	public void addTradeItems(List<TradeItem> trades);

	public TradeItem getTrade(Integer userId, Integer itemId);
}
