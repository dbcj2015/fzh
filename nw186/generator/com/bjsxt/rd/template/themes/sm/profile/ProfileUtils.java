package com.bjsxt.rd.template.themes.sm.profile;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ProfileUtils {
	private static Map<String , Profile> profiles = new LinkedHashMap();
	static{
		String dir = ProfileUtils.class.getResource("").getPath();
		try {
			dir = URLDecoder.decode(dir, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		File fdir = new File(dir);
		File[] list = fdir.listFiles();
		for(File jsonFile : list){
			if(jsonFile.getName().substring(jsonFile.getName().lastIndexOf(".")).equalsIgnoreCase(".json")){
				try {
					Profile p = new Profile(jsonFile);
					profiles.put(jsonFile.getName().substring(0,jsonFile.getName().lastIndexOf(".")).toLowerCase(), p);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					throw new RuntimeException(e);
				}
			}
		}
	}
	
	public static Profile getProfile(String profileName){
		return profiles.get(profileName.toLowerCase());
	}
	
	public static void main(String[] args) {
		System.out.println(ProfileUtils.getProfile("dept"));
	}
}
