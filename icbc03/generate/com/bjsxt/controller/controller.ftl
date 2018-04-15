package ${basePackage}.${controller.package};

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ${basePackage}.${model.package}.${model.class};
import ${basePackage}.${service.package}.${service.class};

@Controller("${controller.beanId}")
@RequestMapping("${controller.namespace}")
public class ${controller.class} {
	@Resource(name="${service.beanId}")
	private ${service.class} service = null;
	
}
