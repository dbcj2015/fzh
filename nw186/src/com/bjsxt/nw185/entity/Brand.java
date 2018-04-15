package com.bjsxt.nw185.entity;
import java.util.Date;
import java.io.Serializable;

public class Brand implements  Serializable{
	
	private Integer brandId;
	private String brandName;


	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}	
	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}	
	
}
