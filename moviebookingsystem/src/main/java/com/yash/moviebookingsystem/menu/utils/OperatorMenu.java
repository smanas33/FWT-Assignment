package com.yash.moviebookingsystem.menu.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.yash.moviebookingsystem.exception.FileNullPointerException;
import com.yash.moviebookingsystem.model.Movie;
import com.yash.moviebookingsystem.model.Screen;
import com.yash.moviebookingsystem.model.Show;
import com.yash.moviebookingsystem.screendao.MovieDAO;
import com.yash.moviebookingsystem.screendao.ScreenDAO;
import com.yash.moviebookingsystem.screendao.SeatDAO;
import com.yash.moviebookingsystem.screendao.ShowDAO;
import com.yash.moviebookingsystem.screendaoimpl.MovieDAOImpl;
import com.yash.moviebookingsystem.screendaoimpl.ScreenDAOImpl;
import com.yash.moviebookingsystem.screendaoimpl.SeatDAOImpl;
import com.yash.moviebookingsystem.screendaoimpl.ShowDAOImpl;
import com.yash.moviebookingsystem.screenservice.MovieService;
import com.yash.moviebookingsystem.screenservice.ScreenService;
import com.yash.moviebookingsystem.screenservice.SeatService;
import com.yash.moviebookingsystem.screenservice.ShowService;
import com.yash.moviebookingsystem.screenserviceimpl.MovieServiceImpl;
import com.yash.moviebookingsystem.screenserviceimpl.ScreenServiceImpl;
import com.yash.moviebookingsystem.screenserviceimpl.SeatServiceImpl;
import com.yash.moviebookingsystem.screenserviceimpl.ShowServiceImpl;
import com.yash.moviebookingsystem.util.FileUtil;

/**
 * The class represents the menu for operator.
 * 
 * @author sahoo.manas
 * 
 */
public class OperatorMenu {

	private static Scanner operatorInputScanner = new Scanner(System.in);

	private final static Logger LOGGER = Logger.getLogger(OperatorMenu.class);

	private static void getOperatorMenu() {
		String fileName = "src//main//resources//operatormenu//operatormenu.txt";

		if (isFileNameNull(fileName)) {
			LOGGER.error("File name should not be null");
			throw new FileNullPointerException("File name should not be null");
		}

		else if (isFileEmpty(fileName)) {
			LOGGER.error("File name should not empty");
			throw new FileNullPointerException("File name should not empty");
		}

		else
			getMenu(fileName);
	}

	private static boolean isFileEmpty(String fileName) {
		return fileName.isEmpty();
	}

	private static void getMenu(String fileName) {
		String line;
		FileReader reader;
		BufferedReader bufferedReader;

		try {
			reader = new FileReader(fileName);
			bufferedReader = new BufferedReader(reader);
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
			bufferedReader.close();

		} catch (FileNotFoundException fileNotFoundException) {
			LOGGER.error("File not found");
			System.out.println("File not found");
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}

	}

