package com.partner.propertyms.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Orange
 * @date 2022/8/22 -14:05
 */

public class LoginFilter extends FormAuthenticationFilter {
    /**
     * 在访问controller前判断是否登录，返回json，不进行重定向。
     * @param request
     * @param response
     * @return true-继续往下执行，false-该filter过滤器已经处理，不继续执行其他过滤器
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        //if (isAjax(request)) {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        Map<String,Object> resultData = new HashMap<>();
        resultData.put("code", -1);
        resultData.put("msg", "登录认证失效，请重新登录!");
        httpServletResponse.getWriter().write(JSONObject.toJSON(resultData).toString());
/*  } else {
        // saveRequestAndRedirectToLogin(request, response);
         //非ajax请求重定向为登录页面
        httpServletResponse.sendRedirect("/login");
    }*/
        return false;
    }
    private boolean isAjax(ServletRequest request) {
        String header = ((HttpServletRequest) request).getHeader("X-Requested-With");
        if ("XMLHttpRequest".equalsIgnoreCase(header)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}

