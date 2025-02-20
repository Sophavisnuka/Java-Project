package HotelManagementSystem.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class UserReservation {
    // Private instance variables
    private String userName;
    private String userPhoneNum;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String roomID;
    private int durationOfStay;
    private boolean Paid;
    // Static variables
    private static int totalReservations = 0;
    private static int roomCounter = 1; // Start room IDs from 1
    private static ArrayList<UserReservation> reservations = new ArrayList<>();
    // Constructor
    public UserReservation() {
        this.userName = "";
        this.userPhoneNum = "";
        this.checkInDate = LocalDate.now();
        this.checkOutDate = LocalDate.now();
        this.roomID = generateRoomID();
        this.durationOfStay = 0;
        this.Paid = false;
    }
    public UserReservation(String userName, String userPhoneNum, LocalDate checkInDate, LocalDate checkOutDate, boolean Paid) {
        this.userName = userName;
        this.userPhoneNum = userPhoneNum;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.roomID = generateRoomID(); // Automatically generate a room ID
        this.Paid = Paid;
        this.durationOfStay = calculateDuration(checkInDate, checkOutDate);
        totalReservations++;
    }
    // Static method to calculate the duration of stay
    public static int calculateDuration(LocalDate checkIn, LocalDate checkOut) {
        long totalDays = checkOut.toEpochDay() - checkIn.toEpochDay(); //toEpochDay() returns the total number of days since the epoch (1970-01-01).
        return (int) totalDays; // Return as an integer
    }    
    // Method to generate a unique room ID
    private static String generateRoomID() {
        return "R" + roomCounter++; // Generate IDs like R100, R101, etc.
    }
    // Check-in method
    public void checkIn() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        this.userName = input.nextLine();
        System.out.print("Enter your phone number: ");
        this.userPhoneNum = input.nextLine();
         // Define the expected date format (dd-MM-yyyy)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.print("Enter your check-in date (dd-MM-yyyy): ");
        this.checkInDate = LocalDate.parse(input.nextLine(), formatter);
        System.out.print("Enter your check-out date (dd-MM-yyyy): ");
        this.checkOutDate = LocalDate.parse(input.nextLine(), formatter);
        //give the duration of stay
        if (this.checkOutDate.isAfter(this.checkInDate)) {
            this.durationOfStay = calculateDuration(this.checkInDate, this.checkOutDate);
            System.out.println("Your stay duration: " + this.durationOfStay + " days");
        } else {
            System.out.println("Check-out date must be after check-in date!");
            input.close();
        }
        this.roomID = generateRoomID(); // Automatically assign room ID
        System.out.println("Your assigned room ID: " + this.roomID);
        System.out.print("Is the reservation paid? (True/False): ");
        this.Paid = Boolean.parseBoolean(input.nextLine());
        // Add the reservation to the static list
        reservations.add(this);
        System.out.println("Reservation successfully added!");
    }
    // Override toString method for displaying reservation information
    @Override
    public String toString() {
        return "Reservation Details:\n" +
            "Name: " + userName + "\n" +
            "Phone Number: " + userPhoneNum + "\n" +
            "Check-In Date: " + checkInDate + "\n" +
            "Check-Out Date: " + checkOutDate + "\n" +
            "Room ID: " + roomID + "\n" +
            "Duration of Stay: " + durationOfStay + " days\n" +
            "Is Paid: " + Paid;
    }
    // Static method to display all reservations
    public static void displayAllReservations() {
        System.out.println("Total Reservations: " + totalReservations);
        for (UserReservation reservation : reservations) {
            System.out.println("\n--------------------------------");
            System.out.println(reservation.toString());
            System.out.println("--------------------------------");
        }
    }
}



