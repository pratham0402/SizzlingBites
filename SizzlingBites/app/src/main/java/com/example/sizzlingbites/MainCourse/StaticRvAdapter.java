package com.example.sizzlingbites.MainCourse;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sizzlingbites.DRVinterface.UpdateRV;
import com.example.sizzlingbites.R;

import java.util.ArrayList;

public class StaticRvAdapter extends RecyclerView.Adapter<StaticRvAdapter.StaticRvViewHolder>{

    private ArrayList<StaticRvModel> items;
    int row_index = -1;
    UpdateRV updateRV;
    Activity activity;
    boolean check= true, select=true;

    public StaticRvAdapter(ArrayList<StaticRvModel> items, UpdateRV updateRV, Activity activity) {
        this.items = items;
        this.updateRV = updateRV;
        this.activity = activity;
    }

    @NonNull
    @Override
    public StaticRvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.static_rv_items, parent, false);
        StaticRvViewHolder staticRvViewHolder = new StaticRvViewHolder(view);
        return staticRvViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StaticRvViewHolder holder, final int position) {

        StaticRvModel currentItem = items.get(position);
        holder.img.setImageResource(currentItem.getN());
        holder.name.setText(currentItem.getText());

        if (check){
            ArrayList<DynamicRvModel> items = new ArrayList<DynamicRvModel>();
            items.add(new DynamicRvModel("Simple Pizza", R.drawable.food_pizza,0));
            items.add(new DynamicRvModel("Cheese Pizza", R.drawable.food_pizza,0));
            items.add(new DynamicRvModel("Pizza Margherita", R.drawable.food_pizza,0));
            items.add(new DynamicRvModel("Pizza Marinara", R.drawable.food_pizza,0));
            items.add(new DynamicRvModel("Chicago Pizza", R.drawable.food_pizza,0));

            updateRV.callBack(position, items);
            check = false;
        }

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index = position;
                notifyDataSetChanged();

                //pizza
                if (position==0){
                    ArrayList<DynamicRvModel> items = new ArrayList<DynamicRvModel>();
                    items.add(new DynamicRvModel("Simple Pizza", R.drawable.food_pizza,0));
                    items.add(new DynamicRvModel("Cheese Pizza", R.drawable.food_pizza,0));
                    items.add(new DynamicRvModel("Pizza Margherita", R.drawable.food_pizza,0));
                    items.add(new DynamicRvModel("Pizza Marinara", R.drawable.food_pizza,0));
                    items.add(new DynamicRvModel("Chicago Pizza", R.drawable.food_pizza,0));

                    updateRV.callBack(position, items);
                }

                //burger
                else if (position==1){
                    ArrayList<DynamicRvModel> items = new ArrayList<DynamicRvModel>();
                    items.add(new DynamicRvModel("Simple Burger", R.drawable.food_burger,1));
                    items.add(new DynamicRvModel("Potato Corn Burger", R.drawable.food_burger,1));
                    items.add(new DynamicRvModel("Crispy Combo Burger", R.drawable.food_burger,1));
                    items.add(new DynamicRvModel("Veg Chilli Burger", R.drawable.food_burger,1));
                    items.add(new DynamicRvModel("burger 5", R.drawable.food_burger,1));

                    updateRV.callBack(position, items);
                }

                //fries
                else if(position==2){
                    ArrayList<DynamicRvModel> items = new ArrayList<DynamicRvModel>();
                    items.add(new DynamicRvModel("French Fires", R.drawable.food_fries,2));
                    items.add(new DynamicRvModel("Tornado Fries", R.drawable.food_fries,2));
                    items.add(new DynamicRvModel("Sweet Potato Fries", R.drawable.food_fries,2));
                    items.add(new DynamicRvModel("Steak Fries", R.drawable.food_fries,2));
                    items.add(new DynamicRvModel("Tater Tots", R.drawable.food_fries,2));

                    updateRV.callBack(position, items);
                }

                //ice-cream
                else if (position==3){
                    ArrayList<DynamicRvModel> items = new ArrayList<DynamicRvModel>();
                    items.add(new DynamicRvModel("Chocolate ice-cream", R.drawable.food_icecream,3));
                    items.add(new DynamicRvModel("Vanilla ice-cream", R.drawable.food_icecream,3));
                    items.add(new DynamicRvModel("Mango ice-cream", R.drawable.food_icecream,3));
                    items.add(new DynamicRvModel("Stawberry ice-cream", R.drawable.food_icecream,3));
                    items.add(new DynamicRvModel("Mint Chocolate ice-cream", R.drawable.food_icecream,3));

                    updateRV.callBack(position, items);
                }

                //sandwich
                else if (position==4){
                    ArrayList<DynamicRvModel> items = new ArrayList<DynamicRvModel>();
                    items.add(new DynamicRvModel("Simple Sandwich", R.drawable.food_sandwich,4));
                    items.add(new DynamicRvModel("Tomato Cucumber Sandwich", R.drawable.food_sandwich,4));
                    items.add(new DynamicRvModel("Panner Sandwich", R.drawable.food_sandwich,4));
                    items.add(new DynamicRvModel("Curd Sandwich", R.drawable.food_sandwich,4));
                    items.add(new DynamicRvModel("Grilled Cheese Sandwich", R.drawable.food_sandwich,4));

                    updateRV.callBack(position, items);
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

    public static class StaticRvViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        ImageView img;
        LinearLayout linearLayout;

        public StaticRvViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.f_name);
            img = itemView.findViewById(R.id.f_icon);
            linearLayout = itemView.findViewById(R.id.ll1);
        }
    }

}
