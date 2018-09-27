package com.zzx.filterlistenerintercept.controller;


import com.zzx.filterlistenerintercept.dao.NewsDao;
import com.zzx.filterlistenerintercept.entity.NewsEntity;
import com.zzx.filterlistenerintercept.implement.INewsService;
import com.zzx.filterlistenerintercept.listenerfilterintercept.inter.Permission;
import com.zzx.filterlistenerintercept.tool.ResultWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Vivian on 2018/03/28.
 */

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    INewsService newsService;

    @Autowired
    NewsDao newsDao;

    /**
     * 获取所有新闻
     * @param pn
     * @return
     */
    @Permission(isPath =true)
    @CrossOrigin(value = {"*"})
    @PostMapping("/get")
    public ResultWrapper getNews(@RequestParam(value = "pn")int pn,HttpServletResponse response){
        ResultWrapper resultWrapper=new ResultWrapper();
        List<NewsEntity> newsEntity=newsService.getNews(pn);

        if(newsEntity.size()>0){
            int num=newsDao.newsNum();
            int page=num/9;
            int pages=num%9;
            if(page==0&&pages!=0){
                return resultWrapper.build(1,"获取成功",newsEntity);
            }
            if(page!=0&&pages==0){
                return resultWrapper.build(page,"获取成功",newsEntity);
            }
            return resultWrapper.build(page+1,"获取成功",newsEntity);
        }
        return resultWrapper.build(0,"获取失败");
    }


    /**
     * 删除某个新闻
     * @param newsId
     * @return
     */

    @PostMapping("/del")
    public Object delNews(@RequestParam(value = "id")int newsId){
        int del=newsService.delNews(newsId);
        if(del==1){
            return "删除成功";
        }
        return "删除失败";

    }

    /**
     * 发表新闻
     * @param request
     * @param response
     * @param content
     * @param title
     * @return
     */
    @Permission(isPath =true)
    @RequestMapping(value = "/publish",method = RequestMethod.POST)
    public int createNews(HttpServletRequest request, HttpServletResponse response, @RequestParam String content, @RequestParam String title){
        HttpSession session = request.getSession();
        //String userName = (String)((UserInfo)manager.getUserInfo(session.getId())).info.get("userName");
        return newsService.createNews(content,"zhl",title);
    }


}
