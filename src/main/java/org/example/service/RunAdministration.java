package org.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.repository.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;



public class RunAdministration {

    private static final Logger logger = LogManager.getLogger(RunAdministration.class);

    public static void main(String[] args) {
        Administration newAdmin = new Administration();
        while(true) {
            System.out.println("------------------------------------");
            System.out.println("*************************************");
            System.out.println("------------------------------------");
            System.out.println("Welcome to Hamburger Administration");
            System.out.println("Select from the following options");
            System.out.println("1.Contact 2.Locations 3.Menu 4.Reservations");
            System.out.println("Press 5 to exit");
            Scanner scanner = new Scanner(System.in);
            String selectInput = scanner.nextLine();
            int selection = 0;
            try {
                selection = Integer.parseInt(selectInput);
            } catch (InputMismatchException e) {
                System.out.println("Enter correct input");
                logger.error("Invalid Input {}", e.getMessage());
            }
            switch (selection) {
                case 1:
                    System.out.println("Select from the following options");
                    System.out.println("1.View Contact 2.Update Contact");
                    String choiceInput = scanner.nextLine();
                    int choice = 0;
                    try {
                        choice = Integer.parseInt(choiceInput);
                    } catch (InputMismatchException e) {
                        logger.error("Invalid Input {}", e.getMessage());
                    }
                    switch (choice) {
                        case 1:
                            System.out.println(newAdmin.getCorporateContact());
                            break;
                        case 2:
                            Contact contact = new Contact();
                            System.out.println("Enter First name");
                            contact.setFirstName(scanner.nextLine());
                            System.out.println("Enter Last name");
                            contact.setLastName(scanner.nextLine());
                            System.out.println("Enter phone number");
                            contact.setPhone(scanner.nextLine());
                            newAdmin.setCorporateContact(contact);
                            break;
                        default:
                            logger.error("Invalid selection");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Select from the following options");
                    System.out.println("1.View Locations 2.Add Location");
                    String locationChoiceInput = scanner.nextLine();
                    int locationChoice = 0;
                    try {
                        locationChoice = Integer.parseInt(locationChoiceInput);
                    } catch (InputMismatchException e) {
                        logger.error("Invalid Input {}", e.getMessage());
                    }
                    switch (locationChoice) {
                        case 1:
                            if(newAdmin.getLocations() == null)
                                System.out.println("Currently there are no locations added");
                            else
                                System.out.println(newAdmin.getLocations());
                            break;
                        case 2:
                            Location location = new Location();
                            System.out.println("Enter Address");
                            location.setAddress(scanner.nextLine());
                            Contact contact = new Contact();
                            System.out.println("Enter First name");
                            contact.setFirstName(scanner.nextLine());
                            System.out.println("Enter Last name");
                            contact.setLastName(scanner.nextLine());
                            System.out.println("Enter phone number");
                            contact.setPhone(scanner.nextLine());
                            location.setContact(contact);
                            if(newAdmin.getLocations() == null) newAdmin.setLocations(new ArrayList<Location>());
                            newAdmin.getLocations().add(location);
                            break;
                        default:
                            System.out.println("Invalid selection");
                            logger.error("Invalid input");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Select from the following options");
                    System.out.println("1.View Menu 2.Add Item to Menu");
                    String menuChoiceInput = scanner.nextLine();
                    int menuChoice = 0;
                    try {
                        menuChoice = Integer.parseInt(menuChoiceInput);
                    } catch (InputMismatchException e) {
                        logger.error("Invalid Input {}", e.getMessage());
                    }
                    switch (menuChoice) {
                        case 1:
                            if(newAdmin.getMenu() == null)
                                System.out.println("Currently there are is no Menu added");
                            else
                                System.out.println(newAdmin.getMenu());
                            break;
                        case 2:
                            Item item = new Item();
                            System.out.println("Enter the category");
                            item.setCategoryName(scanner.nextLine());
                            System.out.println("Enter the item name");
                            item.setItemName(scanner.nextLine());
                            System.out.println("Enter the item price");
                            try {
                                item.setItemPrice(scanner.nextInt());
                            } catch (InputMismatchException e) {
                                logger.error("Invalid input {}", e.getMessage());
                            }
                            if(newAdmin.getMenu() == null) newAdmin.setMenu(new ArrayList<Item>());

                            newAdmin.getMenu().add(item);
                            break;
                        default:
                            System.out.println("Invalid selection");
                            logger.error("Invalid input");
                            break;

                    }
                    break;
                case 4:
                    System.out.println("Select from the following options");
                    System.out.println("1.View Reservations 2.Create Reservation");
                    String reservationChoiceInput = scanner.nextLine();
                    int reservationChoice = 0;
                    try {
                        reservationChoice = Integer.parseInt(reservationChoiceInput);
                    } catch (InputMismatchException e) {
                        logger.error("Invalid Input {}", e.getMessage());
                    }
                    switch (reservationChoice) {
                        case 1:
                            if(newAdmin.getReservations() == null)
                                System.out.println("Currently there are no Reservations added");
                            else
                                System.out.println(newAdmin.getReservations());
                            break;
                        case 2:
                            Reservation reservation = new Reservation();
                            System.out.println("Enter event date");
                            reservation.setEventDate(scanner.nextLine());
                            System.out.println("Enter start time");
                            reservation.setStartTime(scanner.nextLine());
                            System.out.println("Enter end time");
                            reservation.setEndTime(scanner.nextLine());
                            System.out.println("Enter size");
                            try {
                                reservation.setSize(scanner.nextInt());
                            } catch (InputMismatchException e) {
                                logger.error("Incorrect input size {}",e.getMessage());
                                e.printStackTrace();
                            }
                            if(newAdmin.getReservations() == null) newAdmin.setReservations(new ArrayList<Reservation>());
                            newAdmin.getReservations().add(reservation);
                            break;
                        default:
                            System.out.println("Invalid selection");
                            logger.error("Invalid input");
                            break;
                    }
                    break;
                case 5:
                    System.out.println("Terminating the administration");
                    scanner.close();
                    break;
                default:
                    System.out.println("Please enter a correct choice");
                    break;
            }
            if(selection == 5) {
                break;
            }
        }
    }
}
