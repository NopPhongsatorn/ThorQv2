package com.advproject.phongsatorn.thorqv2;

public class PromoModel {
    String title, desc, img ,key;
    public PromoModel(){

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public PromoModel(String title, String desc, String img, String key){
        this.title = title;
        this.desc = desc;
        this.img = img;
        this.key = key;
    }
}
