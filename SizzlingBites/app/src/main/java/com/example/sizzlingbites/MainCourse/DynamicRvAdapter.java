package com.example.sizzlingbites.MainCourse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sizzlingbites.R;

import java.util.ArrayList;

public class DynamicRvAdapter extends RecyclerView.Adapter<DynamicRvAdapter.DynamicRvHolder>{

    public ArrayList<DynamicRvModel> models;
    private OnItemClickListener listener;

    public DynamicRvAdapter(ArrayList<DynamicRvModel> models) {
        this.models = models;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public DynamicRvHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dynamic_rv_items, parent, false);
        return new DynamicRvHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull DynamicRvHolder holder, int position) {
        DynamicRvModel model = models.get(position);
        holder.imageView.setImageResource(model.getImage());
        holder.textView.setText(model.getName());
        holder.ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingBar.setRating(rating);
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class DynamicRvHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        RatingBar ratingBar;
        ConstraintLayout constraintLayout;
        public DynamicRvHolder(@NonNull View itemView, final OnItemClickListener listener){
            super(itemView);
            imageView = itemView.findViewById(R.id.dy_img);
            textView = itemView.findViewById(R.id.dy_name);
            constraintLayout = itemView.findViewById(R.id.constraintLayout);
            ratingBar = itemView.findViewById(R.id.dy_rating);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener!=null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }
}