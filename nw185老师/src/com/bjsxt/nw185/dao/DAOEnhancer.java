package com.bjsxt.nw185.dao;

import java.util.List;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.bjsxt.nw185.base.utils.BeanUtils;

@Component
@Aspect
@SuppressWarnings("all")
public class DAOEnhancer {
	@Around("execution(* com.bjsxt..*DAO.find*(..))")
	public Object findMethodEnhancer(ProceedingJoinPoint pjp) throws Throwable{
		Object obj = pjp.proceed();
		if(obj instanceof List){
			List list = (List)obj;
			if(list.size() > 0){
				if(list.get(0) instanceof Map){
					BeanUtils.converToCamel(list);
				}
			}
		}else if(obj instanceof Map){
			BeanUtils.converToCamel((Map)obj);
		}
		return obj;
	}
}
