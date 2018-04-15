package com.bjsxt.nw185.base.utils;

import net.sourceforge.pinyin4j.PinyinHelper;

public class PinYinUtils {
	public static String toQuanPin(String source){
		char[] chars = new char[source.length()];
		//将每一个文字转为char保存在数组
		for(int i = 0 ; i < source.length() ; i++){
			String str = source.substring(i,i+1);
			chars[i] = str.toCharArray()[0];
		}
		
		StringBuffer fullpy = new StringBuffer();
		for(char c : chars){
			String pinyin = PinyinHelper.toHanyuPinyinStringArray(c)[0];
			pinyin = pinyin.substring(0,pinyin.length()-1);
			fullpy.append(pinyin);
		}
		return fullpy.toString();
		
	}
	
	public static String toJianPin(String source){
		char[] chars = new char[source.length()];
		//将每一个文字转为char保存在数组
		for(int i = 0 ; i < source.length() ; i++){
			String str = source.substring(i,i+1);
			chars[i] = str.toCharArray()[0];
		}
		
		StringBuffer jianpin = new StringBuffer();
		for(char c : chars){
			String pinyin = PinyinHelper.toHanyuPinyinStringArray(c)[0];
			pinyin = pinyin.substring(0,1);
			jianpin.append(pinyin);
		}
		return jianpin.toString();
		
	}
	public static void main(String[] args) {
		System.out.println(PinYinUtils.toJianPin("河北省工商银行省行"));
		System.out.println(PinYinUtils.toQuanPin("河北省工商银行省行"));
	}
}
