package com.wuxi.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

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
		long start = System.currentTimeMillis();
		System.out.println("request url:"+req.getRequestURL());
		chain.doFilter(request, response);
		System.out.println("request over,cost " + (System.currentTimeMillis() - start) + " ms");
	}

	@Override
	public void destroy() {

	}

}
