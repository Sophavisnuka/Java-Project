package HotelManagementSystem.test;

import java.util.Scanner;

public class User {
    String userName;
    String userPhoneNum;
    String userEmail;
    String userPassword;
    String address;
    String userID;

    User (String userName, String userPhoneNum, String email, String password) {
        this.userName = userName;
        this.userPhoneNum = userPhoneNum;
        userEmail = email;
        userPassword = password;
    }
    User (String email, String password) {
        userEmail = email;
        userPassword = password;
    }
    void signUp() {
        
    }
    static void login () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your email: ");
        String email = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        User user1 = new User("ming@gmai.com", "1234");
        if (user1.userPassword.equals(password) && user1.userEmail.equals(email)) {
            System.out.println("Login successful");
        } else {
            System.out.println("Fail attempt");
        }
        scanner.close();
    }
}
