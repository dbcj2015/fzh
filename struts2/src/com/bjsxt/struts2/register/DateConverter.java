package com.bjsxt.struts2.register;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class DateConverter extends StrutsTypeConverter {

	@Override
	//Map是对应的上下文,values就是专门接收的是日期类型的数据
	public Object convertFromString(Map context, String[] values, Class target) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		String strDate=values[0];
		Date date=null;
		try {
			date=sdf.parse(strDate);
		} catch (ParseException e) {
			date = null;
		}
		return date;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
