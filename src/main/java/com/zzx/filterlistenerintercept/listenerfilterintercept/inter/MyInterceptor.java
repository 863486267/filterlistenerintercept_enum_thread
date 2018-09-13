package com.zzx.filterlistenerintercept.listenerfilterintercept.inter;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by:  John Zhu
 * Date: 2018/8/31 17:04
 **/
@Component
public class MyInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
                HandlerMethod method = (HandlerMethod) handler;
                Premission premission = method.getMethodAnnotation(Premission.class);
                if ((premission == null) || (premission.isPath())) {
                    return true;
                } else {
                    return false;
                }
        }
        return true;
    }

}
