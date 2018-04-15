package com.bjsxt.entity;
import java.util.Date;
import java.io.Serializable;

public class Product implements  Serializable{
	
	private Integer productId;
	private String productName;
	private Integer goodstypeId;
	private Integer brandId;


	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}	
	public Integer getGoodstypeId() {
		return goodstypeId;
	}

	public void setGoodstypeId(Integer goodstypeId) {
		this.goodstypeId = goodstypeId;
	}	
	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}	
	
}
