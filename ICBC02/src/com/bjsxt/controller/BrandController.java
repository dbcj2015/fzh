package com.bjsxt.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjsxt.entity.Brand;
import com.bjsxt.service.BrandService;

@Controller("brandController")
@RequestMapping("/brand")
public class BrandController {
	@Resource(name="brandService")
	private BrandService service = null;
	
}
