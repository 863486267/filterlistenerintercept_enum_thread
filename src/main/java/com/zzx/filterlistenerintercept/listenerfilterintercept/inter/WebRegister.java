package com.zzx.filterlistenerintercept.listenerfilterintercept.inter;

import com.zzx.filterlistenerintercept.listenerfilterintercept.inter.MyInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by:  John Zhu
 * Date: 2018/8/31 17:15
 **/
@Component
public class WebRegister implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       InterceptorRegistration registration= registry.addInterceptor(new MyInterceptor());
       registration.addPathPatterns("/**");
       registration.excludePathPatterns("/user/*");
    }
}
