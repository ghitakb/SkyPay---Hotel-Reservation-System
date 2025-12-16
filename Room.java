package src;


public class Room {
    private final int   roomNumber;
    private RoomType    roomType;
    private int         roomPricePerNight;

    public Room(int number, RoomType type, int roomPricePerNight) {
        if (number <= 0)
            throw new IllegalArgumentException("Error: Room number must be positive.");
        this.roomNumber = number;
        this.roomType = type;
        if (roomPricePerNight < 0)
            throw new IllegalArgumentException("Error: the price can not be negative.");
        this.roomPricePerNight = roomPricePerNight;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getRoomPricePerNight() {
        return roomPricePerNight;
    }

    public void setRoomPricePerNight(int roomPricePerNight) {
        this.roomPricePerNight = roomPricePerNight;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return  "Room Number = " + this.roomNumber + ", Room Type = " + this.roomType + ", room Price Per Night=" + this.roomPricePerNight + '.';
    }

}
