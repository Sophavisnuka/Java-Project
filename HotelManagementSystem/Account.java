package HotelManagementSystem;

import java.util.ArrayList;
//interface
public class Account implements Authentication {
    
    protected String UserName;
    protected String phoneNumber;
    protected String email;
    protected String password;

    protected static ArrayList <Account> userList = new ArrayList<>();

    Account (String UserName, String phoneNumber, String email, String password) {
        this.UserName = UserName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }
    Account (String email, String password) {
        this.email = email;
        this.password = password;
    }
    public boolean CheckInput (String UserName, String phoneNumber, String email, String password) {
        if (UserName.isBlank() || password.isBlank() || email.isBlank() || phoneNumber.isBlank()) {
            return true;
        } 
        return false;
    }
    @Override 
    public boolean register (String UserName, String phoneNumber, String email, String password) {
        // Check if username already 
        if (CheckInput(UserName, phoneNumber, email, password)) {
            System.out.println("Please input all the requirement");
            return false;
        }
        for (Account user : userList) {
            if (user.UserName.equals(UserName)) {
                return false;
            }
        }
        Account newUser = new Account(UserName, phoneNumber, email, password);
        userList.add(newUser);
        return true;
    }
    @Override 
    public boolean login (String email, String password) {
        if (CheckInput(UserName, phoneNumber, email, password)) {
            System.out.println("Please input all the requirement");
            return false;
        }
        // Check if username already exists
        for (Account user : userList) {
            if (user.password.equals(password) && user.email.equals(email)) {
                return true;
            } 
        }
        System.out.println("Login failed: Username does not exist.");
        return false;
    }
    public static Account findUserByUsername(String username) {
        for (Account user : userList) {
            if (user.UserName.equals(username)) {
                return user;
            }
        }
        return null; // User not found
    }

    // Method to display all registered users (optional for testing/debugging)
    public static void displayAllUsers() {
        System.out.println("Registered Users:");
        for (Account user : userList) {
            System.out.println("Username: " + user.UserName + ", Phone: " + user.phoneNumber);
        }
    }
}
