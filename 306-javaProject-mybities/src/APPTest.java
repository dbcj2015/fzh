import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bjsxt.map.entity.Emp;

//mybatis和ibatis是同一个框架
public class APPTest {
	public static void main(String[] args) throws IOException {
		//读取 classes下的mybatis.xml配置文件
		InputStream is=Resources.getResourceAsStream("mybities.xml");
		//构建SessionFactory ，SessionFactory是MyBatis最核心的对象，在初始化SessionFactory的时候
		//就自动将数据库连接池进行初始化，并且所有的数据库连接对象SqlSession都是由SessionFactory来创建的
		SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(is);
		//SqlSession对象的主要功能是完成一次数据库的访问和结果的映射
		SqlSession ss=ssf.openSession();
		//查询所有的数据select
		
		List<Map> list = ss.selectList("emp.selectAll");//sql调用的规则:命名空间(前缀).SqlId
		System.out.println(list);
		HashMap map=new HashMap<>();
		map.put("name", "张三");
		
		//将读取的数据存储到Map对象中
//		for(Map m:list){
//			System.out.println(m.get("ename"));
//		}
		
		//将查询的数据存储到自定义的实体类中
//		List<Emp> listEntity = ss.selectList("emp.entity");
//		for(Emp e:listEntity){
//			System.out.println(e.getEname());
//		}
		
		//插入数据
//		Emp emp=new Emp();
//		emp.setEname("Will Smith");
//		emp.setDeptno(10);
//		emp.setComm(100);
//		emp.setHiredate(new Date());
//		emp.setJob("Writer");
//		emp.setMgr(7499);
//		emp.setSal(199);
//		ss.insert("emp.insert",emp);
		
		
		//更新数据
		//修改操作,修改操作的轨迹是      获取原始数据->修改内容->更新结果
//		Emp emp=new Emp();
//		Emp updateEmp = ss.selectOne("emp.findById", 7935);
//		updateEmp.setEname("Marry");
//		ss.update("emp.update", updateEmp);
//		
//		//删除数据
//		ss.delete("emp.delete", 7935);
//		ss.commit();
//		ss.close();
		
		
	}
}
