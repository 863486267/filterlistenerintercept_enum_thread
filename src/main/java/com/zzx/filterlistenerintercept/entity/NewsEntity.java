package com.zzx.filterlistenerintercept.entity;

import lombok.Data;
import lombok.ToString;

/**
 * Created by Vivian on 2018/03/28.
 */
@Data
@ToString
public class NewsEntity {
    private int id;
    private String news;
    private String newsTitle;
    private String newsTime;
    private String adminName;

}
