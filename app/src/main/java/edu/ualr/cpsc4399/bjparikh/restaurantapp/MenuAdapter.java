package edu.ualr.cpsc4399.bjparikh.restaurantapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by bhavya on 12/7/2016.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyViewHolder> {
    private List<Menu> menuList;

    public MenuAdapter(List<Menu> menuList){
        this.menuList = menuList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView name, ingredient, price;
        public MyViewHolder(final View view){
            super(view);
            name = (TextView) view.findViewById(R.id.titleText);
            ingredient = (TextView) view.findViewById(R.id.qualityText);
            price = (TextView) view.findViewById(R.id.viewsText);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Menu currentMenu = menuList.get(getAdapterPosition());
                    AlertDialog.Builder alert = new AlertDialog.Builder(view.getContext());
                    alert.setMessage("Do you want to add this item to cart?").setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    SharedPreferences sharedPreferences = PreferenceManager
                                            .getDefaultSharedPreferences(view.getContext());
                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    editor.putString("Item_price", currentMenu.getItem_price());
                                    editor.putString("Item_name", currentMenu.getItem_name());
                                    editor.commit();
                                    Intent intent = new Intent(view.getContext(), CartActivity.class);
//                                    intent.putExtra("Item name", currentMenu.getItem_name());
                                    view.getContext().startActivity(intent);
                                    Toast.makeText(view.getContext(), currentMenu.getItem_name() +
                                            " Added. Click on cart" +
                                            "button on top-right to view the cart", Toast.LENGTH_LONG)
                                            .show();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert_msg = alert.create();
                    alert_msg.setTitle("Add item to Cart!!");
                    alert_msg.show();
                }
            });
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_list, parent,
                false);
        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Menu menu = menuList.get(position);
        holder.name.setText(menu.getItem_name());
        holder.ingredient.setText(menu.getItem_ingredient());
        holder.price.setText(menu.getItem_price());
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }
}
