package com.bjsxt.tmal;

public class Goods {
	public Goods(String type, String brand, String product, float price,
			Integer num) {
		super();
		this.type = type;
		this.brand = brand;
		this.product = product;
		this.price = price;
		this.num = num;
	}
	private String type;
	private String brand;
	private String product;
	private float price;
	private Integer num;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	} 
}
