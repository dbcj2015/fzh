import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.bjsxt.entity.Emp;

public class MyBatiesTestCase {
	
	SqlSessionFactory ssf=null;
	public MyBatiesTestCase() throws IOException{
		InputStream is = Resources.getResourceAsStream("com/bjsxt/junitmap/myJunitEmp.xml");
		ssf=new SqlSessionFactoryBuilder().build(is);
	}
	
	@Test
	//一般情况下每一个TestCase都是testXXX开头的
	public void testFindById(){
	   SqlSession ss=ssf.openSession();
	   Emp idEmp= ss.selectOne("emp.findById", 7934);
		System.out.println(idEmp.getEname());
	}
	
	@Test
	//通过再Map中将多表查询的结果自动保存
	public void testSelectAll(){
		 SqlSession ss=ssf.openSession();
		 List<Map> list = ss.selectList("emp.selectAll");
		 System.out.println(list);
	}
	
	@Test
	//通过实体类保存多表查询的结果
	public void testFindEntity(){
		 SqlSession ss=ssf.openSession();
		 List<Emp> list = ss.selectList("emp.entity");
		for(Emp emp:list){
			System.out.println(emp.getD().getDname());
		}
	}
	
	//当数据库中字段名中存在下划线时，通过实体类存储数据时，由于java中命名规则不可以使用下划线，通过引入:
	//	<settings>
	//	<!-- 自动转换为驼峰命名 -->
	//		<setting name="mapUnderscoreToCamelCase" value="true"/>
	//	</settings
	//可以实现将带有下划线的字段自动转变为:user_name-->userName
	
	@Test
	public void testSalPriceEntity(){
		 SqlSession ss=ssf.openSession();
		 List<Emp> list = ss.selectList("emp.sal_price");
		for(Emp emp:list){
			System.out.println(emp.getSalPrice());
		}
	}
	
	@Test
	public void testCamelCase(){
		 SqlSession ss=ssf.openSession();
		 List<Emp> list = ss.selectList("emp.CamelCase");
		for(Emp emp:list){
			System.out.println(emp.getSalPrice());
		}
	}
}
