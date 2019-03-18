package com.netease.assignment.dao;

import com.netease.assignment.meta.Item;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface IItemDao {

	public void addItem(Item item);

	public void deleteItem(Integer itemId);

	public Item getItem(Integer itemId);

	public void updateItem(Item item);

	public List<Item> getItems();

	public List<Item> getBoughtItems(Integer userId);

	public List<Item> getUnBoughtItems(Integer userId);

	public Integer getMaxItemId();

	public List<Item> getSellerItems(Integer sellerId);

}
