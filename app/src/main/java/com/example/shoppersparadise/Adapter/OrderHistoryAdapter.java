package com.example.shoppersparadise.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppersparadise.R;

import java.util.ArrayList;

public class OrderHistoryAdapter extends RecyclerView.Adapter<OrderHistoryAdapter.Order_History_View> {
    ArrayList<OrderHistories> orderhistory;

    public OrderHistoryAdapter(ArrayList<OrderHistories> orderhistory) {
        this.orderhistory = orderhistory;
    }

    @NonNull
    @Override
    public Order_History_View onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_history_card, parent, false);
        return new Order_History_View(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Order_History_View holder, int position) {

        OrderHistories orderHistoryHelp = orderhistory.get(position);

        holder.order_text1.setText(orderHistoryHelp.getOrder_history_1());
        holder.order_text2.setText(orderHistoryHelp.getOrder_history_2());
        holder.order_text3.setText(orderHistoryHelp.getOrder_history_price());
    }

    public int getItemCount() {
        return orderhistory.size();
    }

    public static class Order_History_View extends RecyclerView.ViewHolder {

        TextView order_text1, order_text2, order_text3;

        public Order_History_View(@NonNull View itemView) {
            super(itemView);

            order_text1 = itemView.findViewById(R.id.order_history_1);
            order_text2 = itemView.findViewById(R.id.order_history_2);
            order_text3 = itemView.findViewById(R.id.order_history_price);

        }

    }

}