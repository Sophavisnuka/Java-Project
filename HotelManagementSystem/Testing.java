package HotelManagementSystem;
// import java.time.LocalDate;
import java.util.Scanner;

public class Testing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nHotel Management System");
            System.out.println("1. Make Reservation");
            System.out.println("2. Show Reservation");
            System.out.println("3. Display User");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            
            switch (choice) {
                case 1:
                    
                    UserReservation reservation = new UserReservation();
                    // UserReservation reservation = new UserReservation("Nuka", "12345", chec, "15-02-2025");
                    reservation.checkIn();
                    break;
                case 2:
                    UserReservation.displayAllReservations();
                    break;
                case 3:
                    break;
                case 0:
                    System.out.println("Exiting system");
                    scanner.close();
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
