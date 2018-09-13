package com.zzx.filterlistenerintercept.implement;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * Created by:  Vivian
 * Date: 2018/7/24 13:43
 */
public interface IUserService {


    public int getOne(String userName, String password, HttpServletRequest request, HttpServletResponse response);
}
