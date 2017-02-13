package edu.ualr.cpsc4399.bjparikh.restaurantapp;

/**
 * Created by bhavya on 12/7/2016.
 */

public class Menu {
    private String item_name;
    private String item_ingredient;
    private String item_price;

    public Menu(String item_name, String item_ingredient, String item_price) {
        this.item_name = item_name;
        this.item_ingredient = item_ingredient;
        this.item_price = item_price;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_ingredient() {
        return item_ingredient;
    }

    public void setItem_ingredient(String item_ingredient) {
        this.item_ingredient = item_ingredient;
    }

    public String getItem_price() {
        return item_price;
    }

    public void setItem_price(String item_price) {
        this.item_price = item_price;
    }
}
