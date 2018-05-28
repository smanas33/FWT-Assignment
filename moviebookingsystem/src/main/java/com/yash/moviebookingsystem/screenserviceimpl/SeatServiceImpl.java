package com.yash.moviebookingsystem.screenserviceimpl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.yash.moviebookingsystem.exception.MovieNullPointerException;
import com.yash.moviebookingsystem.exception.ScreenNullPointerException;
import com.yash.moviebookingsystem.model.Row;
import com.yash.moviebookingsystem.model.Screen;
import com.yash.moviebookingsystem.model.Seat;
import com.yash.moviebookingsystem.screendao.SeatDAO;
import com.yash.moviebookingsystem.screenservice.SeatService;

/**
 * This is serviceimpl class for Seat class. Here all logic related to Seat
 * object are done. Like designing seat structure
 * 
 * @author sahoo.manas
 *
 */
public class SeatServiceImpl implements SeatService {

	private SeatDAO seatDAO;
	private final static Logger LOGGER = Logger.getLogger(MovieServiceImpl.class);
	private List<Row> seatListsForplatinum;
	private List<Row> seatListsForSilver;
	private List<Row> seatListsForGold;

	public SeatServiceImpl(SeatDAO seatDAO) {
		this.seatDAO = seatDAO;
	}

	public void makeSeatingArrangementForPlatinumClass(int rowCountForPlatinum, int initialSeatCountForPlatinum) {
		seatListsForplatinum = new ArrayList<Row>();
		LOGGER.info("creating seat arrangement inside seatserviceimpl for platinum class");
		for (int i = 1; i <= rowCountForPlatinum; i++) {
			Row row = new Row();
			row.setRowNo("P" + i);
			System.out.println(row.getRowNo() + "\t");

			for (int space = 0; space < i; space++) {
				System.out.print("  ");
			}
			List<Seat> seats = new ArrayList<Seat>();
			for (int j = 1; j <= initialSeatCountForPlatinum; j++) {
				Seat seat = new Seat();
				seat.setSeatNo(j);
				seat.setAvailable(false);
				seats.add(seat);
			}
			initialSeatCountForPlatinum -= 2;
			row.setSeats(seats);
			for (Seat seat : seats) {
				System.out.print(seat.getSeatNo() + "  ");
			}
			System.out.println();
			seatListsForplatinum.add(row);
		}
	}

	public void makeSeatingArrangementForGoldClass(int rowCountForGold, int initialSeatCountForGold) {
		seatListsForGold = new ArrayList<Row>();
		LOGGER.info("creating seat arrangement inside seatserviceimpl for gold class");
		for (int i = 1; i <= rowCountForGold; i++) {
			Row row = new Row();
			row.setRowNo("G" + i);
			System.out.println(row.getRowNo() + "\t");
			List<Seat> seats = new ArrayList<Seat>();
			for (int space = 0; space < i; space++) {
				System.out.print("  ");
			}
			for (int j = 1; j <= initialSeatCountForGold; j++) {
				Seat seat = new Seat();
				seat.setSeatNo(j);
				seat.setAvailable(false);
				seats.add(seat);

			}
			initialSeatCountForGold -= 2;
			row.setSeats(seats);
			for (Seat seat : seats) {
				System.out.print(seat.getSeatNo() + "  ");
			}
			System.out.println();
			seatListsForGold.add(row);
		}
	}

	public void makeSeatingArrangementForSilverClass(int rowCountForSilver, int initialSeatCountForSilver) {
		seatListsForSilver = new ArrayList<Row>();
		LOGGER.info("creating seat arrangement inside seatserviceimpl for platinum class");
		for (int i = 1; i <= rowCountForSilver; i++) {
			Row row = new Row();
			row.setRowNo("S" + i);
			System.out.println(row.getRowNo() + "\t");
			List<Seat> seats = new ArrayList<Seat>();
			for (int space = 0; space < i; space++) {
				System.out.print("  ");
			}
			for (int j = 1; j <= initialSeatCountForSilver; j++) {
				Seat seat = new Seat();
				seat.setSeatNo(j);
				seat.setAvailable(true);
				seats.add(seat);

			}
			initialSeatCountForSilver -= 2;
			row.setSeats(seats);
			for (Seat seat : seats) {
				System.out.print(seat.getSeatNo() + "  ");
			}
			System.out.println();
			seatListsForSilver.add(row);
		}
	}

	public boolean addSeatingArrangementIntoFile(String screenName) {
		boolean insertedScreen = false;
		Map<String, List<Row>> screenSeating = new LinkedHashMap<String, List<Row>>();
		screenSeating.put("Platinum", seatListsForplatinum);
		screenSeating.put("Gold", seatListsForGold);
		screenSeating.put("Silver", seatListsForSilver);
		Screen screen = seatDAO.getScreenObject(screenName);
		if(screen == null) {
			LOGGER.error("Screen not exist !!");
			throw new ScreenNullPointerException("Screen not exist");
		}
		
		try {
			if (isScreenNameNull(screenName) || isScreenNameEmpty(screenName)) {
				LOGGER.error("Screen not exist !!");
				return insertedScreen;
			} else {
				screen.setSeatings(screenSeating);
				LOGGER.error("adding seating arrangement to file inside seatserviceimpl");
				insertedScreen = seatDAO.addSeatingArrangement(screen);
				checkAvalibleSeats(screen);
			}

		} catch (MovieNullPointerException exception) {
			exception.printStackTrace();
		} catch (ScreenNullPointerException exception) {
			exception.printStackTrace();
		}
		return insertedScreen;

	}

	private boolean isScreenNameEmpty(String screenName) {
		return screenName.isEmpty();
	}

	private boolean isScreenNameNull(String screenName) {
		return null == screenName;
	}

	private void checkAvalibleSeats(Screen screen) {
		Map<String, List<Row>> screenSeating = screen.getSeatings();
		LOGGER.error("Checking seat availibility inside seatserviceimpl");
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
}
