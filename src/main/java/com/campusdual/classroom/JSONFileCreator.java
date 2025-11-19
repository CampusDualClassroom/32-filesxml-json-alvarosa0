package com.campusdual.classroom;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JSONFileCreator {
    public static void main(String[] args) {
        createDocument();
    }

    public static void createDocument(){
        JsonArray itemsArray = new JsonArray();
        itemsArray.add( createItem(2 , "Manzana") );
        itemsArray.add( createItem(1 , "Leche") );
        itemsArray.add( createItem(3 , "Pan") );
        itemsArray.add( createItem(2 , "Huevo") );
        itemsArray.add( createItem(1 , "Queso") );
        itemsArray.add( createItem(1 , "Cereal") );
        itemsArray.add( createItem(4 , "Agua") );
        itemsArray.add( createItem(6 , "Yogur") );
        itemsArray.add( createItem(2 , "Arroz") );

        JsonObject items = new JsonObject();
        items.add("items", itemsArray);

        File dir = new File("src/main/resources");
        if(!dir.exists()){
            dir.mkdir();
        }

        try (FileWriter fw = new FileWriter("src/main/resources/shoppingList.json")) {
            //sin formatear
            //fw.write(items.toString());
            //con formateo
            Gson gson= new GsonBuilder().setPrettyPrinting().create();
            String json= gson.toJson(items);
            fw.write(json);
            fw.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static JsonObject createItem(int quantity, String itemDesc){
        JsonObject obj= new JsonObject();
        obj.addProperty("quantity", quantity);
        obj.addProperty("text", itemDesc);
        return obj;
    }


}
