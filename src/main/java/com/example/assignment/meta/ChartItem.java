package com.example.assignment.meta;

public class ChartItem {

	private Integer id;

	private Integer userId;

	private Integer itemId;
	private String itemTitle;
	private double price;

	private int count;

	public Integer getId() {

		return id;
	}

	public void setId(Integer id) {

		this.id = id;
	}

	public Integer getUserId() {

		return userId;
	}

	public void setUserId(Integer userId) {

		this.userId = userId;
	}

	public Integer getItemId() {

		return itemId;
	}

	public void setItemId(Integer itemId) {

		this.itemId = itemId;
	}

	public String getItemTitle() {

		return itemTitle;
	}

	public void setItemTitle(String itemTitle) {

		this.itemTitle = itemTitle;
	}

	public double getPrice() {

		return price;
	}

	public void setPrice(double price) {

		this.price = price;
	}

	public int getCount() {

		return count;
	}

	public void setCount(int count) {

		this.count = count;
	}

}
