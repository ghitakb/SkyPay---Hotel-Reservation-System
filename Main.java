package src;

public class Main {

	public static void main(String[] args) throws Exception {
		try {
			Service service = new Service();

			service.setRoom(1, RoomType.STANDARD, 1000);
			service.setRoom(2, RoomType.JUNIOR, 2000);
			service.setRoom(3, RoomType.MASTER, 3000);

			System.out.println("Rooms have been set.");

			service.setUser(1, 5000);
			service.setUser(2, 10000);

			service.printAllUsers();
			System.out.println("booking 1:");
			try { service.bookRoom(1, 2, DateHelper.parseDate("30/06/2026"), DateHelper.parseDate("07/07/2026"));
			} catch (Exception e) { System.out.println(e.getMessage()); }

			System.out.println("booking 2:");
			try { service.bookRoom(1, 2, DateHelper.parseDate("07/07/2026"), DateHelper.parseDate("30/06/2026"));
			} catch (Exception e) { System.out.println(e.getMessage());
			}
			System.out.println("booking 3:");
			try { service.bookRoom(1, 1, DateHelper.parseDate("07/07/2026"), DateHelper.parseDate("08/07/2026"));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println("booking 4:");
			try { service.bookRoom(2, 1, DateHelper.parseDate("07/07/2026"), DateHelper.parseDate("09/07/2026"));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println("booking 5:");
			try { service.bookRoom(2, 3, DateHelper.parseDate("07/07/2026"), DateHelper.parseDate("08/07/2026"));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			service.printAll();

			service.setRoom(1, RoomType.MASTER, 10000);
			System.out.println(("Room number 1 updated."));
			service.printAll();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}