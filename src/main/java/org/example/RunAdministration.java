package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.repository.Contact;
import org.example.repository.Location;
import org.example.repository.MenuItem;
import org.example.repository.Reservation;
import org.example.service.AdminOps;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class RunAdministration {

    private static final Logger logger = LogManager.getLogger(RunAdministration.class);

    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("------------------------------------");
            System.out.println("*************************************");
            System.out.println("------------------------------------");
            System.out.println("Welcome to Hamburger Administration");
            System.out.println("Select from the following options");
            System.out.println("1.Contact 2.Location 3.MenuItem 4.Reservation");
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
                    AdminOps<Contact> contactAdminOps = new AdminOps<>();
                    Contact contact = new Contact();
                    System.out.println("Select from the following options");
                    System.out.println("1.View Contact 2.Create contact");
                    String choiceInput = scanner.nextLine();
                    int choice = 0;
                    try {
                        choice = Integer.parseInt(choiceInput);
                    } catch (InputMismatchException e) {
                        logger.error("Invalid Input {}", e.getMessage());
                    }
                    switch (choice) {
                        case 1:
                            break;
                        case 2:
                            try {
                                System.out.println("Enter First name");
                                contact.setFirstName(scanner.nextLine());
                                System.out.println("Enter Last name");
                                contact.setLastName(scanner.nextLine());
                                System.out.println("Enter phone number");
                                contact.setPhone(scanner.nextLine());
                                contactAdminOps.create(contact);
                            } catch (IOException e) {
                                logger.error("Failed to add contact {}", contact);
                                e.printStackTrace();
                            }
                            break;
                        default:
                            logger.error("Invalid selection");
                            break;
                    }
                    break;
                case 2:
                    AdminOps<Location> locationAdminOps = new AdminOps<>();
                    Location location = new Location();
                    System.out.println("Select from the following options");
                    System.out.println("1.View Location 2.Add Location");
                    String locationChoiceInput = scanner.nextLine();
                    int locationChoice = 0;
                    try {
                        locationChoice = Integer.parseInt(locationChoiceInput);
                    } catch (InputMismatchException e) {
                        logger.error("Invalid Input {}", e.getMessage());
                    }
                    switch (locationChoice) {
                        case 1:
                            break;
                        case 2:
                            try {
                                System.out.println("Enter Address");
                                location.setAddress(scanner.nextLine());
                                contact = new Contact();
                                System.out.println("Enter First name");
                                contact.setFirstName(scanner.nextLine());
                                System.out.println("Enter Last name");
                                contact.setLastName(scanner.nextLine());
                                System.out.println("Enter phone number");
                                contact.setPhone(scanner.nextLine());
                                location.setContact(contact);
                                locationAdminOps.create(location);
                            } catch (IOException e) {
                                logger.error(e);
                                e.printStackTrace();
                            }
                            break;
                        default:
                            System.out.println("Invalid selection");
                            logger.error("Invalid input");
                            break;
                    }
                    break;
                case 3:
                    AdminOps<MenuItem> itemAdminOps = new AdminOps<>();
                    MenuItem item = new MenuItem();
                    System.out.println("Select from the following options");
                    System.out.println("1.View Menu 2.Create Menu Item");
                    String menuChoiceInput = scanner.nextLine();
                    int menuChoice = 0;
                    try {
                        menuChoice = Integer.parseInt(menuChoiceInput);
                    } catch (InputMismatchException e) {
                        logger.error("Invalid Input {}", e.getMessage());
                    }
                    switch (menuChoice) {
                        case 1:
                            break;
                        case 2:
                            try {
                                System.out.println("Enter the category");
                                item.setCategoryName(scanner.nextLine());
                                System.out.println("Enter the item name");
                                item.setItemName(scanner.nextLine());
                                System.out.println("Enter the item price");
                                item.setItemPrice(scanner.nextLine());
                                itemAdminOps.create(item);
                            } catch (IOException e) {
                                logger.error(e);
                                e.printStackTrace();
                            }
                            break;
                        default:
                            System.out.println("Invalid selection");
                            logger.error("Invalid input");
                            break;

                    }
                    break;
                case 4:
                    AdminOps<Reservation> reservationAdminOps = new AdminOps<>();
                    Reservation reservation = new Reservation();
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
                            break;
                        case 2:
                            try {
                                System.out.println("Enter event date");
                                reservation.setEventDate(scanner.nextLine());
                                System.out.println("Enter start time");
                                reservation.setStartTime(scanner.nextLine());
                                System.out.println("Enter end time");
                                reservation.setEndTime(scanner.nextLine());
                                System.out.println("Enter size");
                                reservation.setSize(scanner.nextLine());
                                reservationAdminOps.create(reservation);
                            } catch (IOException e) {
                                logger.error(e);
                                e.printStackTrace();
                            }
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
            if (selection == 5) {
                break;
            }
        }
    }
}
