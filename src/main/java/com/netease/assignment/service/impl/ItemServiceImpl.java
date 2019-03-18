package com.netease.assignment.service.impl;

import com.netease.assignment.dao.IItemDao;
import com.netease.assignment.meta.Item;
import com.netease.assignment.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

	@Autowired
	private IItemDao itemDao;

	@Override
	public List<Item> getItems() {

		return itemDao.getItems();
	}

	@Override
	public List<Item> getBoughtItems(Integer userId) {

		return itemDao.getBoughtItems(userId);
	}

	@Override
	public List<Item> getUnBoughtItems(Integer userId) {

		return itemDao.getUnBoughtItems(userId);
	}

	@Transactional
	@Override
	public void addItem(Item item) {

		itemDao.addItem(item);
		Integer itemId = itemDao.getMaxItemId();
		item.setItemId(itemId);
	}

	@Override
	public void deleteItem(Integer itemId) {

		itemDao.deleteItem(itemId);
	}

	@Override
	public Item getItem(Integer itemId) {

		return itemDao.getItem(itemId);
	}

	@Override
	public void updateItem(Item item) {

		itemDao.updateItem(item);
	}

	@Override
	public List<Item> getSellerItems(Integer sellerId) {

		return itemDao.getSellerItems(sellerId);
	}

}
