package com.bjsxt.nw185.base.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BeanUtils {
	
	/**
	 * 将List中每一个Map中的key转为驼峰命名
	 * 例如 
	 * key: emp_code_id    value: 1
	 * 转换后变为
	 * key: empCodeId  value:1
	 * 同时 ,原有emp_id仍然存在
	 * @param source
	 * @return
	 */
	public static List<Map> converToCamel(List<Map> sourceList){
		for(Map source : sourceList){
			converToCamel(source);
		}
		return sourceList;
	}
	
	public static Map converToCamel(Map source){
		Iterator itr = source.entrySet().iterator();
		Map appendMap = new LinkedHashMap();
		while(itr.hasNext()){
			Map.Entry<String,Object> me = (Map.Entry)itr.next();
			String key = me.getKey();
			if(key.indexOf("_") != -1){//需要转换
				String convertKey = StringUtils.underline2Camel(key, true);
				appendMap.put(convertKey, me.getValue());
			}
		}
		source.putAll(appendMap);
		return source;
	}
	
	public static void main(String[] args) {
		List list = new ArrayList();
		
		for(int i = 0 ; i < 100 ; i++){
			Map map  = new HashMap();
			map.put("i_b_" + i, "TEST");
			list.add(map);
		}
		
		System.out.println(BeanUtils.converToCamel(list));
	}
}
