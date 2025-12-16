# SkyPay---Hotel-Reservation-System
This project implements a simplified **Hotel Reservation System** in Java, as requested in the assignment.

The system manages:
- Rooms
- Users
- Bookings

## Features

- Create or update rooms (type and price per night)
- Create or update users (balance)
- Book a room for a specific period
- Print all rooms and bookings (latest to oldest)
- Print all users (latest to oldest)
- Interactive console-based interface

---

## Design Notes

- **Service** contains all business logic and validations.
- **Room** and **User** are mutable entities.
- **Booking** stores a snapshot of room data at booking time, so updates to rooms do not affect previous bookings.
- Exceptions are thrown in the Service layer and handled in the interactive layer.
- Dates consider only day, month, and year.

---

From the project root:

## How to Compile
```bash
javac src/*.java
```

## Run assignment test case:
```bash
java src.Main
```

## Run interactive mode:
```bash
java src.InteractiveMain
```
