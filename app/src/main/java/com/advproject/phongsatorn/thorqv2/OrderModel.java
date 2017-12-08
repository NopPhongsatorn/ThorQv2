package com.advproject.phongsatorn.thorqv2;

public class OrderModel {
    String title, desc, key, img;
    int que;

    public OrderModel(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getQue() {
        return que;
    }

    public void setQue(int que) {
        this.que = que;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public OrderModel(String title, String desc, int que, String key, String img){
        this.title = title;
        this.desc = desc;
        this.que = que;
        this.key = key;
        this.img = img;
    }
}
