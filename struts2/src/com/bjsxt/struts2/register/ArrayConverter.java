package com.bjsxt.struts2.register;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;
/**
 * 将数组转为List
 * @author iqiyi
 *
 */
public class ArrayConverter extends StrutsTypeConverter{
	//将字符串转为对象
	@Override
	public Object convertFromString(Map context, String[] values, Class target) {
		List list = Arrays.asList(values);//Arrays.asList(values)将数组转为ArrayList
		return list;
	}

	//将对象转为字符串
	@Override
	public String convertToString(Map arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
