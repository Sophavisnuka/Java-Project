import java.util.ArrayList;

import Code_test_area.Reservation;

public class Invoice {
    private static int totalInvoice = 0;  // Keeps track of the total number of invoices
    private int paymentID;  
    private String paymentMethod;
    private double baseAmount;
    private double additionalCharge;  // Additional charge based on services
    private double discount;
    private double tax;
    private double totalAmount;
    private ArrayList<Service> services; // List to store services added
    private Reservation reservation;
    private boolean isFinalized;


    public Invoice(String paymentMethod, Reservation reservation, double discount, double tax) {
        this.paymentID = ++totalInvoice;
        this.paymentMethod = paymentMethod;
        this.reservation = reservation;
        this.baseAmount = reservation.getTotalAmount();
        this.discount = discount;
        this.tax = tax;
        this.services = new ArrayList<Service>(); 
        this.additionalCharge = 0.0;
        this.totalAmount = calculateFinalAmount();
        this.isFinalized = false;
    }

    public void finalizeInvoice() {
        isFinalized = true;
    }

    // Calculate total amount, including services and additional charge based on services
    private double calculateFinalAmount() {
        additionalCharge = 0.0;
        for (Service service : services) {
            additionalCharge += service.getServicePrice() * service.getServiceAmount();
        }
        double taxableAmount = baseAmount + additionalCharge - discount;
        return taxableAmount + (taxableAmount * tax / 100);
    }

    // Add service to the invoice
    public void addService(Service service) {
        if (isFinalized) {
            System.out.println("Cannot add services. Invoice is finalized.");
        }
        this.services.add(service); // Add the service to the list
        this.totalAmount = calculateFinalAmount(); // Recalculate the total amount
    }

    
    // Generate receipt
    public void generateReceipt() {
        System.out.println("======== Invoice Receipt ========");
        System.out.println("Invoice ID: " + paymentID);
        System.out.println("Cutomer Nname:" + reservation.getCustomerName());
        System.out.println("Payment Method: " + paymentMethod);
        System.out.println("Discount: -$" + discount);
        System.out.println("Tax: " + tax + "%");

        //Display the Room Description
        System.out.println("\nRoom Description:");
        System.out.println(getRoomDetails());

        // Display the services
        System.out.println("Services:");
        System.out.println(getServiceDetails());
        
        // Display total amount
        System.out.println("Base Amount: $" + baseAmount);
        System.out.println("Additional Charge: $" + additionalCharge);
        System.out.println("Total Amount: $" + calculateFinalAmount());
        System.out.println("=================================");
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public int getPaymentID() {
        return paymentID;
    }

    private String getServiceDetails() {
        String serviceDetails = "";
        for (Service service : services) {
            serviceDetails += service.getServiceName() + " - " +
                    service.getServiceAmount() + " x $" +
                    service.getServicePrice() + "\n";
        }
        return serviceDetails;
    }
    
    public String getRoomDetails(){
        String roomDetails = "";

        ArrayList<Integer> roomNumbers = reservation.getRoomNumbers();
        ArrayList<String> roomTypes = reservation.getRoomTypes();
        ArrayList<Double> priceRooms = reservation.getPriceRoom();
        for (int i = 0; i < roomNumbers.size(); i++) {
            roomDetails += "\nRoom Number :" +roomNumbers.get(i)
                        + "\nRoom type :" +roomTypes.get(i) 
                        + "\nPrice Per Night :"+ "$"+ priceRooms.get(i);
                    }
        roomDetails +="\nNight Stay : " + reservation.getNightsStayed() + "\n";
        return roomDetails.toString();
    
    }

    public void refund(double amount) {
        if (isFinalized) {
            System.out.println("Cannot modify finalized invoice.");
            return;
        }
        if (amount > totalAmount) {
            System.out.println("Refund amount exceeds invoice total.");
            return;
        }
        totalAmount -= amount;
    }
    


    
}
