public class Main {
    public static void main (String[] args) {
        Room room1 = new Room (001, "Double", 50.75, 4, false); // Creating a room with specific values
        Room room2 = new Room (002, "Single", 25.50, 2, true); // Creating a room with specific values
        

        System.out.println ("Room Number: " + room1.getRoomNo());
        System.out.println ("Room Type: " + room1.getRoomType());
        System.err.println ("Price per night: " + room1.getPricePerNight() + "$");
        System.err.println ("Capacity: " + room1.getCapacity());
        System.out.println ("Is Available: " + room1.isAvailable());
        System.err.println("\n------------------------------------");

        System.out.println ("Room Number: " + room2.getRoomNo());
        System.out.println ("Room Type: " + room2.getRoomType());
        System.err.println ("Price per night: " + room2.getPricePerNight() + "$");
        System.err.println ("Capacity: " + room2.getCapacity());
        System.out.println ("Is Available: " + room2.isAvailable());
        System.err.println("\n------------------------------------");
        
        System.out.println("Total room: " + Room.totalRooms);
    }
}
