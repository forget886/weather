package com.wuxi.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException{
		 
		 System.out.println(req.getRequestURL());
		 System.out.println(req.getRequestURI());
		 System.out.println(req.getContextPath());
		 System.out.println(req.getServletPath());
		 System.out.println(req.getQueryString());
		 /**
		  * http://localhost:8080/chengxu/time.jsp
			/chengxu/time.jsp
			/chengxu
			/time.jsp
			t=1&e=2
		  */
		 //告诉浏览器编码类型
		 resp.setHeader("content-type", "text/html;charset=utf-8");
		 //write中字符转化为字节
		 resp.setCharacterEncoding("utf-8");
 		 PrintWriter write = resp.getWriter();
		 Date today = new Date();
		 write.println("<html>"+
				 "<meta http-equiv=\"charset\" content=\"utf-8\">"+
				 "<body><p>" + today +"</p><p>先生你好啊</p></body></html>");
		 write.flush();
		 write.close();
		 
	 }
	 
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException{
		 
	 }
	
}
