package com.wuxi.filter;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class RequestWrapper extends HttpServletRequestWrapper {

    public RequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {
        // TODO Auto-generated method stub
        return super.getParameter(name);
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        // TODO Auto-generated method stub
        return super.getParameterMap();
    }

    @Override
    public Enumeration<String> getParameterNames() {
        // TODO Auto-generated method stub
        return super.getParameterNames();
    }

    @Override
    public String[] getParameterValues(String name) {
        // TODO Auto-generated method stub
        return super.getParameterValues(name);
    }


}
