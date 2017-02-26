package com.wuxi.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BeerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException{
		
		this.doPost(req, resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		ServletContext context = req.getSession().getServletContext();
		System.out.println("context: " + context.getContextPath());
		String color = req.getParameter("color");
		String name = "张三";
		req.setAttribute("name", name);
		req.setAttribute("color", color);
		//req.setAttribute("addr", "大道99号");
		getServletContext().setAttribute("addr", getServletContext().getInitParameter("address"));
//		Cookie[] cookies = req.getCookies();
//		for(Cookie c:cookies){
//			System.out.println(c.getName());
//			System.out.println(c.getDomain());
//			System.out.println(c.getPath());
//			System.out.println(c.getMaxAge());
//			System.out.println(c.getComment());
//		}
//		Cookie cookie1 = new Cookie("name", "a");
//		cookie1.setMaxAge(1*60*60);
//		cookie1.setPath("/chengxu/select.do");
//		Cookie cookie2 = new Cookie("age", "1");
//		resp.addCookie(cookie1);
//		resp.addCookie(cookie2);
		RequestDispatcher view =  req.getRequestDispatcher("/jsp/beers.jsp");
		view.forward(req, resp);
		//resp.sendRedirect("time");
	}
	
	 

}
