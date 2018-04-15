package ${basePackage}.${controller.package};

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.List;
import java.util.LinkedHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;

import ${basePackage}.${model.package}.${model.class};
import ${basePackage}.${service.package}.${service.class};

@Controller("${controller.beanId}")
@RequestMapping("${controller.namespace}")
public class ${controller.class} {
	@Resource(name="${service.beanId}")
	private ${service.class} ${service.beanId} = null;
	
	@RequestMapping("/list")
	@ResponseBody
	public String list(Integer page , Integer rows){
		Integer startIndex = (page - 1) * rows;
		Map params = new HashMap();
		params.put("st" , startIndex);
		params.put("r" , rows);
		List<Map> list = ${service.beanId}.findByProperty(params);
		Long cnt = ${service.beanId}.countByProperty(params);
		Map result = new HashMap();
		result.put("total" , cnt);
		result.put("rows" , list);
		return new Gson().toJson(result);
	}
	
	@RequestMapping("/findByProperty")
	@ResponseBody
	public String findByProperty(HttpServletRequest request){
		Map params = new HashMap();
		Map<String,String[]> rparam = request.getParameterMap();
		Iterator itr = rparam.entrySet().iterator();
		while(itr.hasNext()){
			Map.Entry<String, String[]> me = (Map.Entry<String, String[]>)itr.next();
			if(me.getValue().length == 1){
				params.put(me.getKey(), me.getValue()[0]);
			}else{
				params.put(me.getKey(), me.getValue());
			}
			
		}
		List<Map> list = ${service.beanId}.findByProperty(params);
		return new Gson().toJson(list);
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public String create(${model.class} entity){
		Map result = new LinkedHashMap();
		try{
			${service.beanId}.create(entity);
			result.put("result" , true);
			result.put("message" , "数据创建成功");
		}catch(Exception e){
			e.printStackTrace();
			result.put("result" , false);
			result.put("message" , "数据创建失败");
		}
		return new Gson().toJson(result);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String update(${model.class} entity){
		Map result = new LinkedHashMap();
		try{
			${service.beanId}.update(entity);
			result.put("result" , true);
			result.put("message" , "数据更新成功");
		}catch(Exception e){
			e.printStackTrace();
			result.put("result" , false);
			result.put("message" , "数据更新失败,请查看日志");
		}
		return new Gson().toJson(result);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(${model.id.type} id){
		Map result = new LinkedHashMap();
		try{
			${service.beanId}.delete(id);
			result.put("result" , true);
			result.put("message" , "数据删除成功");
		}catch(Exception e){
			e.printStackTrace();
			result.put("result" , false);
			result.put("message" , "数据删除失败,请查看日志");
		}
		return new Gson().toJson(result);
	}
}
