package org.example.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;

@Data
public class MenuItem extends Category {

    private String itemName;

    private String itemPrice;

    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
