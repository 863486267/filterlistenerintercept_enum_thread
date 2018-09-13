package com.zzx.filterlistenerintercept.listenerfilterintercept;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Component
@WebFilter(filterName = "myFilter", urlPatterns = "/news/*")
@Data
@ConfigurationProperties(prefix = "auth")
public class MyFilter implements Filter {

    private Boolean tokenCheckRequired;
    private String loginURL;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("什么都不做......");
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        Object b = session.getAttribute("isLog");

        //登录验证
        if ((b==null)||(b.equals(false))) {
            System.out.println("禁止进入！");
            response.sendRedirect("log.html");

         //跳转路径为返回上一级，由js做
        } else if (b.equals(true)) {
            System.out.println("他是良民，是否查看良民证！");
            if (tokenCheckRequired) {

                String tokenKey = null;
                Cookie[] cookies = request.getCookies();
                String token1 = null;
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("token")) {
                        token1 = cookie.getValue();
                        break;
                    }
                }
                if (token1 == null) {
                    System.out.println("走不脱！");
                    Listener listener = new Listener();
                    listener.logoutSuccess(request, response);
                } else {
                    tokenKey = (String )(session.getAttribute("tokenKey"));
                    if (TokenCheck.checkToken(token1, tokenKey)) {
                        session.setAttribute("isLog", true);
                        System.out.println("大大的良民！");
                        //测试
                    }else {
                        System.out.println("这是个黑客！注意注意1");
                        //直接让他下线
                        Listener listener = new Listener();
                        listener.logoutSuccess(request, response);
                        //
                    }
                }
            }
            chain.doFilter(servletRequest, servletResponse);
        }

    }


    @Override
    public void destroy() {

    }
}
