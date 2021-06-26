package com.example.shoppersparadise.Adapter;

public class OrderHistories {

    String order_history_1, order_history_2, order_history_price;

    public OrderHistories(String order_history_1, String order_history_2, String order_history_price) {
        this.order_history_1 = order_history_1;
        this.order_history_2 = order_history_2;
        this.order_history_price = order_history_price;
    }

    public String getOrder_history_1() {
        return order_history_1;
    }

    public String getOrder_history_2() {
        return order_history_2;
    }

    public String getOrder_history_price() {
        return order_history_price;
    }
}
