package com.example.shoppersparadise.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppersparadise.R;

import java.util.ArrayList;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.FeaturedView> {
    ArrayList<Featured> feature;

    public FeaturedAdapter(ArrayList<Featured> feature) {
        this.feature = feature;
    }

    @NonNull
    @Override
    public FeaturedView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_card, parent, false);
        return new FeaturedView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedView holder, int position) {

        Featured featuredHelp = feature.get(position);

        holder.image.setImageResource(featuredHelp.getImage());
    }

    public int getItemCount() {
        return feature.size();
    }

    public static class FeaturedView extends RecyclerView.ViewHolder {

        ImageView image;

        public FeaturedView(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.featured_image);

        }

    }

}