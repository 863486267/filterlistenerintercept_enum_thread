package com.zzx.filterlistenerintercept.service;


import com.zzx.filterlistenerintercept.dao.NewsDao;
import com.zzx.filterlistenerintercept.entity.NewsEntity;
import com.zzx.filterlistenerintercept.implement.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vivian on 2018/03/28.
 */
@Service
public class NewsService implements INewsService {

    @Autowired
    NewsDao newsDao;


    /**
     * 获取所有新闻
     * @param pn
     * @return
     */
    public List<NewsEntity> getNews(int pn){
        List<NewsEntity> newsEntity= newsDao.getNew((pn-1)*9);
        return newsEntity;
    }


    /**
     * 删除某个新闻
     * @param newsId
     * @return
     */
    public int delNews(int newsId){
        int dleNew=newsDao.delNews(newsId);
        return dleNew;
    }

    /**
     * 创建新闻
     * @param content
     * @param userName
     * @param title
     * @return
     */
    public int createNews(String content,String userName, String title){
        return newsDao.creatNews(content,userName,title);
    }

}
