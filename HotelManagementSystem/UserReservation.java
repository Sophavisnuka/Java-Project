package HotelManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserReservation {
    // Private instance variables
    private String reservationID;
    private String roomID;
    String userName;
    String userPhoneNum;
    LocalDate checkInDate;
    LocalDate checkOutDate;
    int durationOfStay;
    // private boolean Paid;
    //static variables
    // private Account user;
    private static int totalReservations = 0;
    private static int id = 0;
    private static int roomCounter = 1;
    private static ArrayList <UserReservation> reservationList = new ArrayList<>();

    // Constructor with parameters for user and system
    // public UserReservation (Account user) {
    //     this.user = user;
    // }
    public UserReservation() {
        this.userName = "";
        this.userPhoneNum = "";
        this.checkInDate = LocalDate.now();
        this.checkOutDate = LocalDate.now();
        this.reservationID = generateReservationID();
        this.roomID = generateRoomID();
    }
    public UserReservation(String userName, String userPhoneNum, LocalDate checkInDate, LocalDate checkOutDate) {  
        this.userName = userName;
        this.userPhoneNum = userPhoneNum;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate; 
        totalReservations++;
    }
    // Static method to get total reservations
    private static String generateReservationID () {
        return "RES" + id++;
    }
    private static String generateRoomID () {
        return "Room" + roomCounter++;
    }
    public static int calculateDurationStay (LocalDate checkInDate, LocalDate checkOutDate) {
        long totalStay = checkOutDate.toEpochDay() - checkInDate.toEpochDay(); //1970 jan 1 to present 
        return (int) totalStay;
    }
    // Public methods
    public void checkIn() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        userName = input.nextLine();
        System.out.print("Enter your phone number: ");
        userPhoneNum = input.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.print("Input check in date (dd-MM-yyyy): " );
        checkInDate = LocalDate.parse(input.nextLine(), formatter);
        System.out.print("Input check out date (dd-MM-yyyy): " );
        checkOutDate = LocalDate.parse(input.nextLine(), formatter);

        if (checkOutDate.isAfter(checkInDate)) {
            durationOfStay = calculateDurationStay(checkInDate, checkOutDate);
            System.out.print("Duration of stays: "+ durationOfStay+ " days\n");
        } else {
            System.out.println("Check out date should be after check in date.");
            input.close();
        }
        reservationID = generateReservationID();
        roomID = generateRoomID();
        System.out.println("Your assigned room ID: " +  roomID);
        reservationList.add(this);
        System.out.println("Reservation successfully added!");
    }
    
    @Override 
    public String toString () {
        return "Reservation detail:\n" + 
        "User: "+ userName + "Phone Number: " + "\n"+ userPhoneNum + 
        "Check-In Date: " + checkInDate + "\n" +
        "Check-Out Date: " + checkOutDate + "\n" +
        "Duration of Stay: " + durationOfStay + " days\n" +
        "Room Id: " + roomID +  "\n" +
        "Reservation Id: " + reservationID;
    }
    public static void displayAllReservations () {
        System.out.println("Total Reservations: " + totalReservations);
        for (UserReservation reservationList : reservationList) {
            System.out.println("\n--------------------------------");
            System.out.println(reservationList.toString());
            System.out.println("--------------------------------");
        }
    }
}
