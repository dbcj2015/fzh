package com.bjsxt.nw185.dao;

import org.springframework.stereotype.Repository;
import java.util.*;
import com.bjsxt.nw185.entity.*;

public interface AssetDAO{
	public void insert(Asset entity);
	public void update(Asset entity);
	public void delete(Integer assetId);
	public Asset findById(Integer assetId);
	public List<Map> findByProperty(Map params);
	public Long countByProperty(Map params);
	public List<Map> groupStoreAsset();
}
