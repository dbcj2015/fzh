package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeapOutOfMemoryTest {
	private String[] strings=new String[1000];
	
	public static void main(String[] args) {
		
		List list=new ArrayList();
		Integer i=0;
		do {
			HeapOutOfMemoryTest homt=new HeapOutOfMemoryTest();
			list.add(homt);
			i++;
			homt=null;
		}while(true);
	}
}
