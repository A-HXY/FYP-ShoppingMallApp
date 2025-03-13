package com.example.storepro.utils;

/**
 * 配置各个页面联网地址
 */
public class Constants {

    public static Boolean isBackHome = false;
    //真机模拟
    public static final String BASE = "http://192.168.31.100 :8000";
    //模拟器
    //public static final String BASE = "http://192.168.0.102:8080";
    // 请求 Json 数据基本 URL
    public static final String BASE_URL_JSON = BASE+"/storepro/json/";
    // 请求图片基本 URL
    public static final String BASE_URl_IMAGE = BASE+"/storepro/img/";
    //主页路径
    public static final String HOME_URL =  BASE_URL_JSON + "HOME_URL.json";
    public static final String TAG_URL =  BASE_URL_JSON+ "TAG_URL.json";

    public static final String NEW_POST_URL =  BASE_URL_JSON + "NEW_POST_URL.json";
    public static final String HOT_POST_URL =  BASE_URL_JSON + "HOT_POST_URL.json";




    //小裙子
    public static final String SKIRT_URL = BASE_URL_JSON + "SKIRT_URL.json";
    //上衣
    public static final String JACKET_URL = BASE_URL_JSON + "JACKET_URL.json";
    //下装(裤子)
    public static final String PANTS_URL = BASE_URL_JSON + "PANTS_URL.json";
    //外套
    public static final String OVERCOAT_URL = BASE_URL_JSON + "OVERCOAT_URL.json";
    //配件
    public static final String ACCESSORY_URL = BASE_URL_JSON + "ACCESSORY_URL.json";
    //包包
    public static final String BAG_URL = BASE_URL_JSON + "BAG_URL.json";
    //装扮
    public static final String DRESS_UP_URL = BASE_URL_JSON + "DRESS_UP_URL.json";
    //居家宅品
    public static final String HOME_PRODUCTS_URL = BASE_URL_JSON + "HOME_PRODUCTS_URL.json";
    //办公文具
    public static final String STATIONERY_URL = BASE_URL_JSON + "STATIONERY_URL.json";
    //数码周边
    public static final String DIGIT_URL = BASE_URL_JSON +  "DIGIT_URL.json";
    //游戏专区
    public static final String GAME_URL = BASE_URL_JSON + "GAME_URL.json";

}
