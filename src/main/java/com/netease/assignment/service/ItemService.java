package com.netease.assignment.service;

import com.netease.assignment.meta.Item;

import java.util.List;

public interface ItemService {

	public List<Item> getItems();

	public List<Item> getBoughtItems(Integer userId);

	// 如果只有一个用户，则就是指销量为0的物品
	public List<Item> getUnBoughtItems(Integer userId);

	public void addItem(Item item);

	public void deleteItem(Integer itemId);

	public Item getItem(Integer itemId);

	public void updateItem(Item item);
	
	public List<Item> getSellerItems(Integer sellerId);
}
