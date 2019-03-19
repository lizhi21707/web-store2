package com.example.assignment.meta;

public class Item {

    private Integer itemId;
    private String itemTitle;
    private Double itemPrice;
    private String itemAbstract;
    private String itemContent;
    private String imageLocation;
    private String locationType;
    private String valid;

    // 数量，可以是销量或者是购物车数量
    private Integer count = 0;

    private Integer sellerId;

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

    public Double getItemPrice() {

        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {

        this.itemPrice = itemPrice;
    }

    public String getItemAbstract() {

        return itemAbstract;
    }

    public void setItemAbstract(String itemAbstract) {

        this.itemAbstract = itemAbstract;
    }

    public String getItemContent() {

        return itemContent;
    }

    public void setItemContent(String itemContent) {

        this.itemContent = itemContent;
    }

    public String getImageLocation() {

        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {

        this.imageLocation = imageLocation;
    }

    public String getLocationType() {

        return locationType;
    }

    public void setLocationType(String locationType) {

        this.locationType = locationType;
    }

    public String getValid() {

        return valid;
    }

    public void setValid(String valid) {

        this.valid = valid;
    }

    public Integer getCount() {

        return count;
    }

    public void setCount(Integer count) {

        this.count = count;
    }

    public Integer getSellerId() {

        return sellerId;
    }

    public void setSellerId(Integer sellerId) {

        this.sellerId = sellerId;
    }

}
