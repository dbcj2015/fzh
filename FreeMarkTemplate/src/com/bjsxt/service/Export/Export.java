package com.bjsxt.service.Export;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import com.bjsxt.entity.Poem;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class Export {
	private List<Poem> getDataSource(){
		List<Poem> list = new ArrayList();
		
		Poem p1 = new Poem();
		p1.setTitle("登高");
		p1.setAuthor("杜甫");
		p1.getParagraphs().add("风急天高猿啸哀，渚清沙白鸟飞回。");
		p1.getParagraphs().add("无边落木萧萧下，不尽长江滚滚来。");
		p1.getParagraphs().add("万里悲秋常作客，百年多病独登台。");
		p1.getParagraphs().add("艰难苦恨繁霜鬓，潦倒新停浊酒杯。");
		list.add(p1);
		
		Poem p2 = new Poem();
		p2.setTitle("春雨");
		p2.setAuthor("李商隐");
		p2.getParagraphs().add("怅卧新春白袷衣，白门寥落意多违。");
		p2.getParagraphs().add("红楼隔雨相望冷，珠箔飘灯独自归。");
		p2.getParagraphs().add("远路应悲春晼晚，残宵犹得梦依稀。");
		p2.getParagraphs().add("玉珰缄札何由达，万里云罗一雁飞。");
		list.add(p2);
		return list;
	}
	//实现写入本地的文件以FreeMarker指定的格式写入
	public File export(){
		File f = new File("c:/300/poems.txt");
		try{
			//初始化FM
			Configuration conf = new Configuration();
			//定义FM的目录
			//首先java运行的文件是class二进制文件,web工程中所有的.java文件的编译文件.class存在于
			//MyEclipseWorkSpace/FreeMarkPoet/WebRoot/WEB-INF/classes/目录下
			File ftlDir = new File(this.getClass().getResource("/").getPath() + "/ftl"); 
			//返回的是classpath的位置:this.getClass().getResource("/")
			System.out.println(this.getClass().getResource("/").getPath());
			System.out.println(ftlDir);
			System.out.println();
			//设置模板目录:Template模板
			conf.setDirectoryForTemplateLoading(ftlDir);
			//设置字符集,解决中文乱码
			conf.setDefaultEncoding("UTF-8");
			//加载poem.ftl模板
			Template t = conf.getTemplate("poem.ftl");
			//Map 作为DataModel
			Map dataModel  = new HashMap();
			//将数据存储到poems的key中,在ftl中可以被读取出来
			dataModel.put("poems", this.getDataSource());
			//输出到字符文件中
			FileWriter fos = new FileWriter(f);
			//将dataModel中的数据吸入到poem.ftl模板中,保存到c:/300/poems.txt文件下
			t.process(dataModel, fos);
			//将文件在控制台输出
			t.process(dataModel, new OutputStreamWriter(System.out));
			fos.close();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return f;
	}
	
	public static void main(String[] args) {
		System.out.println(new Export().export());
	}
}