	public static void chooseUserOption() {
		FileUtil fileUtil = new FileUtil();
		ScreenDAO screenDAO = new ScreenDAOImpl(fileUtil);
		ScreenService serviceImpl = new ScreenServiceImpl(screenDAO);

		MovieDAO movieDAO = new MovieDAOImpl(fileUtil);
		MovieService movieService = new MovieServiceImpl(movieDAO);

		ShowDAO showDAO = new ShowDAOImpl(fileUtil);
		ShowService showService = new ShowServiceImpl(showDAO);

		SeatDAO seatDAO = new SeatDAOImpl(fileUtil);
		SeatService seatService = new SeatServiceImpl(seatDAO);

		int operatorChoice;
		do {
			getOperatorMenu();
			System.out.println("Enter your choice: ");
			operatorChoice = operatorInputScanner.nextInt();
			switch (operatorChoice) {
			case 1:
				System.out.println("---------------------");
				System.out.println("ADD Screen Selected ");
				System.out.println("---------------------\n");
				Screen screen = screenInputDetails();
				System.out.println(screen);
				try {
					serviceImpl.addScreen(screen);
				} catch (FileNullPointerException e) {
					LOGGER.error("Null File Entry");
				} catch (IOException e) {
					LOGGER.error("File Not Found");
				}
				break;

			case 2:
				System.out.println("---------------------");
				System.out.println("ADD Movie Selected ");
				System.out.println("---------------------\n");
				Movie movie = movieInputDetails();
				String screenName = screenNameInput();
				try {
					movieService.addMovie(movie, screenName);
				} catch (FileNullPointerException e) {
					LOGGER.error("Null File Entry");
				} catch (IOException e) {
					LOGGER.error("File Not Found");
				}

				break;
			case 3:
				System.out.println("----------------------------");
				System.out.println("Seating Arrangment Selected ");
				System.out.println("----------------------------\n");
				System.out.println("Enter Total Number of rows in Platinum Class ");
				int rowCountForPlatinum = operatorInputScanner.nextInt();
				int initialSeatCountForPlatinum = inputRowCount(rowCountForPlatinum);
				seatService.makeSeatingArrangementForPlatinumClass(rowCountForPlatinum, initialSeatCountForPlatinum);
				System.out.println("Enter Total Number of rows in Gold Class ");
				int rowCountForGold = operatorInputScanner.nextInt();
				int initialSeatCountForGold = inputRowCount(rowCountForGold);
				seatService.makeSeatingArrangementForGoldClass(rowCountForGold, initialSeatCountForGold);
				System.out.println("Enter Total Number of rows in Silver Class ");
				int rowCountForSilver = operatorInputScanner.nextInt();
				int initialSeatCountForSilver = inputRowCount(rowCountForSilver);
				seatService.makeSeatingArrangementForSilverClass(rowCountForSilver, initialSeatCountForSilver);
				String screenName2 = screenNameInput();
				try {
					seatService.addSeatingArrangementIntoFile(screenName2);
				} catch (FileNullPointerException e) {
					LOGGER.error("Null File Entry");
				}
				break;
			case 4:
				System.out.println("---------------------");
				System.out.println("ADD Show Selected ");
				System.out.println("---------------------\n");
				Show show = showInputDetails();
				String screenName3 = screenNameInput();
				try {
					showService.addShow(show, screenName3);
				} catch (FileNullPointerException e) {
					LOGGER.error("Null File Entry");
				}
				break;
			case 5:
				
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 0:
				System.exit(0);
			default:
				System.out.println("Please Give a valid input !!\n");
			}
		} while (operatorChoice != 0);

	}

	private static int inputRowCount(int rowCount) {
		int initialSeatCount = 0;
		do {
			System.out.println("Minimum number of seat in 1st row to make Seating is " + rowCount * 3);
			System.out.println("\nEnter Number of seat in 1st Row");
			initialSeatCount = operatorInputScanner.nextInt();
		} while (initialSeatCount < (rowCount * 3));
		return initialSeatCount;
	}

	private static boolean isFileNameNull(String fileName) {
		return null == fileName;
	}

	private static Screen screenInputDetails() {
		System.out.println("Give an id to screen: ");
		int screenId = operatorInputScanner.nextInt();
		System.out.println("Give a name to screen: ");
		String screenName = operatorInputScanner.next();
		System.out.println("Add total no of shows to screen: ");
		int totalShows = operatorInputScanner.nextInt();
		Screen screen = new Screen(screenId, screenName);
		screen.setTotalShows(totalShows);
		return screen;
	}

	private static Movie movieInputDetails() {
		Movie movie = null;
		System.out.println("Enter movie title: ");
		String movieTitle = operatorInputScanner.next();
		System.out.println("Enter production of movie: ");
		String production = operatorInputScanner.next();
		List<String> actors = inputListOfActors();
		System.out.println("Enter duration of the movie: ");
		String time = operatorInputScanner.next();
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		try {
			Date duration = format.parse(time);
			movie = new Movie(movieTitle, production, actors, duration);
		} catch (ParseException exception) {
			LOGGER.error("Cannot parsed string to date");
		}
		return movie;
	}

	private static String screenNameInput() {
		System.out.println("Enter screen name in which you want to add: ");
		String screenName = operatorInputScanner.next();
		return screenName;
	}

	private static List<String> inputListOfActors() {
		List<String> actors = new ArrayList<String>();
		char choice;
		do {
			System.out.println("Add actors: ");
			String actor = operatorInputScanner.next();
			actors.add(actor);
			System.out.println("Do you want to add more actor(y/n)");
			choice = operatorInputScanner.next().charAt(0);
		} while ((choice != 'n') && (choice != 'N'));
		return actors;
	}

	private static Show showInputDetails() {
		System.out.println("Enter a name for show: ");
		String showName = operatorInputScanner.next();
		System.out.println("Enter show time: ");
		String showTime = operatorInputScanner.next();
		Show show = new Show(showName, showTime);
		return show;
	}

}
