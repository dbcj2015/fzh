package com.bjsxt.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjsxt.entity.Product;
import com.bjsxt.service.ProductService;

@Controller("productController")
@RequestMapping("/product")
public class ProductController {
	@Resource(name="productService")
	private ProductService service = null;
	
}
