package HotelManagementSystem;

import java.util.Scanner;

public class MainProject {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("\nWelcome to Hotel Management System");
            System.out.println("1. Hotel Information");
            System.out.println("2. User Menu");
            System.out.println("3. Booking Menu");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            try {
                int choice = scan.nextInt();
                scan.nextLine();  // Consume newline
                switch (choice) {
                    case 1:
                        break;
                    case 2:
                        UserMenu userMenu = new UserMenu();
                        userMenu.accountMenu();
                        break;
                    case 3:
                        BookingMenu bookingMenu = new BookingMenu();
                        bookingMenu.bookingMenu();
                        break;
                    case 4:
                        System.out.println("Exiting system");
                        break;
                    default:
                        // scan.close();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                // scan.nextLine();
            }
        }
    }
}
