package com.bjsxt.base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** * �շ巨-�»��߻�ת * @author cshaper * @since 2015.07.04 * @version 1.0.0 */
public class StringUtils {
	/**
	 * * �»���ת�շ巨 * @param line Դ�ַ��� * @param smallCamel ��С�շ�,�Ƿ�ΪС�շ� * @return
	 * ת������ַ���
	 */
	public static String underline2Camel(String line, boolean smallCamel) {
		if (line == null || "".equals(line)) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		Pattern pattern = Pattern.compile("([A-Za-z\\d]+)(_)?");
		Matcher matcher = pattern.matcher(line);
		while (matcher.find()) {
			String word = matcher.group();
			sb.append(smallCamel && matcher.start() == 0 ? Character
					.toLowerCase(word.charAt(0)) : Character.toUpperCase(word
					.charAt(0)));
			int index = word.lastIndexOf('_');
			if (index > 0) {
				sb.append(word.substring(1, index).toLowerCase());
			} else {
				sb.append(word.substring(1).toLowerCase());
			}
		}
		return sb.toString();
	}

	/** * �շ巨ת�»��� * @param line Դ�ַ��� * @return ת������ַ��� */
	public static String camel2Underline(String line) {
		if (line == null || "".equals(line)) {
			return "";
		}
		line = String.valueOf(line.charAt(0)).toUpperCase()
				.concat(line.substring(1));
		StringBuffer sb = new StringBuffer();
		Pattern pattern = Pattern.compile("[A-Z]([a-z\\d]+)?");
		Matcher matcher = pattern.matcher(line);
		while (matcher.find()) {
			String word = matcher.group();
			sb.append(word.toUpperCase());
			sb.append(matcher.end() == line.length() ? "" : "_");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String line = "goodstype_id";
		String camel = underline2Camel(line, true);
		System.out.println(camel);
		System.out.println(camel2Underline(camel));
	}
}
