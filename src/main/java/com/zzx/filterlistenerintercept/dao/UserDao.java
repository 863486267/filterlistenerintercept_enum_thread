package com.zzx.filterlistenerintercept.dao;

import com.zzx.filterlistenerintercept.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created with IntelliJ IDEA.
 * Created by:  Vivian
 * Date: 2018/7/24 13:39
 */
@Mapper
public interface UserDao {

    @Select("SELECT COUNT(id) FROM user WHERE user_name=#{userName} and password=#{password}")
    int getOne(@Param("userName") String userName,
               @Param("password") String password);


}
