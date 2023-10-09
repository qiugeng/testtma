package com.getTema.tma.lyrric.model;

/**
 * Created on 2020-07-23.
 * 疫苗列表
 * @author wangxiaodong
 */

public class TestVoList {

    private Integer age;
    private String sx;
    private Integer num;
    private Integer price;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSx() {
        return sx;
    }

    public void setSx(String sx) {
        this.sx = sx;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getPrice() {
        return this.num*5;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
