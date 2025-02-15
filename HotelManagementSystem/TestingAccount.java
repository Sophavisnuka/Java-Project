package HotelManagementSystem;

import java.util.Scanner;

public class TestingAccount {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Register");
            System.out.println("2. Log in");
            System.out.println("3. Show user");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.println("\n--- Register ---");
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();

                    User user = new User(username, phone, email, password);
                    boolean registrationSuccess = user.register(username, phone, email, password);
                    if (registrationSuccess) {
                        System.out.println("Registration successful!\n");
                    } else {
                        System.out.println("Registration failed. Username might already exist.\n");
                    }
                    break;
                case 2:
                    System.out.println("\n--- Login ---");
                    System.out.print("Enter email: ");
                    String loginEmail = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String loginPassword = scanner.nextLine();

                    boolean loginSuccess = false;
                    for (Account acc : Account.userList) {
                        if (acc.login(loginEmail, loginPassword)) {
                            loginSuccess = true;    
                            break;
                        }
                    }
                    if (loginSuccess) {
                        System.out.println("Login successful!");
                    } else {
                        System.out.println("Login failed. Incorrect email or password.");
                    }
                    break;
                case 3:
                    User.displayAllUsers();
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
