package com.example.sizzlingbites.Restaurant;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sizzlingbites.DRVinterface.UpdateSelectedItem;
import com.example.sizzlingbites.MainCourse.DynamicRvAdapter;
import com.example.sizzlingbites.OrderAndCart.ApplicationMain;
import com.example.sizzlingbites.R;

import java.util.ArrayList;

public class ResDynamicAdapter extends RecyclerView.Adapter<ResDynamicAdapter.ViewHolder> {

    public ArrayList<ResDynamicModel> models;
    Application activity;
    Context context;
    String name;
    int price;
    UpdateSelectedItem updateSelectedItem;
    private OnItemClickListener listener;

    public ResDynamicAdapter(ArrayList<ResDynamicModel> models, Context context, UpdateSelectedItem updateSelectedItem) {
        this.models = models;
        this.context = context;
        this.updateSelectedItem = updateSelectedItem;
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
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final ResDynamicModel model = models.get(position);
        holder.name.setText(model.getName());
//        holder.price.setText(model.getPrice());
//        holder.rating.setText(model.getRating());
//        holder.review.setText(model.getReviews());
        holder.cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = model.getName();
                price = model.getPrice();

                ((UpdateSelectedItem) ApplicationMain.getMyContext()).addItems(name, price);
                holder.cart.setVisibility(View.INVISIBLE);
                holder.done.setVisibility(View.VISIBLE);
            }
        });

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, price;
        ImageView cart, done;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.res_dy_name);
            price = itemView.findViewById(R.id.res_dy_price);
            cart = itemView.findViewById(R.id.res_cart);
            done = itemView.findViewById(R.id.res_cart_done);
        }
    }
}
