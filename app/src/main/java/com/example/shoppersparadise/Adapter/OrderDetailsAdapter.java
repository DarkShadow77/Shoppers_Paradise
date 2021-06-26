package com.example.shoppersparadise.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppersparadise.R;

import java.util.ArrayList;

public class OrderDetailsAdapter extends RecyclerView.Adapter<OrderDetailsAdapter.Order_View> {
    ArrayList<OrderDetail> order;

    public OrderDetailsAdapter(ArrayList<OrderDetail> order) {
        this.order = order;
    }

    @NonNull
    @Override
    public Order_View onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_card, parent, false);
        return new Order_View(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Order_View holder, int position) {

        OrderDetail orderHelp = order.get(position);

        holder.order_image.setImageResource(orderHelp.getOrder_image());
        holder.order_text1.setText(orderHelp.getOrder_text1());
        holder.order_text2.setText(orderHelp.getOrder_text2());
        holder.order_text3.setText(orderHelp.getOrder_text3());
        holder.order_text4.setText(orderHelp.getOrder_text4());
    }

    public int getItemCount() {
        return order.size();
    }

    public static class Order_View extends RecyclerView.ViewHolder {

        ImageView order_image;
        TextView order_text1, order_text2, order_text3, order_text4;

        public Order_View(@NonNull View itemView) {
            super(itemView);

            order_image = itemView.findViewById(R.id.order_image);
            order_text1 = itemView.findViewById(R.id.order_text_1);
            order_text2 = itemView.findViewById(R.id.order_text_2);
            order_text3 = itemView.findViewById(R.id.order_price);
            order_text4 = itemView.findViewById(R.id.order_quantity);

        }

    }

}