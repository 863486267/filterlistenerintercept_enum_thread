package com.zzx.filterlistenerintercept.dao;


import com.zzx.filterlistenerintercept.entity.NewsEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Vivian on 2018/03/28.
 */
@Mapper
public interface NewsDao {
    @Select("Select * FROM news order by news_time desc LIMIT #{pn},9")
    List<NewsEntity> getNew(@Param(value = "pn") int pn);

    @Delete("DELETE FROM news WHERE id=#{newsId} ")
    int delNews(@Param(value = "newsId") int newsId);

    @Insert("INSERT INTO news(news,admin_name,news_title) Values (#{news},#{adminName},#{newsTitle})")
    int creatNews(@Param(value = "news") String news,
                  @Param(value = "adminName") String adminName,
                  @Param(value = "newsTitle") String newsTitle);
    @Select("SELECT COUNT(id) FROM news")
    int newsNum();
}
