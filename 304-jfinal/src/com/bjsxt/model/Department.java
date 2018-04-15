package com.bjsxt.model;

import com.jfinal.plugin.activerecord.Model;
//MVC
//MVC 分层各司其职  V -> 视图层  HTML/JSP
//C: Controller ->控制层 ,接收数据，调用Model处理数据，响应结果
//M: Model -> 模型层， 用来处理业务逻辑并与数据库交互 ，在Jfinal中通常我们将Model与Service等价
public class Department extends Model<Department>{
	//Department既可以当实体类，也是Service。这玩意即多功能与一身，简化了程序的操作
		public void createDept(Department d){
			//将结果新增到数据库
			d.save();//继承model方法
			
		}
}
