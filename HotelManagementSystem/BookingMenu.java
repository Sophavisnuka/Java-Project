package HotelManagementSystem;

import java.util.Scanner;

public class BookingMenu {
    public void bookingMenu() {
        UserReservation reservation = new UserReservation();
        User verifyUser = null;
        try {
            verifyUser = reservation.verifyUser();
        } catch(UserNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("------------------------------\n");
            System.out.println("Booking Menu");
            System.out.println("1. Make Reservation");
            System.out.println("2. Cancel Reservation");
            System.out.println("3. Show Reservation Detail");
            System.out.println("4. Exit");
    
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            switch (choice) {
                case 1:
                    System.out.println("------------------------------\n");
                    System.out.println("\n--- Make Reservation ---");
                    if (verifyUser != null) {
                        reservation.makeReservation();
                    } else {
                        System.out.println("It looks like you don't have an account. Please register");
                    }
                    System.out.println("------------------------------\n");
                    break;
                case 2:
                    reservation.cancelReservation();
                    break;
                case 3:
                    reservation.displayUserReservations();
                    break;
                case 4:
                    System.out.println("Exiting system");
                    return;
                default:
                    break;
            }
            // scanner.close();
        }
    }
}

