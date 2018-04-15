package com.bjsxt.nw185.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/view")
public class ViewController {
	@RequestMapping("/{viewname}")
	public String forward(@PathVariable("viewname") String viewname){
		return "/" + viewname;
	}
}
