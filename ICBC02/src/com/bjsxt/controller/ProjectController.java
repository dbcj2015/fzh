package com.bjsxt.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjsxt.entity.Project;
import com.bjsxt.service.ProjectService;
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
