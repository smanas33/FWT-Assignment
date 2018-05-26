package com.yash.moviebookingsystem.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MakeSeating {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		List<Screen> screens = new ArrayList<Screen>();
		Screen screen = new Screen();
		screen.setScreenName("Screen 1");
		screens.add(screen);
		screen = new Screen();
		screen.setScreenName("Screen 2");
		screens.add(screen);
		screen = new Screen();
		screen.setScreenName("Screen 3");
		screens.add(screen);

		createSeatingforScreen(screen);

		checkAvalibleSeats(screen);

	}

	private static void checkAvalibleSeats(Screen screen) {
		Map<String, List<Row>> screenSeating = null;/*screen.getSeatings();*/
		for (Map.Entry<String, List<Row>> seating : screenSeating.entrySet()) {
			System.out.println(seating.getKey() + " Class");
			List<Row> rows = seating.getValue();
			int space = 1;
			for (Row row : rows) {
				space++;
				List<Seat> seats = row.getSeats();
				System.out.print(row.getRowNo() + "\t");
				for (int i = 0; i < space; i++) {
					System.out.print(" ");
				}
				for (Seat seat : seats) {
					if (!seat.isAvailable())
						System.out.print(seat.getSeatNo() + " ");
					else
						System.out.print("X ");
				}
				System.out.println();
			}
			space = 0;
		}
	}

	private static void createSeatingforScreen(Screen screen) {
		int rowCount = 0;
		int initialSeatCount = 0;
		System.out.println("Enter Total Number of row in Gold Class");
		rowCount = scanner.nextInt();
		do {
			System.out.println("Minimum number of seat in 1st row to make Seating is " + rowCount * 2);
			System.out.println("Enter Number of seat in 1st Row");
			initialSeatCount = scanner.nextInt();
		} while (initialSeatCount < (rowCount * 2));
		System.out.println("Creating Rows..");
		List<Row> seating = new ArrayList<Row>();

		for (int i = 1; i <= rowCount; i++) {
			Row row = new Row();
			row.setRowNo("G" + i);
			System.out.println(row.getRowNo() + "\t");

			for (int space = 0; space < i; space++) {
				System.out.print("  ");
			}
			List<Seat> seats = new ArrayList<Seat>();
			for (int j = 1; j <= initialSeatCount; j++) {
				Seat seat = new Seat();
				seat.setSeatNo(j);
				seat.setAvailable(true);
				seats.add(seat);
			}
			initialSeatCount -= 2;
			row.setSeats(seats);
			for (Seat seat : seats) {
				System.out.print(seat.getSeatNo() + "  ");
			}
			System.out.println();
			seating.add(row);
		}

		System.out.println("Enter Total Number of row in Silver Class");
		rowCount = scanner.nextInt();
		do {
			System.out.println("Minimum number of seat in 1st row to make Seating is " + rowCount * 2);
			System.out.println("Enter Number of seat in 1st Row");
			initialSeatCount = scanner.nextInt();
		} while (initialSeatCount < (rowCount * 2));
		System.out.println("Creating Rows..");
		List<Row> seatingForSliver = new ArrayList<Row>();

		for (int i = 1; i <= rowCount; i++) {
			Row row = new Row();
			row.setRowNo("S" + i);
			System.out.println(row.getRowNo() + "\t");
			List<Seat> seats = new ArrayList<Seat>();
			for (int space = 0; space < i; space++) {
				System.out.print("  ");
			}
			for (int j = 1; j <= initialSeatCount; j++) {
				Seat seat = new Seat();
				seat.setSeatNo(j);
				seat.setAvailable(false);
				seats.add(seat);

			}
			initialSeatCount -= 2;
			row.setSeats(seats);
			for (Seat seat : seats) {
				System.out.print(seat.getSeatNo() + "  ");
			}
			System.out.println();
			seatingForSliver.add(row);
		}

		System.out.println("Enter Total Number of row in Premium Class");
		rowCount = scanner.nextInt();
		do {
			System.out.println("Minimum number of seat in 1st row to make Seating is " + rowCount * 2);
			System.out.println("Enter Number of seat in 1st Row");
			initialSeatCount = scanner.nextInt();
		} while (initialSeatCount < (rowCount * 2));
		System.out.println("Creating Rows..");
		List<Row> seatingForPremium = new ArrayList<Row>();

		for (int i = 1; i <= rowCount; i++) {
			Row row = new Row();
			row.setRowNo("P" + i);
			System.out.println(row.getRowNo() + "\t");
			List<Seat> seats = new ArrayList<Seat>();
			for (int space = 0; space < i; space++) {
				System.out.print("  ");
			}
			for (int j = 1; j <= initialSeatCount; j++) {
				Seat seat = new Seat();
				seat.setSeatNo(j);
				seat.setAvailable(false);
				seats.add(seat);

			}
			initialSeatCount -= 2;
			row.setSeats(seats);
			for (Seat seat : seats) {
				System.out.print(seat.getSeatNo() + "  ");
			}
			System.out.println();
			seatingForPremium.add(row);
		}
		Map<String, List<Row>> screenSeating = new LinkedHashMap<String, List<Row>>();
		screenSeating.put("premium", seatingForPremium);
		screenSeating.put("sliver", seatingForSliver);
		screenSeating.put("gold", seating);

//		screen.setSeatings(screenSeating);
	}

}
