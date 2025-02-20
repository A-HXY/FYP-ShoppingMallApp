package com.example.storepro.Fragments.bean;

import java.io.Serializable;
//商品类
public class ProductBean implements Serializable {
    //商品名称
    private String name;
    //价格
    private String cover_price;
    //图片
    private String figure;
    //商品id
    private String product_id;
    //描述
    private String brief;
    //详情
    private String details;

    private int number = 1;
    //购物车商品选中
    private boolean isSelected = true;

    private boolean isEditing;

    public ProductBean() {

    }

    public ProductBean(String name, String cover_price, String figure, String product_id, String brief, String details, int number) {
        this.name = name;
        this.cover_price = cover_price;
        this.figure = figure;
        this.product_id = product_id;
        this.brief = brief;
        this.details = details;
        this.number = number;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public boolean isEditing() {
        return isEditing;
    }

    public void setEditing(boolean editing) {
        isEditing = editing;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getCover_price() {
        return cover_price;
    }

    public void setCover_price(String cover_price) {
        cover_price.substring(0, cover_price.length() - 1);
        this.cover_price = cover_price;
    }

    public String getFigure() {
        return figure;
    }

    public void setFigure(String figure) {
        this.figure = figure;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "ProductBean{" +
                "name='" + name + '\'' +
                ", cover_price='" + cover_price + '\'' +
                ", figure='" + figure + '\'' +
                ", product_id='" + product_id + '\'' +
                ", brief='" + brief + '\'' +
                ", details='" + details + '\'' +
                ", number=" + number +
                ", isSelected=" + isSelected +
                ", isEditing=" + isEditing +
                '}';
    }
}
