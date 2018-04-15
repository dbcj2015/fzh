package com.bjsxt.jfinal.controller;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import com.bjsxt.jfinal.entity.Emp;
import com.bjsxt.jfinal.entity.Member;
import com.bjsxt.jfinal.entity.Person;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.jfinal.upload.UploadFile;
@SuppressWarnings("all")
public class HelloController extends Controller{
	
	public void hello(){
		
		//输入方法,getParaXXX \ getBean
		String name = this.getPara("name");//request.getParameter()
		Integer age = this.getParaToInt("age");
		
		//Jfinal中只支持struts2的属性驱动,要为实体赋值必须要在参数前增加p.
		Person person = this.getBean(Person.class, "p");
		//获取上传的文件,获取已上传的文件
		UploadFile uf = this.getFile("logfile");
		//这里要重命名文件
		//向Session\Request中存值
		this.setAttr("p", person);//向request中放属性
		this.setSessionAttr("sp", person);//向session中放属性
		
		
		//输出的时候使用renderXXX方法实现
		//renderXXX方法代表通过响应向客户端输出
		//this.renderHtml("<b>你好,世界,你好,童鞋们,我是老齐</b>");
		//this.renderText("<b>你好,世界,你好,童鞋们,我是老齐</b>");
		//this.renderJsp("/index.jsp");
		//this.renderFile(new File("c:/mysql-slow.log"));
		//Map result = new HashMap();
		//result.put("result", true);
		//result.put("message", "姓名:" + name + " | age:" + age);
		//this.renderJson(result);
		
		this.renderFreeMarker("/web-inf/ftl/index.ftl");
	}
	//开启声明式事务
	//方法执行成功提交,方法执行失败回滚
	@Before(Tx.class)
	public void testSave(){
		//调用方法后返回自己的设计方式叫做"构造者模式(Builder)"
		for(int i = 0 ; i < 10 ; i++){
			if(i==3){
				throw new RuntimeException("故意哒,嘿嘿嘿");
			}
			Emp e = new Emp();
			e.set("ename", "老气" + i)
			.set("job", "SALESMAN")
			.set("hiredate", new Date())
			.set("mgr" , 6666)
			.set("sal" , 7000f)
			.set("comm", 100f)
			.set("deptno", 10).save();
		}
		this.renderNull();//啥都不干
	}
	
	@Before(Tx.class)
	public void testUpdate(){
		Emp.dao.findById(7369)
			.set("ename", "威尔史密斯")
			.update();
		this.renderNull();//啥都不干
	}
	
	@Before(Tx.class)
	public void testDelete(){
		Emp.dao.deleteById(7900);//按ID查询
		Emp.dao.findById(7000).delete();//按对象删除
		this.renderNull();//啥都不干
	}
	
	public void testQuery(){
		//按编号参数化查询
		//findFirst查询唯一的记录, 第二个参数代表传入的参数值是什么
		//findFirst与Find方法格式相同,只是返回结果一个是 一个是Object List
		Emp.dao.findFirst("select * from emp where empno = ?" , new Object[]{7369});
		
		List<Emp> list = Emp.dao.find("select * from emp");
		for(Emp e : list){
			System.out.println(e.getStr("ename") + ":" + e.getDate("hiredate") + ":" + e.getFloat("comm"));
		}
		this.renderNull();
	}
	
	public void testJoinQuery(){
		List<Emp> list = Emp.dao.find("select * from emp e, dept d where e.deptno = d.deptno");
		for(Emp e : list){
			System.out.println(e.getStr("ename") + ":" + e.getDate("hiredate") + ":" + e.getFloat("comm") + ":" + e.getStr("dname"));
		}
		this.renderNull();
	}
	
	public void testPagination(){
		//select * from emp , sqlparser
		Page<Emp> p = Emp.dao.paginate(4, 10, "select * ", "from emp e,dept d where e.deptno = d.deptno and sal >= ?" , 1000f);
		System.out.println("当前页:" + p.getPageNumber() + ",总页数:" + p.getTotalPage() + ",总记录数:" + p.getTotalRow() );
		List<Emp> pageData = p.getList();
		for(Emp e : pageData){
			System.out.println(e.getStr("ename") + ":" + e.getDate("hiredate") + ":" + e.getFloat("comm") + ":" + e.getStr("dname"));
		}
		this.renderNull();
	}
	
	public void freemarker(){
		this.setAttr("name", "Request中的齐毅童鞋");
		this.setSessionAttr("pwd", "123456");
		List<Member> list = new ArrayList();
		for(int i = 1 ; i <= 10 ; i++){
			Member m = new Member();
			m.setJoinTime(new Date());
			m.setLevel(i%5);
			m.setName("michael jackson " + i);
			m.getOthers().put("ot1", "xxx");
			m.getOthers().put("ot2", "yyy");
			m.setPrice((i % 5) * 1000f);
			list.add(m);
		}
		this.setAttr("ms", list);
		
		// /开头代表绝对路径, 字母开头代表相对路径
		//相对路径时文件应保存的目录为: me.setBaseViewPath/命名空间/文件名
		this.renderFreeMarker("index.ftl");
	}
	
}
