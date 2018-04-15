package com.bjsxt.hibernate.entity;

public class Goods {
	private Integer goodsId;
	private String title;
	private String subTitle;
	private Float originalCost;
	private Float currentPrice;
	private Float discount;
	private Integer isFreeDelivery;
	private Integer stock;
	private String sourceUrl;
	private Integer categoryId;
	private Integer hpShow;
	private Integer isHot;
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public Float getOriginalCost() {
		return originalCost;
	}
	public void setOriginalCost(Float originalCost) {
		this.originalCost = originalCost;
	}
	public Float getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(Float currentPrice) {
		this.currentPrice = currentPrice;
	}
	public Float getDiscount() {
		return discount;
	}
	public void setDiscount(Float discount) {
		this.discount = discount;
	}
	public Integer getIsFreeDelivery() {
		return isFreeDelivery;
	}
	public void setIsFreeDelivery(Integer isFreeDelivery) {
		this.isFreeDelivery = isFreeDelivery;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getSourceUrl() {
		return sourceUrl;
	}
	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getHpShow() {
		return hpShow;
	}
	public void setHpShow(Integer hpShow) {
		this.hpShow = hpShow;
	}
	public Integer getIsHot() {
		return isHot;
	}
	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}
	
}
