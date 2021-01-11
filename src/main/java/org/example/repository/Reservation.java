package org.example.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;

@Data
public class Reservation {

    private String startTime;

    private String endTime;

    private String eventDate;

    private Integer size;

    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
