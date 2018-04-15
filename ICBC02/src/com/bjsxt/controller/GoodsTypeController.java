package com.bjsxt.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjsxt.entity.GoodsType;
import com.bjsxt.service.GoodsTypeService;

@Controller("goodsTypeController")
@RequestMapping("/goodstype")
public class GoodsTypeController {
	@Resource(name="goodsTypeService")
	private GoodsTypeService service = null;
	
}
