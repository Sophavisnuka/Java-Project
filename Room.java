 public class Room {

    static int totalRooms = 100;
    private int roomNo;
    private int capacity;
    private String roomType;
    private double PricePerNight;
    private boolean Available;

    public Room (int roomNo, String roomType, double PricePerNight, int capacity, boolean Available) {
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.PricePerNight = PricePerNight;
        this.capacity = capacity;
        this.Available = Available;
        
        if (Available == false) {
            totalRooms--;
        } else {
        }
    }

    public int getRoomNo() {
        return roomNo;
    }
    
    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }
    
    public String getRoomType() {
        return roomType;
    }
    
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    
    public boolean isAvailable() {
        return Available;
    }
    
    public void setAvailable(boolean available) {
        Available = available;
    }

    public double getPricePerNight() {
        return PricePerNight;
    }

    public void setPricePerNight(double PricePerNight) {
        this.PricePerNight = PricePerNight;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
