package com.wuxi.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class VisitFilter implements Filter {

	private FilterConfig fc;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.fc = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("request before");
		chain.doFilter(request, response);
		System.out.println("request after");
	}

	@Override
	public void destroy() {

	}

}
