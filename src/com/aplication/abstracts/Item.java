package com.aplication.abstracts;

import com.aplication.interfaces.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public abstract class Item implements Categorizable, Breakable, Itemabel, Perishable, Sellable, Serializable {

    @JsonProperty("ItemCategory")
   protected String category;

    private  boolean breakable;

    private boolean perishable;
    @JsonProperty("ItemPrice")
    private double sellable;

    @JsonProperty("ItemDetails")
     private String ItemDetails;
    @JsonProperty("ItemDescription")
    private String ItemDescription;

    public Item(String itemDescription,String itemDetails){

        this.ItemDescription=itemDescription;
        this.ItemDetails=itemDetails;
    }
    @Override
    public boolean Ifbreakable() {
        return breakable;
    }

    @Override
    public void handlingItemBreakage(boolean brakabel) {

        this.breakable=brakabel;
    }

    @Override
    public void settingItemCategory(String category) {
        this.category=category;
    }
    @JsonProperty("ItemCategory")
    @Override
    public String getingItemCategory() {
        return this.category;
    }
    @JsonProperty("ItemDetails")
    @Override
    public String gettingItemDetails() {
        return this.ItemDetails;
    }
    @JsonProperty("ItemDescription")
    @Override
    public String displayingItemDescription() {
        return this.ItemDescription;
    }

    @Override
    public boolean IfPerishable() {
        return this.perishable;
    }

    @Override
    public void handlingItemPerishable(boolean perishable) {
    this.perishable=perishable;
    }



    @Override
    public void settingItemPrice(double price) {

        this.sellable=price;
    }
    @JsonProperty("ItemPrice")
    @Override
    public double getingItemPrice() {
        return this.sellable;
    }
}
