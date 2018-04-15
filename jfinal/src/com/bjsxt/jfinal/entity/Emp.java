package com.bjsxt.jfinal.entity;

import com.jfinal.plugin.activerecord.Model;

//实体类要继承Model类
//Model类既是实体类,又能当DAO类
public class Emp extends Model<Emp>{
	public static Emp dao = new Emp();
}
