package com.bjsxt.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ApplicateDiscount {
	private Map ioc = new HashMap();
	public ApplicateDiscount(){
		//java��Դ����λ�����пռ���src���£������ɵ��ֽ����ļ���BinĿ¼���Լ������ļ�Ҳ����binĿ¼��
		String filePath  = this.getClass().getResource("/").getPath() + "/applicationContext.properties";
//		System.out.println(this.getClass().getResource("/").getPath());
//		System.out.println(filePath);
	
			try {
				InputStream is=new FileInputStream(filePath);
				Properties prop=new Properties();
				prop.load(is);
				String clazzName = prop.getProperty("discount");
				Object obj = Class.forName(clazzName).newInstance();
				ioc.put("discountObj", obj);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				
				e.printStackTrace();
			} catch (IllegalAccessException e) {
		
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
	}
	
	//���ض�Ӧ��Ķ���
	public Object getBean(String key){
		return ioc.get(key);
	}
	
	public static void main(String[] args) {
		ApplicateDiscount applicateDiscount=new ApplicateDiscount();
		
	}
}
