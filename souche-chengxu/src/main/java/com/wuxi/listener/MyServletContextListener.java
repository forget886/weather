package com.wuxi.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener{

	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		System.out.println(sc.getInitParameter("address"));
	}

	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
