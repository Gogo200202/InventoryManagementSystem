package com.aplication.abstracts;

import com.aplication.abstracts.Item;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Random;

public class InventoryItem extends Item {


    private String itemID;

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }


    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public InventoryItem(@JsonProperty("itemDescription")String itemDescription,@JsonProperty("itemDetails") String itemDetails){
        super(itemDescription,itemDetails);
        Random rand = new Random();
        int randomnumber=rand.nextInt();
        setItemID(Integer.toString(randomnumber));

    }



}
