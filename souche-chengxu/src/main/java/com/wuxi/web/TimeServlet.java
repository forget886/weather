package com.wuxi.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
            throws ServletException, IOException {
        System.out.println(getServletContext().getRealPath("/"));
        System.out.println("认证" + req.isUserInRole("admin"));
        System.out.println("url: " + req.getRequestURL());
        System.out.println("host: " + req.getHeader("host") + req.getRemoteHost());
        System.out.println(req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath() + "/");
        System.out.println("uri: " + req.getRequestURI());
        System.out.println("user ip: " + req.getRemoteAddr());
        System.out.println("contextpath: " + req.getContextPath());
        System.out.println("servletpath: " + req.getServletPath());
        if (req.getQueryString() != null) {
            String query = URLDecoder.decode(req.getQueryString(), "utf-8");
            System.out.println("query: " + query);

        }
        getServletContext().setAttribute("name", "zhang");
        System.out.println("name: " + req.getAttribute("name"));
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
        Cookie cookie1 = new Cookie("addr", "beijing");
        cookie1.setMaxAge(60 * 60);
        //response.setHeader("Set-Cookie", cookieName+"="+sid+";Path=/;Domain="+cookieDomain+";Max-Age="+ssoExpire);
        //浏览器不会跨域添加cookie
        //具体现象就是你发现在响应中已经有set-cookie的响应头了并且有值，而且浏览器也会有信息显示已接收到cookie了，但是就是在cookie中找不到。
        cookie1.setDomain(".baidu.com");
//			cookie1.setPath("/chengxu/select.do");
//			Cookie cookie2 = new Cookie("age", "1");
        resp.addCookie(cookie1);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter write = resp.getWriter();
        Date today = new Date();
        write.println("<html>"
                + "<meta http-equiv=\"charset\" content=\"utf-8\">"
                + "<body><p>" + today + "</p>"
                + "<a href=\"" + resp.encodeURL(req.getContextPath() + "/select.do") + "\">click me</a>"
                + "<p>先生你好啊</p>"
                + "</body></html>");
        write.flush();
        write.close();

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }

}
