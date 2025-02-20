import java.util.Objects;
public class Room {

    static int totalRooms = 20;
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
    
    public void setAvailable(boolean Available) {
        if (this.Available && !Available) {
            totalRooms--; // Room was available, now occupied
        } else if (!this.Available && Available) {
            totalRooms++; // Room was occupied, now available
        }
        this.Available = Available;
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

    public static int getTotalRooms() {
        return totalRooms;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Room room = (Room) obj;
        return roomNo == room.roomNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNo);
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNo=" + roomNo +
                ", capacity=" + capacity +
                ", roomType='" + roomType + '\'' +
                ", PricePerNight=" + PricePerNight +
                ", Available=" + Available +
                '}';
    }
}
