package com.example.storepro.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;

import com.example.storepro.Fragments.bean.ProductBean;
import com.example.storepro.app.MyApplication;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

//购物车存储
public class CartStorage {
    public static final String JSON_CART = "json_cart";
    private  static CartStorage instance;
    private final Context mContext;
    //SparseArray的性能优于HashMap
    private SparseArray<ProductBean> sparseArray;

    private CartStorage(Context context) {
        this.mContext = context;
        //把之前存储的数据读取
        sparseArray = new SparseArray<>(100);
        //
        ListToSparseArray();
    }

    //从本地读取的数据加入到SparseArray
    private void ListToSparseArray() {
        List<ProductBean> productBeanList =getAllData();
        //把list数据转换为SparseArray
        for (int i=0;i<productBeanList.size();i++){
            ProductBean productBean = productBeanList.get(i);
            sparseArray.put(Integer.parseInt(productBean.getProduct_id()),productBean);
        }
    }

    //获取本地所有数据
    public List<ProductBean> getAllData() {
        List<ProductBean> productBeanList = new ArrayList<>();
        //从本地获取
        String json = CacheUtils.getString(mContext, JSON_CART);
        //使用Gson转换成列表
        if (!TextUtils.isEmpty(json)){
            productBeanList = new Gson().fromJson(json,new TypeToken<List<ProductBean>>(){}.getType());
        }
        return productBeanList;
    }

    //购物车实例
    public static CartStorage getInstance(){
        if (instance == null){
            instance = new CartStorage(MyApplication.getContext());
        }
        return instance;
    }

    //增加数据
    public void addDate(ProductBean productBean){
        //添加到内存中SparseArray
        //如果当前出局已经存在，就修改成number递增
        ProductBean tempData = sparseArray.get(Integer.parseInt(productBean.getProduct_id()));
        if (tempData !=null){
            //内存中有了这条数据
            tempData.setNumber(tempData.getNumber()+1);
        }else {
            tempData = productBean;
            tempData.setNumber(1);
        }
        //同步到内存中
        sparseArray.put(Integer.parseInt(tempData.getProduct_id()),tempData);

        //同步到本地
        saveLocal();
    }

    //删除数据
    public void deleteDate(ProductBean productBean){
        //内存中删除
        sparseArray.delete(Integer.parseInt(productBean.getProduct_id()));
        //保存到本地
        saveLocal();
    }

    //更新数据
    public void updateDate(ProductBean productBean){
        //内存中更新
        sparseArray.put(Integer.parseInt(productBean.getProduct_id()),productBean);
        //保存到本地
        saveLocal();
    }

    //保存数据到本地
    private void saveLocal() {
        //SparseArray转换成List
        List<ProductBean> productBeanList = saprseToList();
        //使用Gson把列表数据转换成String类型
        String json = new Gson().toJson(productBeanList);
        //把String数据保存
        CacheUtils.saveString(mContext,JSON_CART,json);
    }

    private List<ProductBean> saprseToList() {
        List<ProductBean> productBeanList = new ArrayList<>();
        for (int i = 0;i<sparseArray.size();i++){
            ProductBean productBean = sparseArray.valueAt(i);
            productBeanList.add(productBean);
        }
        return productBeanList;
    }
}
