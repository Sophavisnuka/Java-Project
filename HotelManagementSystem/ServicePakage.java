import java.util.ArrayList;

public class ServicePakage {
    private static ArrayList<Service> serviceList = new ArrayList<Service>(); // Stores all available services

    // Add a service to the list
    public static void addService(Service service) {
        serviceList.add(service);
    }

    // Display all available services
    public static void displayServices() {
        System.out.println("\n===== Available Services =====");
        for (Service service : serviceList) {
            System.out.println(service.getServiceName() + " - $" + service.getServicePrice() + 
                               " (Available: " + (service.isAvailable() ? "Yes" : "No") + ")");
        }
    }

    // Get all available services
    public static ArrayList<Service> getAvailableServices() {
        ArrayList<Service> availableServices = new ArrayList<Service>();
        for (Service service : serviceList) {
            if (service.isAvailable()) {
                availableServices.add(service);
            }
        }
        return availableServices;
    }
}
