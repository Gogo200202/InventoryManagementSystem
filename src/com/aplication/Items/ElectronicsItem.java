package com.aplication.Items;

import com.aplication.abstracts.InventoryItem;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Random;

public class ElectronicsItem extends InventoryItem {

    public ElectronicsItem(String itemDescription, String itemDetails, double price) {
        super(itemDescription, itemDetails);
        settingItemCategory("Electric");

        settingItemPrice(price);
    }
}
