package com.workAttendance.utils;

import com.workAttendance.web.WebServletContextListener;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

/**
 * 
 * @author xiaoli.zhan
 * @date 2014-11-11光棍节
 */
public class ContextUtil {
	private static ApplicationContext  context = null;

	public static HttpSession getCurrentSession() {
		//return ContextHolder.getHttpSession();
		return null;
	}

	public static <T> T getSpringBean(String beanId,Class<T> clazz) {
		//return ContextHolder.getBean(beanId);
		/*ApplicationContext context = new ClassPathXmlApplicationContext(
				                                            "classpath:/spring/context-*.xml");
			return context.getBean(beanId);*/
		WebApplicationContext wac = ContextUtil.getWebApplicationContext();
		if (wac != null) {
			T o = wac.getBean(beanId,clazz);
			return o;
		} else{
			return getContext().getBean(beanId,clazz);
			//return null;
		}
	}

	public static WebApplicationContext getWebApplicationContext() {
		//return ContextHolder.getApplicationContext();
		ServletContext sc = WebServletContextListener.getServletContext();
		if (sc != null) {
			return WebApplicationContextUtils
					.getRequiredWebApplicationContext(sc);
		} else {
			return null;
		}
	}
	
	 public static ApplicationContext getContext(){  
		 if(context == null){
			  /*context =new ClassPathXmlApplicationContext(
					  new String[]{"classpath:/spring/datasource-context.xml","classpath:/spring/dao-context.xml","classpath:/spring/service-context.xml"});*/
			 context =new ClassPathXmlApplicationContext("classpath:/spring/beans-context.xml");
			 /*context =new ClassPathXmlApplicationContext(
						"classpath:/spring/*-context.xml");*/
		 }
		 return context;
	 }  

}
