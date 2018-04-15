package com.bjsxt.nw185.entity;
import java.util.Date;
import java.io.Serializable;

public class DistributionDetail implements  Serializable{
	
	private Integer ddId;
	private Integer assetId;
	private Integer distId;


	public Integer getDdId() {
		return ddId;
	}

	public void setDdId(Integer ddId) {
		this.ddId = ddId;
	}	
	public Integer getAssetId() {
		return assetId;
	}

	public void setAssetId(Integer assetId) {
		this.assetId = assetId;
	}	
	public Integer getDistId() {
		return distId;
	}

	public void setDistId(Integer distId) {
		this.distId = distId;
	}	
	
}
