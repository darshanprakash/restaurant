package org.example.repository;

import lombok.Data;

import java.util.List;

@Data
public class Administration {

    private Contact corporateContact;

    private List<Location> locations;

    private List<Reservation> reservations;

    private List<Item> menu;

    private List<Item> specials;
}
