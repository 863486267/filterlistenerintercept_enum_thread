package com.zzx.filterlistenerintercept.thread;

import com.zzx.filterlistenerintercept.dao.ThreadDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by:  John Zhu
 * Date: 2018/9/1 17:10
 **/
@Slf4j
@RestController
public class MoreThreadController {

    @Autowired
    ThreadDao threadDao;

    @PostMapping("/setdate")
    public long insert() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(14);
        long time1 = System.currentTimeMillis();
        for (int j = 0; j <14; j++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    for (int i = 1; i < 100; i++) {
                        int chenge = threadDao.set("name" + i, "password" + i);
                        if (i % 9 == 0) {
                     //     log.info(String.valueOf(i));

                        }
                    }
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        //主线程不等待子线程如上
        //让主线程等子线程如下
        executorService.shutdown();//关闭线程池,不会真的关闭,只是不接收新任务
        while (true) {
            //判断是否所有线程都执行完毕
            if (executorService.isTerminated()) {
              /*  System.out.println("结束了！");
                long time2 = System.currentTimeMillis();
                System.out.println("花费时间:" + (time2 - time1));*/
                break;
            }
            Thread.sleep(20);//防止循环很多次
        }
        long time3 = System.currentTimeMillis();
        return time3 - time1;
    }

}
