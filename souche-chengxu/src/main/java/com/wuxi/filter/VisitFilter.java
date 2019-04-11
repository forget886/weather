package com.wuxi.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VisitFilter implements Filter {

    private FilterConfig fc;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.fc = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        long start = System.currentTimeMillis();
        System.out.println("request url:" + req.getRequestURL());

//		String clientOrigin = req.getHeader("Origin");
//		//跨域设置cookie必须设置Access-Control-Allow-Origin为特定域名，不能为*
//		if(clientOrigin != null && (urlAllowed.indexOf(clientOrigin) != -1)){
//			resp.setHeader("Access-Control-Allow-Origin", clientOrigin);
//		}else{
//			resp.setHeader("Access-Control-Allow-Origin", SOUCHE_CROSS_DOMAIN);
//		}
//		resp.setHeader("Access-Control-Allow-Credentials","true");
//		resp.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
//		resp.setHeader("Access-Control-Max-Age", "0");
//		resp.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept,_security_token");
        res.addHeader("Set-Cookie", "token1=token1;Path=/;Domain=.souche-inc.com;Max-Age=3600");
        //通过装饰模式可以对request的参数进行更改
        chain.doFilter(new RequestWrapper((HttpServletRequest) request), response);
        /**
         * 代码中：PrintWriter out = response.getWriter();
         out.print(json);
         out.flush()
         out.close();
         如果commit了 之后response添加请求头就不会生效,这种情况要在doFilter之前添加。
         */
        res.addHeader("Set-Cookie", "token2=token2;Path=/;Domain=.souche-inc.com;Max-Age=3600");
        System.out.println("request over,cost " + (System.currentTimeMillis() - start) + " ms");
    }

    @Override
    public void destroy() {

    }

}
