package src;

import java.util.Scanner;

public class InteractiveMain {

    private static void handleSetRoom(Scanner scanner, Service service) {

        System.out.print("Room number: ");
        int roomNumber = readInt(scanner);

        System.out.print("Room type (STANDARD, JUNIOR, MASTER): ");
        RoomType type;
        try {
            type = RoomType.valueOf(scanner.nextLine().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid room type.");
        }

        System.out.print("Price per night: ");
        int price = readInt(scanner);

        service.setRoom(roomNumber, type, price);
        System.out.println("Room saved successfully.");
    }

    private static void handleSetUser(Scanner scanner, Service service) {

        System.out.print("User ID: ");
        int userId = readInt(scanner);

        System.out.print("Balance: ");
        int balance = readInt(scanner);

        service.setUser(userId, balance);
        System.out.println("User saved successfully.");
    }

    private static void handleBooking(Scanner scanner, Service service) {

        System.out.print("User ID: ");
        int userId = readInt(scanner);

        System.out.print("Room number: ");
        int roomNumber = readInt(scanner);

        System.out.print("Check-in (dd/MM/yyyy): ");
        String checkIn = scanner.nextLine();

        System.out.print("Check-out (dd/MM/yyyy): ");
        String checkOut = scanner.nextLine();

        service.bookRoom(userId, roomNumber, DateHelper.parseDate(checkIn), DateHelper.parseDate(checkOut));

        System.out.println("Booking created successfully.");
    }

    private static int readInt(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Please enter a valid number.");
        }
    }

    public static void main(String[] args) {

        Service service = new Service();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    
                    ===== HOTEL RESERVATION SYSTEM =====
                    1. Create / Update Room
                    2. Create / Update User
                    3. Book Room
                    4. Print All
                    5. Print All Users
                    0. Exit
                    """);

            System.out.print("Choose option: ");
            String choiceInput = scanner.nextLine();

            int choice;
            try {
                choice = Integer.parseInt(choiceInput);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            try {
                switch (choice) {

                    case 1 -> handleSetRoom(scanner, service);
                    case 2 -> handleSetUser(scanner, service);
                    case 3 -> handleBooking(scanner, service);
                    case 4 -> service.printAll();
                    case 5 -> service.printAllUsers();

                    case 0 -> {
                        System.out.println("Goodbye!");
                        return;
                    }

                    default -> System.out.println("Invalid option.");
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
