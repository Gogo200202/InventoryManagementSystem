package com.aplication.Items;

import com.aplication.abstracts.InventoryItem;

import java.util.Random;

public class FragileItem extends InventoryItem {
    public FragileItem(String itemDescription, String itemDetails,double price) {
        super(itemDescription, itemDetails);
        settingItemCategory("Fragile");
        settingItemPrice(price);
    }
}
