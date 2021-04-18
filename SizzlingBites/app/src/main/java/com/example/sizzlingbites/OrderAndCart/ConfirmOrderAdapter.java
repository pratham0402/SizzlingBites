package com.example.sizzlingbites.OrderAndCart;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sizzlingbites.DRVinterface.UpdateSelectedItem;
import com.example.sizzlingbites.R;

import java.util.ArrayList;

public class ConfirmOrderAdapter extends RecyclerView.Adapter<ConfirmOrderAdapter.ViewHolder> {

    private ArrayList<OrderListModel> models;
    Activity activity;

    public ConfirmOrderAdapter( Activity activity) {
        models = ((UpdateSelectedItem)ApplicationMain.getMyContext()).getItems();
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.confirm_rv_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OrderListModel model = models.get(position);
        holder.name.setText(model.getName());
//        holder.price.setText(model.getPrice());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name= itemView.findViewById(R.id.confirm_name);
            price = itemView.findViewById(R.id.confirm_price);
        }
    }
}
