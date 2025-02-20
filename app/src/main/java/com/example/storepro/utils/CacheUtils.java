package com.example.storepro.utils;

import android.content.Context;
import android.content.SharedPreferences;
//缓存工具
public class CacheUtils {

    //得到保存String类型的数据
    public static String getString(Context context, String key) {
        SharedPreferences sp=context.getSharedPreferences("storepro",Context.MODE_PRIVATE);
        return sp.getString(key,"");
    }
    //保存String类型的数据
    public static void saveString(Context context, String key,String value) {
        SharedPreferences sp=context.getSharedPreferences("storepro",Context.MODE_PRIVATE);
        sp.edit().putString(key,value).commit();
    }
}
