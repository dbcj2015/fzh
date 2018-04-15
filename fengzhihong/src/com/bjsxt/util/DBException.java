package com.bjsxt.util;

public class DBException extends Exception{
	//ClassNotFoundException 
	public DBException(String msg){
		super(msg);
	}
	public DBException(Exception e){
		super(e);
	}
}
