package com.cdkj.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.cdkj.service.core.ConfigDescribe;
import com.cdkj.service.core.ConfigLoader;

public class IpFilter implements Filter {

    public IpFilter() {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain filter) throws IOException, ServletException {
        String remoteaddr = getRemoteHost(request);

        ConfigDescribe configDescribe = null;
        try {
            configDescribe = ConfigLoader.loadConfig();
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().append("Unsuccessful Deployment").flush();
        }
        if (configDescribe != null) {
            List<String> ipList = configDescribe.getIpList();
            if (!ipList.contains(remoteaddr)) {
                response.getWriter().append("Unauthorized Access").flush();
            } else {
                filter.doFilter(request, response);
            }
        }
    }

    /**
     * 获取IP地址
     * 
     * @return
     */
    private String getRemoteHost(ServletRequest request) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String ip = httpServletRequest.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = httpServletRequest.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = httpServletRequest.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        /*
         * if (ip.indexOf(",") >= 0) // 存在逗号，有多个IP，取最后一个 { ip =
         * ip.substring(ip.indexOf(",") + 1); }
         */
        if (ip.indexOf(",") >= 0) // 存在逗号，有多个IP，取前面一个
        {
            ip = ip.substring(0, ip.indexOf(","));
        }
        return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

}
