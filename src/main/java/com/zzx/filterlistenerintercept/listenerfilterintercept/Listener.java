package com.zzx.filterlistenerintercept.listenerfilterintercept;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;


/**
 * Created with IntelliJ IDEA.
 * Created by:  Vivian
 * Date: 2018/7/24 9:30
 */

@Component
@WebListener()
@Data
@ConfigurationProperties(prefix = "auth")
public class Listener implements ServletContextListener {

    private Boolean tokenCheckRequired;
    private int tokenExpireMin;
    private int tokenKeyLength;
    private String loginURL;


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("监听器初始化......");
        System.out.println("要做事情才用listener......");
    }

    /**
     * 登录成功时调用
     *
     * @param request
     * @param response
     */

    public void loginSuccess(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.setAttribute("isLog", true);
        String sessionId = session.getId();
        String tokenKey;
        String token;
        if (tokenCheckRequired) {
            tokenKey = RandomChar.getRandomStr(tokenKeyLength);
            session.setAttribute("tokenKey", tokenKey);
            token = TokenCheck.createToken(tokenKey, sessionId, tokenExpireMin * 60 * 1000);
            Cookie cookie = new Cookie("token", token);
            cookie.setPath("/");
            cookie.setMaxAge(tokenExpireMin);
            cookie.setDomain(""); // cookie作用域
            response.addCookie(cookie);
        }
    }

    /**
     * 登出成功时调用
     *
     * @param request
     * @param response
     */
    public void logoutSuccess(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.invalidate();
    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }


}
