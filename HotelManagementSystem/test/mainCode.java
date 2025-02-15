package HotelManagementSystem.test;
// import java.time.LocalDate;
import java.util.Scanner;   
public class mainCode {
    public static void main(String[] args) {
        Scanner scans = new Scanner(System.in);
        while (true) {
            System.out.println("1.Reservation");
            System.out.println("2.Display Reservation");
            System.out.println("3.Exit");
            System.out.print("Choose: ");
            int choice = scans.nextInt();
            scans.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    UserReservation reservation = new UserReservation();
                    reservation.checkIn();
                    // UserReservation.displayAllReservations();
                    break;
                case 2:
                    UserReservation.displayAllReservations();
                    break;
                case 3:
                    System.out.println("Exit");
                    scans.close();
                    break;
                default:
                    break;
            }
        }
    }
}
