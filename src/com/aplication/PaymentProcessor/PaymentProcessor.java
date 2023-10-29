package com.aplication.PaymentProcessor;

import com.aplication.DataBase.DB;
import com.aplication.abstracts.InventoryItem;

import java.util.List;
import java.util.Locale;

public class PaymentProcessor {
    private DB DBItems;
    // for the peres of this app the money is store here
     private double UserMoney;

    public PaymentProcessor(double money){
        this.DBItems=new DB();
        DBItems.read();
        this.UserMoney=money;
    }

    public void buyItem(String name){


        List<InventoryItem> items=  this.DBItems.ItemDB();
        try {
            name=name.toLowerCase();
            String finalName = name;
            InventoryItem item=items.stream().filter(x->x.displayingItemDescription().toLowerCase().equals(finalName)).findFirst().get();
            UserMoney-=item.getingItemPrice();
            if(UserMoney<=0){
                System.out.println("User don't have enough  money\n");
                UserMoney=0;
                return;
            }
            if(item.getQuantity()<=0){
                System.out.println("No items left\n");
                return;
            }
            item.setQuantity(item.getQuantity()-1);
            this.DBItems.write(items);
        }catch (Exception e){
            System.out.printf("not valid item\n");
        }

    }



}
