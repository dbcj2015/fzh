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
	//һ�������ÿһ��TestCase����testXXX��ͷ��
	public void testFindById(){
	   SqlSession ss=ssf.openSession();
	   Emp idEmp= ss.selectOne("emp.findById", 7934);
		System.out.println(idEmp.getEname());
	}
	
	@Test
	//ͨ����Map�н�����ѯ�Ľ���Զ�����
	public void testSelectAll(){
		 SqlSession ss=ssf.openSession();
		 List<Map> list = ss.selectList("emp.selectAll");
		 System.out.println(list);
	}
	
	@Test
	//ͨ��ʵ���ౣ�����ѯ�Ľ��
	public void testFindEntity(){
		 SqlSession ss=ssf.openSession();
		 List<Emp> list = ss.selectList("emp.entity");
		for(Emp emp:list){
			System.out.println(emp.getD().getDname());
		}
	}
	
	//�����ݿ����ֶ����д����»���ʱ��ͨ��ʵ����洢����ʱ������java���������򲻿���ʹ���»��ߣ�ͨ������:
	//	<settings>
	//	<!-- �Զ�ת��Ϊ�շ����� -->
	//		<setting name="mapUnderscoreToCamelCase" value="true"/>
	//	</settings
	//����ʵ�ֽ������»��ߵ��ֶ��Զ�ת��Ϊ:user_name-->userName
	
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
