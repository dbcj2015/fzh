package com.bjsxt.nw185.base.utils;

import org.apache.commons.codec.digest.DigestUtils;




public class SecurityUtils {
	public static  String toMD5Hex(String source , String salt){ //salt 盐值
		
		source = source.substring(0,2) + salt.substring(0,2) + source.substring(2) + salt.substring(2);
		String encode =  source;
		for(int i=0 ; i< 10 ; i++){
			encode = DigestUtils.md5Hex(encode);
		}
		return encode;//经过MD5加密后的字符串
	}
	
	public static void main(String[] args) {
		System.out.println(SecurityUtils.toMD5Hex("123456" , "3w22"));
		System.out.println(SecurityUtils.toMD5Hex("123456" , "33f2"));
		System.out.println(SecurityUtils.toMD5Hex("123455" , "3^22"));
	}
}
