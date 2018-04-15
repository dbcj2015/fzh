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
		//底层利用动态代理模式,自动生成EmpDAO接口的实现类,我们总算不用自己写dao了
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
		//底层利用动态代理模式,自动生成EmpDAO接口的实现类,我们总算不用自己写ＤＡＯ啦
		EmpDao dao = (EmpDao)session.getMapper(EmpDao.class);
		List<Map>  list = dao.findPage(10,5);
		System.out.println(new Gson().toJson(list));
		session.close();
	}
}
