package com.example.sizzlingbites.OrderAndCart;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final OrderListModel model = models.get(position);
        holder.name.setText(model.getName());
        holder.price.setText(model.getPrice());
        model.setQuantity(1);

        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = (String) holder.quan.getText();
                int i = Integer.parseInt(s);
                i++;
                model.setQuantity(i);
                s = Integer.toString(i);
                holder.quan.setText(Integer.toString(model.getQuantity()));
            }
        });

        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = (String) holder.quan.getText();
                int i = Integer.parseInt(s);
                if (i>0){
                    i--;
                    model.setQuantity(i);
                    s = Integer.toString(i);
                    holder.quan.setText(Integer.toString(model.getQuantity()));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, price, quan;
        ImageView add,minus;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name= itemView.findViewById(R.id.confirm_name);
            price = itemView.findViewById(R.id.confirm_price);
            quan = itemView.findViewById(R.id.confirm_amt);
            add = itemView.findViewById(R.id.add);
            minus = itemView.findViewById(R.id.minus);
        }
    }
}
