package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestNull {
	public static void main(String[] args) {
		List<Map> list=null;
		System.out.println(list);
		if(list==null){
			list=new ArrayList<>();
			System.out.println(list);
		}
		for(Map map:list){
			System.out.println(map);
		}
	}
	
}
