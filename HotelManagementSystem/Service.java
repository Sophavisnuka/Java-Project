public class Service {
    private String serviceName;
    private double servicePrice;
    private boolean isAvailable;
    public int serviceAmount; // Quantity of the service

    // Constructor
    public Service(String serviceName, double servicePrice, int serviceAmount) {
        this.serviceName = serviceName;
        this.servicePrice = servicePrice;
        this.serviceAmount = serviceAmount;
        this.isAvailable = serviceAmount > 0;
    }

    // Getters
    public String getServiceName() {
        return serviceName;
    }

    public double getServicePrice() {
        return servicePrice;
    }

    public int getServiceAmount() {
        return serviceAmount;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Setter for serviceAmount (if needed to modify quantity)
    public void setServiceAmount(int serviceAmount) {
        if (serviceAmount >= 0) {  // Prevent negative values
            this.serviceAmount = serviceAmount;
            this.isAvailable = serviceAmount > 0;
        } else {
            System.out.println("Error: Service amount cannot be negative.");
        }
    }    

}
