package edu.ualr.cpsc4399.bjparikh.restaurantapp;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    String item;
    String item_price;
    ArrayList<String> items;
    SharedPreferences sharedPreferences;

//    ArrayList<String> addArray = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
//        int a = sharedPreferences.getAll().size();
        item = sharedPreferences.getString("Item_name", "No Item found");
        item_price = sharedPreferences.getString("Item_price", "No price found");
        items = new ArrayList<>();

        items.add(item + "           " + item_price);

        ListView cartView = (ListView) findViewById(R.id.listView);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                 items);
        cartView.setAdapter(arrayAdapter);

        cartView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder a_builder = new AlertDialog.Builder(CartActivity.this);
                a_builder.setMessage("Do you want to delete this item from cart?").setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                items.remove(position);
                                arrayAdapter.notifyDataSetChanged();
                                sharedPreferences.edit().clear().commit();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alertDialog = a_builder.create();
                alertDialog.setTitle("Delete Item From Cart!!");
                alertDialog.show();
            }
        });


    }
}
