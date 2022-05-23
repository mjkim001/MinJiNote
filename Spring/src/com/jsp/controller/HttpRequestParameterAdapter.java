package com.jsp.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

public class HttpRequestParameterAdapter {
	public static <T>T execute(HttpServletRequest request, Class<T> className) throws Exception {
		//의존성 확인 및 조립
		Method[] methods = className.getMethods();
				
		//인스턴스 생성
		T obj = className.newInstance();
		
		//setter 확인
		for(Method method:methods) {
			if(method.getName().indexOf("set") == 0) {
				String reqestParamName = method.getName().replace("set", "");
				reqestParamName = (reqestParamName.charAt(0) + "").toLowerCase() + reqestParamName.substring(1); 
				String[] paramValues = request.getParameterValues(reqestParamName);
				
				if(paramValues != null && paramValues.length > 0) {
					if(method.getParameterTypes()[0].isArray()) {
						method.invoke(obj, new Object[] { paramValues });
					}else {
						method.invoke(obj, paramValues[0]);
					}
				}
				
			}
		}
		return obj;
		
		
		
	}
}
