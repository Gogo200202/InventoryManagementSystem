package com.aplication;

import com.aplication.DataBase.DB;
import com.aplication.Items.ElectronicsItem;
import com.aplication.Items.FragileItem;
import com.aplication.Items.GroceryItem;
import com.aplication.abstracts.InventoryItem;
import com.aplication.abstracts.Item;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class AplicationLogic {

    private DB DBItems;
    public AplicationLogic(){
       this.DBItems=new DB();
        DBItems.read();

    }

    public InventoryItem finedItemByName(String name){
        List<InventoryItem> items=  this.DBItems.ItemDB();
        InventoryItem item=items.stream().filter(x->x.displayingItemDescription().equals(name)).findFirst().get();
        return item;
    }
    public void removeItemById(String id){
        List<InventoryItem> items=  this.DBItems.ItemDB();
        items.remove(items.stream().filter(x->x.getItemID().equals(id)).findFirst().get());
        this.DBItems.write(items);

    }

    public void addItem(){
        Scanner sc=new Scanner(System.in);
        List<InventoryItem> items=  this.DBItems.ItemDB();
        System.out.printf("What to add \n");
        System.out.printf("Electronic \n");
        System.out.printf("Fragile \n");
        System.out.printf("Grocery \n");
        String comnad=sc.nextLine();
        InventoryItem item=null;
        System.out.printf("Item description \n");
        String itemDescription=sc.nextLine();
        System.out.printf("Item details \n");
        String itemDetails=sc.nextLine();
        System.out.printf("Price \n");
        double price=Double.parseDouble(sc.nextLine());
        if(comnad.equals("Electronic")){
            item=new ElectronicsItem(itemDescription,itemDetails,price);
        }else if(comnad.equals("Fragile")){
            item=new FragileItem(itemDescription,itemDetails,price);
        }else if(comnad.equals("Grocery")){
            item=new GroceryItem(itemDescription,itemDetails,price);
        }else {
            System.out.printf("Not valid name \n");
        }

        items.add(item);
        this.DBItems.write(items);
    }

    public void  addQuantity(String id){
        List<InventoryItem> items=  this.DBItems.ItemDB();
        InventoryItem item=items.stream().filter(x->x.getItemID().equals(id)).findFirst().get();
        item.setQuantity(item.getQuantity()+1);
        this.DBItems.write(items);
    }

    public void showAllItemsInCategory(){
      List<InventoryItem> items=  this.DBItems.ItemDB();

        Map<String,List<InventoryItem>> uniqPeopleByAge = items.stream().distinct().collect(groupingBy(Item::getingItemCategory));

        for (var entry : uniqPeopleByAge.entrySet()) {

            System.out.print(entry.getKey()+"\n");
            for (var curentElement:entry.getValue()) {
                System.out.println("Item Id "+curentElement.getItemID());
                System.out.println("Quantity "+curentElement.getQuantity());
                System.out.println("Details "+curentElement.gettingItemDetails());
                System.out.println("Description "+curentElement.displayingItemDescription());
                System.out.println("Price "+curentElement.getingItemPrice());
                System.out.println();
            }

        }

    }
}
