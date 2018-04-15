package com.bjsxt.nw185.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjsxt.nw185.service.ProjectService;
import com.google.gson.Gson;

@Controller("projectController")
@RequestMapping("/project")
public class ProjectController {
	@Resource(name="projectService")
	private ProjectService service = null;
	
	@RequestMapping("/findByProperty")
	@ResponseBody
	public String findByProperty(){
		List<Map> list = service.findByProperty();
		return new Gson().toJson(list);
	}
}
