package com.bjsxt.controll;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/t")
@SessionAttributes({"list"})
public class ListController {
	ArrayList<Map> list=new ArrayList<>();
	public ListController(){
		for (int i = 0; i < 100; i++) {
			Map map=new HashMap<>();
			map.put("name", "name"+i);
			map.put("index", i+1);
			map.put("date", new Date());
			list.add(map);
		}
	}
	
	//(1) ����ԭ������,����request\session���� �Ƽ�ָ�� ��(���Ƽ�)
	//�ŵ�:ʹ�ü�,��Servlet�ͻ����ַ�ʽ
	//ȱ��:���������,������Web����(Tomcat)û������ִ��
	@RequestMapping("/request")
	public String list(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		request.setAttribute("list", list);
		return "/list";
	}
	
	@RequestMapping("/mavlist")
	public ModelAndView list(){
		ModelAndView mav=new ModelAndView("/list");
		mav.addObject("list", list);
		return mav;
	}
	
	//2. ����ModelAndView(ģ����ֵ) ���������� �Ƽ�ָ��:��������Session������¡��������� ,ʹ��Session��ʱ���
	//PS . Session�ܲ��þͲ���,��Ϊ���зֲ�ʽ��״̬����
	// �ŵ�: ʹ�ü򵥴ֱ�,����������,������Tomcat���ܵ�������
	// ȱ��: ����Session��ʱ�򲻹��Ѻ� , @SessionAttributes({"list"})
	@RequestMapping("/mavSession")
	public ModelAndView listSession(){
		ModelAndView mav=new ModelAndView("/list");//��ԭ��������з�װ
		mav.addObject("list", list);
		return mav;
	}
	
	
	//3. ����WebRequest����ֵ �Ƽ�ָ��:����������
	//ȱ��: WebRequest���󲢲��ṩ��Ԫ���Ե�֧��,��Ȼ��������,������Ȼ�����ڵ���
	//PS. WebRequest������Spring MVC ��request\Session��װ��Ķ���,����ֱ������setAttribute
	@RequestMapping("/web")
	public String list(WebRequest webRequest){
		webRequest.setAttribute("list", list, WebRequest.SCOPE_SESSION);
		//webRequest.setAttribute("list", list, WebRequest.SCOPE_SESSION); //��session���
		//webRequest.setAttribute("list", list, WebRequest.SCOPE_GLOBAL_SESSION); //��application/ServletContext���
		return "/list";
	}
}
