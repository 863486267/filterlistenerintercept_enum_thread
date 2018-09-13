package com.zzx.filterlistenerintercept.service;

import com.zzx.filterlistenerintercept.dao.UserDao;
import com.zzx.filterlistenerintercept.entity.UserEntity;
import com.zzx.filterlistenerintercept.implement.IUserService;
import com.zzx.filterlistenerintercept.listenerfilterintercept.Listener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * Created by:  Vivian
 * Date: 2018/7/24 13:44
 */
@Service
public class UserService implements IUserService {
    @Autowired
    UserDao userDao;
    @Autowired
    Listener listener;

    @Override
    public int getOne(String userName, String password, HttpServletRequest request, HttpServletResponse response) {
        int one = userDao.getOne(userName, password);
        if (one == 1) {
            listener.loginSuccess(request, response);
            response.addCookie(new Cookie("Test2","dfgdfg"));
            return 1;
        }
        return 0;
    }
}
