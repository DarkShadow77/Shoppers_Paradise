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

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryView> {
    ArrayList<Category> category;

    public CategoryAdapter(ArrayList<Category> category) {
        this.category = category;
    }

    @NonNull
    @Override
    public CategoryView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_card, parent, false);
        return new CategoryView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryView holder, int position) {

        Category categoryHelp = category.get(position);

        holder.categories_name.setText(categoryHelp.getCategories_name());
    }

    public int getItemCount() {
        return category.size();
    }

    public static class CategoryView extends RecyclerView.ViewHolder {

        TextView categories_name;

        public CategoryView(@NonNull View itemView) {
            super(itemView);

            categories_name = itemView.findViewById(R.id.category_title);

        }

    }

}