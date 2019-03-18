package com.netease.assignment.service.impl;

import com.netease.assignment.dao.ITradeDao;
import com.netease.assignment.meta.TradeItem;
import com.netease.assignment.service.TradeService;
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
