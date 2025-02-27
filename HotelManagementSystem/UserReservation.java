package HotelManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserReservation {
    // Private instance variables
    private int reservationID;
    private int roomID;
    private String userName;
    private String userPhoneNum;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int durationOfStay;
    // private boolean Paid;
    //static variables
    // private Account user;
    // private static int totalReservations = 0;
    private static int roomId = 1;
    private static int id = 0;
    private static ArrayList <UserReservation> reservationList = new ArrayList<>();

    public UserReservation() {
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
        // totalReservations++;
    }
    // Static method to get total reservations
    private static int generateReservationID () {
        return  id++;
    }
    private static int generateRoomID () {
        return  roomId++;
    }
    public static int calculateDurationStay (LocalDate checkInDate, LocalDate checkOutDate) {
        long totalStay = checkOutDate.toEpochDay() - checkInDate.toEpochDay(); //1970 jan 1 to present 
        return (int) totalStay;
    }
    // Public methods
    public User verifyUser() throws UserNotFoundException {
        int attempts = 0;
        int maxAttempts = 3;
        Scanner input = new Scanner(System.in);
        System.out.println("------------------------------\n");
        System.out.println("User Verification");
        System.out.println("Input name and phone number:");
    
        while (attempts < maxAttempts) {
            System.out.print("Enter your name: ");
            userName = input.nextLine();
            System.out.print("Enter your phone number: ");
            userPhoneNum = input.nextLine();
    
            try {
                PhoneNumberException.isValidPhoneNumber(userPhoneNum);
                System.out.println("Phone number is valid.");
            } catch (PhoneNumberException e) {
                System.out.println(e.getMessage());  // Show error message if the phone number is invalid
                // continue;  // Restart the loop to let the user enter again
            }
    
            if (userName.isBlank() || userPhoneNum.isBlank()) {
                System.out.println("Please input all the required fields.");
                // continue;  // Restart the loop instead of proceeding
            } 
    
            User user = User.findUserByUsername(userName);
            if (user == null) {
                System.out.println("User not found. Please try again.");
            } else if (!user.UserName.equals(userName) || !user.phoneNumber.equals(userPhoneNum)) {
                System.out.println("User not found or phone number does not match. Please register first.");
            } else {
                System.out.println("Verification Successful!");
                return user; // Return the user and exit the method
            }
    
            attempts++;  // Move this up so it always executes before checking max attempts
            System.out.println("------------------------------\n");
        }
        throw new UserNotFoundException("Maximum attempts reached. Please try again later.");
    }
    
    public void makeReservation() {
        Scanner input = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    
        System.out.println("\n--- Enter Reservation Details ---");

        try {
            System.out.print("Check-in date (dd-MM-yyyy): ");
            checkInDate = validateDateFormat(input.nextLine(), formatter);
        
            System.out.print("Check-out date (dd-MM-yyyy): ");
            checkOutDate = validateDateFormat(input.nextLine(), formatter);
        
            if (checkOutDate.isAfter(checkInDate)) {    
                durationOfStay = calculateDurationStay(checkInDate, checkOutDate);
                System.out.println("Duration of stay: " + durationOfStay + " days");
            } else {
                System.out.println("Error: Check-out date must be after check-in date.");
                return;
                // input.close();
            }
        } catch (InvalidDateFormatException e) {
            System.out.println(e.getMessage());
            return; // Exit the method if the date is invalid
        }
    
        reservationID = generateReservationID();
        reservationList.add(this);
        System.out.println("Reservation successful! Assigned Room ID: " + reservationID);
        System.out.println("Returning to main menu...\n");
    }
    
    public void cancelReservation () {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter reservation ID to cancel: ");
        int cancelID = input.nextInt();
        for (UserReservation reservation : reservationList) {
            if (reservation.reservationID == cancelID) {
                reservationList.remove(reservation);
                System.out.println("Reservation " + cancelID + " has been cancelled.");
                input.close();
            }
        }
        System.out.println("Reservation ID not found.");
    }
    public LocalDate validateDateFormat(String dateStr, DateTimeFormatter formatter) throws InvalidDateFormatException {
        try {
            return LocalDate.parse(dateStr, formatter);
        } catch (java.time.format.DateTimeParseException e) {
            throw new InvalidDateFormatException("Invalid date format. Please use dd-MM-yyyy.");
        }
    }
    @Override 
    public String toString () {
        return "Reservation detail:\n" + 
        "User: "+ userName + "\n" +
        "Phone Number: " + userPhoneNum +  "\n" +
        "Check-In Date: " + checkInDate + "\n" +
        "Check-Out Date: " + checkOutDate + "\n" +
        "Duration of Stay: " + durationOfStay + " days\n" +
        "Room Id: " + roomID +  "\n" +
        "Reservation Id: " + reservationID;
    }
    public void displayUserReservations () {
        // boolean found = false; 
        for (UserReservation reservation : reservationList) {
            // if (reservation.userName.equals(loginUserName) && reservation.userPhoneNum.equals(loginPhoneNum)) {
                System.out.println("\n--------------------------------");
                System.out.println(reservation.toString());
                System.out.println("--------------------------------");
                // found = true;
            // } else if (!found) {
            //     System.out.println("No reservations found for " + loginUserName);
            //     return;
            // }
        }
    }
}
