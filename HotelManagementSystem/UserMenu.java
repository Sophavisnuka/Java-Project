package HotelManagementSystem;

import java.util.Scanner;

public class UserMenu {
    public void accountMenu () {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n------------------------------\n");
            System.out.println("1. Register");
            System.out.println("2. Log in");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            
            int choice = scanner.nextInt();
            int attempt = 1;
            int maxAttempt = 3;
            scanner.nextLine();  // Consume newline
            switch (choice) {
                case 1:
                    while (attempt < maxAttempt) {
                        System.out.println("------------------------------");
                        System.out.println("\n--- Register ---");
                        System.out.print("Enter username: ");
                        String username = scanner.nextLine();
                        String phone;
                        while (true) {
                            System.out.print("Enter phone number: ");
                            phone = scanner.nextLine();
                            try {
                                PhoneNumberException.isValidPhoneNumber(phone);
                                System.out.println("Phone number is valid.");
                                break;
                                // Proceed with other registration steps here
                            } catch (PhoneNumberException e) {
                                System.out.println(e.getMessage());  // Show error message if the phone number is invalid
                                attempt++;
                                if (attempt >= maxAttempt) {
                                    System.out.println("Too many failed attempts. Returning to main menu.");
                                    return;
                                }
                            }
                        }
                        System.out.print("Enter email: ");
                        String email = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String password = scanner.nextLine();
                        
                        Customer user = new Customer(username, phone, email, password);
                        boolean registrationSuccess = user.register(username, phone, email, password);
                        if (registrationSuccess) {
                            System.out.println("Registration successful!\n");
                            break;
                        } else {
                            System.out.println("Registration failed. Username might already exist.\n");
                            // attempt++;
                        }
                        // if (attempt >= maxAttempt) {
                        //     System.out.println("Maximum attempts reached. Returning to main menu.");
                        //     return;
                        // }
                        System.out.println("Attempt: " + attempt);
                        System.out.println("------------------------------");
                    }
                    break;
                case 2:
                    while (attempt < maxAttempt) {
                        System.out.println("------------------------------");
                        System.out.println("\n--- Login ---");
                        System.out.print("Enter email: ");
                        String loginEmail = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String loginPassword = scanner.nextLine();
                        User account = User.findUserByUsername(loginEmail); 
                        if (account == null) {
                            System.out.println("Account not found. Please register.");
                            break;
                        } else if (account.login(loginEmail, loginPassword)) {
                            System.out.println("Login successful!");
                        } else {
                            System.out.println("Login failed. Incorrect email or password.");
                        }
                        attempt++;
                        System.out.println("Attempt: " + attempt);
                        System.out.println("------------------------------");
                    }
                    break;
                case 0:
                    System.out.println("Exiting system");
                    return;
                default:
                    System.out.println("Invalid choice!");
                    scanner.close();
                    break;
            }
        }
    }
}
