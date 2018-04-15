package com.bjsxt.nw185.entity;
import java.util.Date;
import java.io.Serializable;

public class Vender implements  Serializable{
	
	private Integer venderId;
	private String venderName;


	public Integer getVenderId() {
		return venderId;
	}

	public void setVenderId(Integer venderId) {
		this.venderId = venderId;
	}	
	public String getVenderName() {
		return venderName;
	}

	public void setVenderName(String venderName) {
		this.venderName = venderName;
	}	
	
}
