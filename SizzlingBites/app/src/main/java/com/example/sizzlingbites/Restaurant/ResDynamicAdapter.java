package com.example.sizzlingbites.Restaurant;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sizzlingbites.MainCourse.DynamicRvAdapter;
import com.example.sizzlingbites.R;

import java.util.ArrayList;

public class ResDynamicAdapter extends RecyclerView.Adapter<ResDynamicAdapter.ViewHolder> {

    public ArrayList<ResDynamicModel> models;
    private OnItemClickListener listener;

    public ResDynamicAdapter(ArrayList<ResDynamicModel> models) {
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
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.res_dynamic_rv_items, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ResDynamicModel model = models.get(position);
        holder.name.setText(model.getName());
        holder.price.setText(model.getPrice());
        holder.rating.setText(model.getRating());
        holder.review.setText(model.getReviews());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, price, rating, review;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.res_dy_name);
            price = itemView.findViewById(R.id.res_dy_price);
            rating = itemView.findViewById(R.id.res_rating);
            review = itemView.findViewById(R.id.res_review);
        }
    }
}
