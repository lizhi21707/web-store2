package com.netease.assignment.web.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.File;

public class PublishForm {

	private Integer itemId;

	@NotNull
	@Size(min = 2, max = 80)
	private String itemTitle;

	@NotNull
	@Size(min = 2, max = 140)
	private String itemAbstract;

	@NotNull
	private Double itemPrice;

	@NotNull
	@Size(min = 2, max = 1000)
	private String itemTotal;

	@NotNull
	private String imgRadio;

	private String inputUrl;

	private File inputFile;

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

	public String getItemAbstract() {

		return itemAbstract;
	}

	public void setItemAbstract(String itemAbstract) {

		this.itemAbstract = itemAbstract;
	}

	public Double getItemPrice() {

		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {

		this.itemPrice = itemPrice;
	}

	public String getItemTotal() {

		return itemTotal;
	}

	public void setItemTotal(String itemTotal) {

		this.itemTotal = itemTotal;
	}

	public String getImgRadio() {

		return imgRadio;
	}

	public void setImgRadio(String imgRadio) {

		this.imgRadio = imgRadio;
	}

	public String getInputUrl() {

		return inputUrl;
	}

	public void setInputUrl(String inputUrl) {

		this.inputUrl = inputUrl;
	}

	public File getInputFile() {

		return inputFile;
	}

	public void setInputFile(File inputFile) {

		this.inputFile = inputFile;
	}

}
