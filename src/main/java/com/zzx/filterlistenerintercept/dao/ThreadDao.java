package com.zzx.filterlistenerintercept.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ThreadDao {
    @Insert("INSERT INTO admin (admin_name,admin_password)VALUES(#{name},#{password});")
    int set(@Param("name")String name,
            @Param("password")String password);
}
