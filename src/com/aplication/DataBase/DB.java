package com.aplication.DataBase;

import com.aplication.Items.ElectronicsItem;
import com.aplication.abstracts.InventoryItem;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DB {

    private List<InventoryItem> ItemDB;

    public List<InventoryItem> ItemDB() {
        return ItemDB;
    }

    public DB(){
        this.ItemDB=new ArrayList<>();

    }
    public void write(List<InventoryItem> item){


        try {
            ObjectMapper objectMapper = new ObjectMapper();

            String wq= new File("src/com/aplication/DataBase/items.json").getAbsolutePath();

            File f=new File(wq);

            objectMapper.writeValue(f,item);

        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }

    public void read(){
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String wq= new File("src/com/aplication/DataBase/items.json").getAbsolutePath();
            Scanner in = new Scanner(new FileReader(wq));
            StringBuilder sb = new StringBuilder();
            while(in.hasNext()) {
                sb.append(in.next());
            }
            in.close();
            String json = sb.toString();



            InventoryItem[] userFromJSON = objectMapper.readValue(json, InventoryItem[].class);
            this.ItemDB=new ArrayList<>(List.of(userFromJSON));
       } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
