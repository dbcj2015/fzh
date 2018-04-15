package ${basePackage}.${service.package};

import javax.annotation.Resource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import ${basePackage}.${repository.package}.${repository.class};

@Service("${service.beanId}")
@Transactional(rollbackFor=Exception.class)
public class ${service.class}{
	@Resource(name="${repository.beanId}")
	private ${repository.class} ${repository.beanId} = null;
	
	public void test(){
		System.out.println(${repository.beanId}.findByProperty(new HashMap()));
		System.out.println("TEST SUCCESS!!!");
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		${service.class} bean = (${service.class})ctx.getBean("${service.beanId}");
		bean.test();
	}
	
}
