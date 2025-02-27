package HotelManagementSystem;

public class PhoneNumberException extends IllegalArgumentException {
    public PhoneNumberException(String message) {
        super(message);
    }
    public static void isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() < 9 || phoneNumber.length() > 18) {
            throw new PhoneNumberException("Phone number must be between 9 to 18 digits long.");
        }
        for (int i = 1; i < phoneNumber.length(); i++) {
            if (!Character.isDigit(phoneNumber.charAt(i))) {
                throw new PhoneNumberException("Phone number can only contain digits after the first character.");
            }
        }
    }
}
