package com.zzx.filterlistenerintercept.implement;


import com.zzx.filterlistenerintercept.entity.NewsEntity;

import java.util.List;

/**
 * Created by zhl on 2018/3/28.
 */
public interface INewsService {
    /**
     * 获取所有新闻
     * @param pn
     * @return
     */
    List<NewsEntity> getNews(int pn);

    /**
     * 删除某个新闻
     * @param newsId
     * @return
     */
    int delNews(int newsId);

    /**
     * 发布新闻
     * @param content
     * @param userName
     * @param title
     * @return
     */
    int createNews(String content, String userName, String title);
}
