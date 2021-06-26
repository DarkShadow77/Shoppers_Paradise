package com.example.shoppersparadise.Adapter;


public class OrderDetail {

    int order_image;
    String order_text1, order_text2, order_text3, order_text4;

    public OrderDetail(int order_image, String order_text1, String order_text2, String order_text3, String order_text4) {
        this.order_image = order_image;
        this.order_text1 = order_text1;
        this.order_text2 = order_text2;
        this.order_text3 = order_text3;
        this.order_text4 = order_text4;
    }

    public int getOrder_image() {
        return order_image;
    }

    public String getOrder_text1() {
        return order_text1;
    }

    public String getOrder_text2() {
        return order_text2;
    }

    public String getOrder_text3() {
        return order_text3;
    }

    public String getOrder_text4() {
        return order_text4;
    }
}
