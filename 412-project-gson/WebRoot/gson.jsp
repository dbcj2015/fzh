<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%--
	gson的引进:
		响应数据：
			后台响应的数据一定是字符串数据，所以需要将list中的数据遍历出来拼接成字符串
		 问题：
			1、需要遍历list集合，麻烦
			2、拼接字符串比较麻烦
			3、拼接键值对，不同的对象数据还必须分开。
		解决：使用json格式	
			String str=new Gson().toJson(list)
				--通过这种方式就可以将list中的每个java对象转化为多个json格式对象的数组字符串,使用eval函数将整个字符串转化为数组
				一个java对象对应一个json格式的字符串，这样前台可以使用eval函数将字符串转换为js对象。
				一个java数组或者集合对象对应成一个js的数组。
			工具类：
			Gson
			注意:使用json工具类，必须使用gson.jar包
 js中创建对象:自定义对象；使用gson创建对象
 js创建自定义对象:
				var 对象名=new Object()
			简写:	
				var 对象名={};
				对象名.属性名=属性值;
				对象名.属性名=属性值;
				……
				对象名.属性名=属性值;
			注意：
				在js中创建的对象是具备类原有内容的同时，可以自定义的进行对象内容的扩充或者添加。
		json格式学习：
			var 对象名={
				属性名:属性值,
				属性名:属性值,
				……
				属性名:属性值
			}
	注意:对象和数组之间是有区别的:
		1、数组的声明
			var 数组名=[初始化元素(可写可不写)];
			var 数组名=new Array(初始化长度，可写可不写);
		2、js中自定义对象与java对象的区别
			java中创建对象之前首先创建一个类，类中有什么属性，对应的对象中就会有相应的对象属性
			不可能像js对象中可以添加任何类型的对象数据
		3、eval()函数操作的是字符串
 --%>
 
 <html>
 	<head>
 		<script type="text/javascript">
 			//创建自定义对象--函数也是一个对象
	 			var obj1=new Object();
	 			obj1.name="张三";
	 			obj1.age=23;
	 			obj1.test=function(){
	 				alert("我是函数");
	 			}
	 			alert(obj1.name);
	 			obj1.test();
 			//创建自定义对象--在js中创建的对象是具备类原有内容的同时，可以自定义的进行对象内容的扩充或者添加
 			//date属于js对象
 				var date=new Date();
 					date.name="李四";
 					alert(date);
 					alert(date.name);
 			//使用json格式创建对象
 				var obj2={
 					name:"王五",
 					age:34
 				}
 			//json结合eval函数使用--得到的是数组
 				var str="{name:'冯巩',age:56}";
 			//以下方式创建一个对象，但是没有引用指向该对象
 				//eval(str)
 			//创建一个标准的对象
 				eval("var user="+str);
 				alert(user.age);
 			//多个对象的存储应该使用数组
 				var arrGeson=[{name:"刘冰峰",age:34},{name:"冯志红",age:25}];
 			alert(arrGeson);
 			alert(arrGeson[0].name);
 		</script>
 	</head>
 	<body>
 	</body>
 </html>

 
 
 
 
 
 
 
 
 
 
 
 
 