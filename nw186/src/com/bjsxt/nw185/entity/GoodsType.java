package com.bjsxt.nw185.entity;
import java.util.Date;
import java.io.Serializable;

public class GoodsType implements  Serializable{
	
	private Integer goodstypeId;
	private String goodstypeName;


	public Integer getGoodstypeId() {
		return goodstypeId;
	}

	public void setGoodstypeId(Integer goodstypeId) {
		this.goodstypeId = goodstypeId;
	}	
	public String getGoodstypeName() {
		return goodstypeName;
	}

	public void setGoodstypeName(String goodstypeName) {
		this.goodstypeName = goodstypeName;
	}	
	
}
