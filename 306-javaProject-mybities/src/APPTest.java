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

//mybatis��ibatis��ͬһ�����
public class APPTest {
	public static void main(String[] args) throws IOException {
		//��ȡ classes�µ�mybatis.xml�����ļ�
		InputStream is=Resources.getResourceAsStream("mybities.xml");
		//����SessionFactory ��SessionFactory��MyBatis����ĵĶ����ڳ�ʼ��SessionFactory��ʱ��
		//���Զ������ݿ����ӳؽ��г�ʼ�����������е����ݿ����Ӷ���SqlSession������SessionFactory��������
		SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(is);
		//SqlSession�������Ҫ���������һ�����ݿ�ķ��ʺͽ����ӳ��
		SqlSession ss=ssf.openSession();
		//��ѯ���е�����select
		
		List<Map> list = ss.selectList("emp.selectAll");//sql���õĹ���:�����ռ�(ǰ׺).SqlId
		System.out.println(list);
		HashMap map=new HashMap<>();
		map.put("name", "����");
		
		//����ȡ�����ݴ洢��Map������
//		for(Map m:list){
//			System.out.println(m.get("ename"));
//		}
		
		//����ѯ�����ݴ洢���Զ����ʵ������
//		List<Emp> listEntity = ss.selectList("emp.entity");
//		for(Emp e:listEntity){
//			System.out.println(e.getEname());
//		}
		
		//��������
//		Emp emp=new Emp();
//		emp.setEname("Will Smith");
//		emp.setDeptno(10);
//		emp.setComm(100);
//		emp.setHiredate(new Date());
//		emp.setJob("Writer");
//		emp.setMgr(7499);
//		emp.setSal(199);
//		ss.insert("emp.insert",emp);
		
		
		//��������
		//�޸Ĳ���,�޸Ĳ����Ĺ켣��      ��ȡԭʼ����->�޸�����->���½��
//		Emp emp=new Emp();
//		Emp updateEmp = ss.selectOne("emp.findById", 7935);
//		updateEmp.setEname("Marry");
//		ss.update("emp.update", updateEmp);
//		
//		//ɾ������
//		ss.delete("emp.delete", 7935);
//		ss.commit();
//		ss.close();
		
		
	}
}
