package HotelManagementSystem;

import java.util.ArrayList;
//interface
public class User implements Authentication {
    
    protected String UserName;
    protected String phoneNumber;
    protected String email;
    protected String password;

    protected static ArrayList <User> userList = new ArrayList<>();

    User (String UserName, String phoneNumber, String email, String password) {
        this.UserName = UserName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }
    User (String email, String password) {
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
        for (User user : userList) {
            if (user.UserName.equals(UserName)) {
                return false;
            }
        }
        User newUser = new User(UserName, phoneNumber, email, password);
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
        for (User user : userList) {
            if (user.password.equals(password) && user.email.equals(email)) {
                return true;
            } 
        }
        System.out.println("Login failed: Username does not exist.");
        return false;
    }
    public static User findUserByUsername(String username) {
        for (User user : userList) {
            if (user.UserName.equals(username)) {
                return user;
            }
        }
        return null; // User not found
    }

    // Method to display all registered users (optional for testing/debugging)
    public static void displayAllUsers() {
        System.out.println("Registered Users:");
        for (User user : userList) {
            System.out.println("Username: " + user.UserName + ", Phone: " + user.phoneNumber);
        }
    }
}
