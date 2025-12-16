package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Service {
    private final ArrayList<Room> rooms;
    private final ArrayList<User> users;
    private final ArrayList<Booking> bookings;

    public Service() {
        this.rooms = new ArrayList<>();
        this.users = new ArrayList<>();
        this.bookings = new ArrayList<>();
    }

    public void setRoom(int roomNumber, RoomType roomType, int roomPricePerNight) {

        if (roomType == null) {
            throw new IllegalArgumentException("Error: Room Type cannot be null.");
        }

        if (!Arrays.asList(RoomType.values()).contains(roomType)) {
            throw new IllegalArgumentException("Error: Room Type " + roomType + " is not a valid enum constant.");
        }

        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                room.setRoomType(roomType);
                room.setRoomPricePerNight(roomPricePerNight);
                return ;
            }
        }
        Room newRoom = new Room(roomNumber, roomType, roomPricePerNight);
        rooms.add(newRoom);
    }

    private long calculateNumberOfNights(Date checkIn, Date checkOut) {
        if (checkIn.after(checkOut) || checkIn.equals(checkOut))
            throw new IllegalArgumentException("Error: Check-in Date must be before check-out Date.");

        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    private long calculateTotalCost (Room room, Date checkIn, Date checkOut) {
        long numOfDaysToStay = calculateNumberOfNights(checkIn, checkOut);
        return numOfDaysToStay * room.getRoomPricePerNight();
    }

    private void updateUserBalance(User user, long totalCost) {
        if (totalCost > user.getBalance()) // compare balance with stayTotal
            throw new IllegalArgumentException("Error: User does not have enough Balance.");
        user.setBalance(user.getBalance() - totalCost);
    }

    public void bookRoom(int userId, int roomNumber, Date checkIn, Date checkOut) {
        User    foundUser = null;
        Room    foundRoom = null;

        for (User u : users)
            if (u.getId() == userId)
                foundUser = u;

        if (foundUser == null)
            throw new IllegalArgumentException("Error: User not found to book a room.");

        for (Room r : rooms)
            if (r.getRoomNumber() == roomNumber)
                foundRoom = r;

        if (foundRoom == null)
            throw new IllegalArgumentException("Error: Room not found to book a room.");

        for (Booking b : bookings) {
            if (b.getRoom().getRoomNumber() == roomNumber) {
                boolean overlaps = checkIn.before(b.getCheckOut()) && checkOut.after(b.getCheckIn());
                if (overlaps)
                    throw new IllegalArgumentException("Error: Room not available for this period.");
            }
        }
        long totalCost = calculateTotalCost(foundRoom, checkIn, checkOut);
        Room bookedRoom = new Room(foundRoom.getRoomNumber(), foundRoom.getRoomType(), foundRoom.getRoomPricePerNight());
        Booking newbooking = new Booking(foundUser, bookedRoom, checkIn, checkOut);
        updateUserBalance(foundUser, totalCost);
        bookings.add(newbooking);
    }

    public void printAll() {
        System.out.println("Available Rooms : " );
        for (int i = rooms.size() - 1; i >= 0; i--) {
            System.out.println(rooms.get(i));
        }

        System.out.println("List of Bookings : " );
        for (int i = bookings.size() - 1; i >= 0; i--) {
            System.out.println(bookings.get(i));
        }

    }

    public void setUser(int userId, int balance) {
        for (User user : users) {
            if (user.getId() == userId) {
                user.setBalance(balance);
                return ;
            }
        }
        User newUser = new User(userId, balance);
        users.add(newUser);
    }

    public void printAllUsers() {
        System.out.println("List of Users : " );
        for (int i = users.size() - 1; i >= 0; i--) {
            System.out.println(users.get(i));
        }
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }


    @Override
    public String toString() {
        return  "rooms created : " + rooms + "\n Users created : " + users + "\nbookings list : \n" + bookings;
    }
}