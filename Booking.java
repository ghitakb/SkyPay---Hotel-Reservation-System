package src;

import java.util.Date;


public class Booking {
    User    user;
    Room    room;
    Date    checkIn;
    Date    checkOut;


    public void validateDate () {
            if (checkIn.after(checkOut) || checkIn.equals(checkOut))
                throw new IllegalArgumentException("Error: Check-in Date must be before check-out Date.");
    }

    public Booking(User user, Room room, Date checkIn, Date checkOut){
        this.user = user;
        this.room = room;
        if (checkIn == null || checkOut == null)
            throw new IllegalArgumentException("Error: Invalid Date format, expected \"dd/M/-yyyy\".");
        this.checkIn = checkIn;
        this.checkOut = checkOut;

        validateDate();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Booking {" + "User = " + user + ", Room = " + room + ", checkIn = " + DateHelper.formatDate(checkIn) + ", checkOut = " + DateHelper.formatDate(checkOut) + '}';
    }

}
