import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.bjsxt.dao.EmpDao;
import com.bjsxt.util.MybatisUtil;
import com.google.gson.Gson;


public class EmpDaoTest {
	@Test
	public void testFindAll(){
		//�ײ����ö�̬����ģʽ,�Զ�����EmpDAO�ӿڵ�ʵ����,�������㲻���Լ�дdao��
		SqlSession ss = MybatisUtil.getSessionFactory().openSession();
		EmpDao dao = (EmpDao)ss.getMapper(EmpDao.class);
		List<Map>  list = dao.findAll();
		System.out.println(new Gson().toJson(list));
		ss.close();
	}
	
	@Test
	public void testFindById() {
		SqlSession session = MybatisUtil.getSessionFactory().openSession();
		EmpDao dao = (EmpDao)session.getMapper(EmpDao.class);
		Map map = dao.findById(7369);
		System.out.println(new Gson().toJson(map));
		session.close();
	}
	
	@Test
	public void testFindPage() {
		SqlSession session = MybatisUtil.getSessionFactory().openSession();
		//�ײ����ö�̬����ģʽ,�Զ�����EmpDAO�ӿڵ�ʵ����,�������㲻���Լ�д�ģ�����
		EmpDao dao = (EmpDao)session.getMapper(EmpDao.class);
		List<Map>  list = dao.findPage(10,5);
		System.out.println(new Gson().toJson(list));
		session.close();
	}
}
