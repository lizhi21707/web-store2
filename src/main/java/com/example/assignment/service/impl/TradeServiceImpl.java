package com.example.assignment.service.impl;

import com.example.assignment.dao.ITradeDao;
import com.example.assignment.meta.TradeItem;
import com.example.assignment.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("tradeService")
public class TradeServiceImpl implements TradeService {

	@Autowired
	private ITradeDao tradeDao;

	@Override
	public List<TradeItem> getTrades(Integer userId) {

		return tradeDao.getTrades(userId);
	}

	@Override
	public void addTradeItems(List<TradeItem> trades) {

		tradeDao.addTradeItems(trades);
	}

	@Override
	public TradeItem getTrade(Integer userId, Integer itemId) {

		return tradeDao.getTrade(userId, itemId);
	}

}
