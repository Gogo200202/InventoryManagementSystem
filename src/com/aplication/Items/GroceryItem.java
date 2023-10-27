package com.aplication.Items;

import com.aplication.abstracts.InventoryItem;

import java.util.Random;

public class GroceryItem extends InventoryItem {
    public GroceryItem(String itemDescription, String itemDetails,double price) {
        super(itemDescription, itemDetails);
        settingItemCategory("Grocery");
        settingItemPrice(price);
    }

}
