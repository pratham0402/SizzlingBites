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
                items.add(new ResDynamicModel("Simple Pizza", "50"));
                items.add(new ResDynamicModel("Cheese Pizza", "160"));
                items.add(new ResDynamicModel("Pizza Margherita", "100"));
                items.add(new ResDynamicModel("Pizza Marinara", "150"));
                items.add(new ResDynamicModel("Chicago Pizza", "120"));
                updateResRV.callBack(position, items);
            }
            else if(p==1){
                ArrayList<ResDynamicModel> items = new ArrayList<ResDynamicModel>();
                items.add(new ResDynamicModel("Simple Burger", "40"));
                items.add(new ResDynamicModel("Potato Corn Burger", "160"));
                items.add(new ResDynamicModel("Crispy Combo Burger", "125"));
                items.add(new ResDynamicModel("Veg Chilli Burger", "90"));
                items.add(new ResDynamicModel("Burger 5", "138"));
                updateResRV.callBack(position, items);
            }
            else if(p==2){
                ArrayList<ResDynamicModel> items = new ArrayList<ResDynamicModel>();
                items.add(new ResDynamicModel("French Fires", "60"));
                items.add(new ResDynamicModel("Tornado Fries", "160"));
                items.add(new ResDynamicModel("Sweet Potato Fries", "150"));
                items.add(new ResDynamicModel("Steak Fries", "100"));
                items.add(new ResDynamicModel("Tater Tots", "120"));
                updateResRV.callBack(position, items);
            }
            else if (p==3){
                ArrayList<ResDynamicModel> items = new ArrayList<ResDynamicModel>();
                items.add(new ResDynamicModel("Chocolate ice-cream", "45"));
                items.add(new ResDynamicModel("Vanilla ice-cream", "60"));
                items.add(new ResDynamicModel("Mango ice-cream", "80"));
                items.add(new ResDynamicModel("Stawberry ice-cream", "55"));
                items.add(new ResDynamicModel("Mint Chocolate ice-cream", "95"));
                updateResRV.callBack(position, items);
            }
            else if(p==4){
                ArrayList<ResDynamicModel> items = new ArrayList<ResDynamicModel>();
                items.add(new ResDynamicModel("Simple Sandwich", "20"));
                items.add(new ResDynamicModel("Tomato Cucumber Sandwich", "49"));
                items.add(new ResDynamicModel("Panner Sandwich", "79"));
                items.add(new ResDynamicModel("Curd Sandwich", "99"));
                items.add(new ResDynamicModel("Grilled Cheese Sandwich", "65"));
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
                    items.add(new ResDynamicModel("Simple Pizza", "50"));
                    items.add(new ResDynamicModel("Cheese Pizza", "160"));
                    items.add(new ResDynamicModel("Pizza Margherita", "100"));
                    items.add(new ResDynamicModel("Pizza Marinara", "150"));
                    items.add(new ResDynamicModel("Chicago Pizza", "120"));
                    updateResRV.callBack(position, items);
                }

                //burger
                else if (position==1){
                    ArrayList<ResDynamicModel> items = new ArrayList<ResDynamicModel>();
                    items.add(new ResDynamicModel("Simple Burger", "40"));
                    items.add(new ResDynamicModel("Potato Corn Burger", "160"));
                    items.add(new ResDynamicModel("Crispy Combo Burger", "125"));
                    items.add(new ResDynamicModel("Veg Chilli Burger", "90"));
                    items.add(new ResDynamicModel("Burger 5", "138"));
                    updateResRV.callBack(position, items);
                }

                //fries
                else if(position==2){
                    ArrayList<ResDynamicModel> items = new ArrayList<ResDynamicModel>();
                    items.add(new ResDynamicModel("French Fires", "60"));
                    items.add(new ResDynamicModel("Tornado Fries", "160"));
                    items.add(new ResDynamicModel("Sweet Potato Fries", "150"));
                    items.add(new ResDynamicModel("Steak Fries", "100"));
                    items.add(new ResDynamicModel("Tater Tots", "120"));
                    updateResRV.callBack(position, items);
                }

                //ice-cream
                else if (position==3){
                    ArrayList<ResDynamicModel> items = new ArrayList<ResDynamicModel>();
                    items.add(new ResDynamicModel("Chocolate ice-cream", "45"));
                    items.add(new ResDynamicModel("Vanilla ice-cream", "60"));
                    items.add(new ResDynamicModel("Mango ice-cream", "80"));
                    items.add(new ResDynamicModel("Stawberry ice-cream", "55"));
                    items.add(new ResDynamicModel("Mint Chocolate ice-cream", "95"));
                    updateResRV.callBack(position, items);
                }

                //sandwich
                else if (position==4){
                    ArrayList<ResDynamicModel> items = new ArrayList<ResDynamicModel>();
                    items.add(new ResDynamicModel("Simple Sandwich", "20"));
                    items.add(new ResDynamicModel("Tomato Cucumber Sandwich", "49"));
                    items.add(new ResDynamicModel("Panner Sandwich", "79"));
                    items.add(new ResDynamicModel("Curd Sandwich", "99"));
                    items.add(new ResDynamicModel("Grilled Cheese Sandwich", "65"));
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
