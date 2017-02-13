package edu.ualr.cpsc4399.bjparikh.restaurantapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    private List<Menu> menuList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MenuAdapter menuAdapter;

    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        menuAdapter = new MenuAdapter(menuList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(menuAdapter);

        loadMenu();
        return view;
    }


    private void loadMenu() {
        menuList.add(new Menu("Samosa", "All purpose flour, Oil, Salt, Ajwain, Potatoes, " +
                "Green Peas, Green Chilies, Ginger, Coriander, Garam masala, Salt, " +
                "Red chili powder.", "$3.49" ));
        menuList.add(new Menu("Ragdo Samosa", "Chat Masala pwd, Ginger Garlic Paste, Chickpeas, " +
                "Baking Soda, Oil Yogurt, Onion, Tomato, Turmeric pwd, Red chili pepper, " +
                "Coriander Leaves, All purpose flour, oil, Salt, Ajwain, Potatoes, Green Peas, " +
                "Green Chilies, Ginger, Coriander, Garam masala, Salt, Red chili powder. ", "$3.99"));
        menuList.add(new Menu("Plain Masala Dosa",
                "Rice flour, Yeast, Urad dal flour, Toor dal, Carrot, Green chili, chopped Okra, " +
                "Egg plant baby plant baby, Tomato, Ginger, Coriander leaves.", "$5.99"));
        menuList.add(new Menu("Mysore Masala Dosa", "Rice,Urad Dal / Black Gram Split, " +
                "Boiled Red Rice, Tur Dal/Red Gram Split, Salt, Potatoes,Onion, Green Chilies, " +
                "Coriander Leaves, Lemon Juice, Fresh Grated Coconut, Mustard Seeds, " +
                "Turmeric Powder, Red Chilies, Garlic Pods, Tamarind Pulp.", "$7.99"));
        menuList.add(new Menu("Idli Sambhar", "Rice, Rava, Urad dal, Split black gram, Canola, oil," +
                "Water, Toor dal, Carrot, Green chili, Chopped Okra, Egg plant-baby, Tomato, " +
                "Ginger, Coriander leaves.", "$3.99"));
        menuList.add(new Menu("Idli Chat", "Idlis, Boiled Potatoes, Onions, Sev, Coriander leaves, " +
                "Tomatoes, Cucumber, Green Chutney, Amli – Chutney, Green chilies.", "$4.99"));
        menuList.add(new Menu("Mendu Vada", "Rava Rice, Urad dal, Onion, Green Chilies, Salt, " +
                "Peppercorn, Oil.", "$3.99"));
        menuList.add(new Menu("Bhel", "Puffed rice, Sev, Onion, Tomato, Mango, Finely, " +
                "Turmeric pwd, Carrot grated, Cucumber, Potatoes, Salt, Chili pwd, Green chutney, " +
                "Sweet chutney.", "$3.99"));
        menuList.add(new Menu("Chat Papdi", "All-purpose flour, Oil, Tymol seeds, Salt, Oil, " +
                "Green Chutney & Tamarind Chutney, Cumin Powder, Chat masala Plain Sev," +
                " Beaten fresh curd, Potatoes, Chick Peas, Onion, Coriander Leaves.", "$3.99"));
        menuList.add(new Menu("Ragda Patish", "Chat masala pwd, Ginger, Garlic, Paste, Chickpeas," +
                " Baking Soda, Oil, Yogurt, Onion, Tomato, Turmeric pwd, Red chili pepper," +
                " Coriander Leaves, Potato, Cumin Seed, Turmeric pwd, Bread crumbs, Oil.", "$3.99"));
        menuList.add(new Menu("Khasta Kachori", "All-purpose flour, Rice flour, Oil, " +
                "Yellow Moong dal, Urad dal, Hing, Cumin pwd, Red chilli pwd, Coriander pwd, " +
                "fennel pwd, Garam masala, Salt.", "$2.99"));
        menuList.add(new Menu("Pani Puri", "Semolina, Wheat Flour, Baking Soda, Oil, Tamarind Pulp," +
                " Water, Cumin Seed, Coriander Leaves, Green Chilly, Mint Leaves Chutney, " +
                "Black Salt, Jaggary.", "$3.99"));
        menuAdapter.notifyDataSetChanged();
    }


}
