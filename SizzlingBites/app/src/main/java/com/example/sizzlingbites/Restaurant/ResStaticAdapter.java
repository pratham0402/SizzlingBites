package com.example.sizzlingbites.Restaurant;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sizzlingbites.DRVinterface.UpdateResRV;
import com.example.sizzlingbites.R;

import java.util.ArrayList;

public class ResStaticAdapter extends RecyclerView.Adapter<ResStaticAdapter.ViewHolder> {

    private ArrayList<ResStaticModel> items;
    int row_index = -1;
    UpdateResRV updateResRV;
    Activity activity;
    boolean check= true, select=true;
    int p;

    public ResStaticAdapter(ArrayList<ResStaticModel> items, UpdateResRV updateResRV, Activity activity) {
        this.items = items;
        this.updateResRV = updateResRV;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.res_static_rv_items, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.img.setImageResource(items.get(position).getImg());
        p = items.get(position).getPos();


        if (check){
            if (p==0){
                ArrayList<ResDynamicModel> items = new ArrayList<ResDynamicModel>();
                items.add(new ResDynamicModel("Pizza 1", "200"));
                items.add(new ResDynamicModel("Pizza 2", "160"));
                items.add(new ResDynamicModel("Pizza 3", "50"));
                items.add(new ResDynamicModel("Pizza 4", "150"));
                items.add(new ResDynamicModel("Pizza 5", "20"));
                updateResRV.callBack(position, items);
            }
            else if(p==1){
                ArrayList<ResDynamicModel> items = new ArrayList<ResDynamicModel>();
                items.add(new ResDynamicModel("Burger 1", "100"));
                items.add(new ResDynamicModel("Burger 2", "160"));
                items.add(new ResDynamicModel("Burger 3", "25"));
                items.add(new ResDynamicModel("Burger 4", "90"));
                items.add(new ResDynamicModel("Burger 5", "120"));
                updateResRV.callBack(position, items);
            }
            else if(p==2){
                ArrayList<ResDynamicModel> items = new ArrayList<ResDynamicModel>();
                items.add(new ResDynamicModel("Fries 1", "200"));
                items.add(new ResDynamicModel("Fries 2", "160"));
                items.add(new ResDynamicModel("Fries 3", "250"));
                items.add(new ResDynamicModel("Fries 4", "150"));
                items.add(new ResDynamicModel("Fries 5", "120"));
                updateResRV.callBack(position, items);
            }
            else if (p==3){
                ArrayList<ResDynamicModel> items = new ArrayList<ResDynamicModel>();
                items.add(new ResDynamicModel("Ice-cream 1", "200"));
                items.add(new ResDynamicModel("Ice-Cream 2", "60"));
                items.add(new ResDynamicModel("Ice-Cream 3", "50"));
                items.add(new ResDynamicModel("Ice-Cream 4", "15"));
                items.add(new ResDynamicModel("Ice-Cream 5", "120"));
                updateResRV.callBack(position, items);
            }
            else if(p==4){
                ArrayList<ResDynamicModel> items = new ArrayList<ResDynamicModel>();
                items.add(new ResDynamicModel("Sandwich 1", "200"));
                items.add(new ResDynamicModel("Sandwich 2", "100"));
                items.add(new ResDynamicModel("Sandwich 3", "150"));
                items.add(new ResDynamicModel("Sandwich 4", "150"));
                items.add(new ResDynamicModel("Sandwich 5", "120"));
                updateResRV.callBack(position, items);
            }
            check=false;
        }

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index = position;
                notifyDataSetChanged();

                //pizza
                if (position==0){
                    ArrayList<ResDynamicModel> items = new ArrayList<ResDynamicModel>();
                    items.add(new ResDynamicModel("Pizza 1", "200"));
                    items.add(new ResDynamicModel("Pizza 2", "160"));
                    items.add(new ResDynamicModel("Pizza 3", "50"));
                    items.add(new ResDynamicModel("Pizza 4", "150"));
                    items.add(new ResDynamicModel("Pizza 5", "20"));
                    updateResRV.callBack(position, items);
                }

                //burger
                else if (position==1){
                    ArrayList<ResDynamicModel> items = new ArrayList<ResDynamicModel>();
                    items.add(new ResDynamicModel("Burger 1", "100"));
                    items.add(new ResDynamicModel("Burger 2", "160"));
                    items.add(new ResDynamicModel("Burger 3", "25"));
                    items.add(new ResDynamicModel("Burger 4", "90"));
                    items.add(new ResDynamicModel("Burger 5", "120"));
                    updateResRV.callBack(position, items);
                }

                //fries
                else if(position==2){
                    ArrayList<ResDynamicModel> items = new ArrayList<ResDynamicModel>();
                    items.add(new ResDynamicModel("Fries 1", "200"));
                    items.add(new ResDynamicModel("Fries 2", "160"));
                    items.add(new ResDynamicModel("Fries 3", "250"));
                    items.add(new ResDynamicModel("Fries 4", "150"));
                    items.add(new ResDynamicModel("Fries 5", "120"));
                    updateResRV.callBack(position, items);
                }

                //ice-cream
                else if (position==3){
                    ArrayList<ResDynamicModel> items = new ArrayList<ResDynamicModel>();
                    items.add(new ResDynamicModel("Ice-cream 1", "200"));
                    items.add(new ResDynamicModel("Ice-Cream 2", "60"));
                    items.add(new ResDynamicModel("Ice-Cream 3", "50"));
                    items.add(new ResDynamicModel("Ice-Cream 4", "15"));
                    items.add(new ResDynamicModel("Ice-Cream 5", "120"));
                    updateResRV.callBack(position, items);
                }

                //sandwich
                else if (position==4){
                    ArrayList<ResDynamicModel> items = new ArrayList<ResDynamicModel>();
                    items.add(new ResDynamicModel("Sandwich 1", "200"));
                    items.add(new ResDynamicModel("Sandwich 2", "100"));
                    items.add(new ResDynamicModel("Sandwich 3", "150"));
                    items.add(new ResDynamicModel("Sandwich 4", "150"));
                    items.add(new ResDynamicModel("Sandwich 5", "120"));
                    updateResRV.callBack(position, items);
                }
            }
        });

        if (select){
            if (position==0){holder.linearLayout.setBackgroundResource(R.drawable.custom_rv_selected);}
            select=false;
        }
        else {
            if (row_index == position){
                holder.linearLayout.setBackgroundResource(R.drawable.custom_rv_selected);
            }
            else {
                holder.linearLayout.setBackgroundResource(R.drawable.custom_rv);
            }
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.res_static_img);
            linearLayout = itemView.findViewById(R.id.res_ll1);
        }
    }
}
