package com.wuxi.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TimeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	 @Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("init param, adress: " + getServletConfig().getInitParameter("address"));
		System.out.println("context param,address: " + getServletContext().getInitParameter("address"));
		
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException{
		System.out.println("认证"+req.isUserInRole("admin"));
		 System.out.println("url: " + req.getRequestURL());
		 System.out.println("host: " + req.getHeader("host") + req.getRemoteHost());
		 System.out.println(req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath()+"/");
		 System.out.println("uri: " + req.getRequestURI());
		 System.out.println("user ip: " + req.getRemoteAddr());
		 System.out.println("contextpath: " + req.getContextPath());
		 System.out.println("servletpath: " + req.getServletPath());
		 if (req.getQueryString() != null) {
			 String query = URLDecoder.decode(req.getQueryString(), "utf-8");
			 System.out.println("query: " + query);

		 }
		 HttpSession session = req.getSession();
		 /**
		  * request:http://localhost:8080/chengxu/time.jsp?t=1&e=2
		  * 
		  * http://localhost:8080/chengxu/time.jsp
			/chengxu/time.jsp
			/chengxu
			/time.jsp
			t=1&e=2
		  */
		 //告诉浏览器编码类型
		 //resp.setHeader("content-type", "");
		 //write中字符转化为字节
		 //resp.setCharacterEncoding("utf-8");
		 resp.setContentType("text/html;charset=utf-8");
 		 PrintWriter write = resp.getWriter();
		 Date today = new Date();
		 write.println("<html>"
				 +"<meta http-equiv=\"charset\" content=\"utf-8\">"
				 +"<body><p>" + today +"</p>" 
				 +"<a href=\"" + resp.encodeURL(req.getContextPath()+"/select.do") + "\">click me</a>"
				 +"<p>先生你好啊</p>"
				 + "</body></html>");
		 write.flush();
		 write.close();
		 
	 }
	 
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException{
		 
	 }
	
}
