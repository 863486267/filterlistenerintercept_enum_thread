package com.zzx.filterlistenerintercept.listenerfilterintercept.inter;

import java.lang.annotation.*;

/**
 * Created by:  John Zhu
 * Date: 2018/8/31 18:02
 **/
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented()
public @interface Permission {
    boolean isPath() default false;
}
