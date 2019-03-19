package com.example.assignment.service;

import com.example.assignment.meta.TradeItem;

import java.util.List;

public interface TradeService {

	public List<TradeItem> getTrades(Integer userId);

	public void addTradeItems(List<TradeItem> trades);
	
	public TradeItem getTrade(Integer userId, Integer itemId);
}
