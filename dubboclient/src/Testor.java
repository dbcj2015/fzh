import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.service.NewsService;


public class Testor {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		NewsService ns = (NewsService)ctx.getBean("newsService");
		List list = ns.getNews();
		System.out.println(list.size());
	}
}
