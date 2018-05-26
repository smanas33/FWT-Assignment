package com.yash.moviebookingsystem.menu.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.yash.moviebookingsystem.exception.FileEmptyException;
import com.yash.moviebookingsystem.exception.FileNullPointerException;
import com.yash.moviebookingsystem.model.Screen;
import com.yash.moviebookingsystem.model.Show;
import com.yash.moviebookingsystem.screendao.ScreenDAO;
import com.yash.moviebookingsystem.screendaoimpl.ScreenDAOImpl;
import com.yash.moviebookingsystem.screenservice.ScreenService;
import com.yash.moviebookingsystem.screenserviceimpl.ScreenServiceImpl;
import com.yash.moviebookingsystem.util.FileUtil;

public class OperatorMenu {
	
	private static Scanner operatorInputScanner = new Scanner(System.in);
	
	
	private final static Logger LOGGER = Logger.getLogger(OperatorMenu.class);
	
	private static void getOperatorMenu() {
		String fileName = "src//main//resources//operatormenu//testFile1.txt";
		
		if (isFileNameNull(fileName)) {
			LOGGER.error("File name should not be null");
			throw new FileNullPointerException("File name should not be null");
		}
		
		else if (isFileEmpty(fileName)) {
			LOGGER.error("File name should not empty");
			throw new FileNullPointerException("File name should not empty");
		}
		
		else getMenu(fileName);	
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
//				LOGGER.info(line);
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
		
		int operatorChoice;
		do{	
			getOperatorMenu();
			System.out.println("Enter your choice: ");
			operatorChoice = operatorInputScanner.nextInt();
			switch(operatorChoice){
				case 1:	Screen screen = screenInputDetails();
						System.out.println(screen);
						try {
							serviceImpl.addScreen(screen);
						} catch(FileNullPointerException e){
							LOGGER.error("Null File Entry");
						} catch (IOException e) {
							LOGGER.error("File Not Found");
						}
				
				case 2: Show show = showInputDetails();
				System.out.println(show);
					break;
				case 3:
					break;
				case 4:
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
		}while(operatorChoice != 0);
		
	}

	private static boolean isFileNameNull(String fileName) {
		return null == fileName;
	}

	private static Screen screenInputDetails() {
		System.out.println("Give an id to screen: ");
		int screenId = operatorInputScanner.nextInt();
		System.out.println("Give a name to screen: ");
		String screenName = operatorInputScanner.next();
		Screen screen = new Screen(screenId, screenName);
		return screen;
	}
	
	private static Show showInputDetails() {
		System.out.println("Enter a name for show: ");
		String showName = operatorInputScanner.next();
		System.out.println("Enter show time: ");
		String showTime = operatorInputScanner.next();
		Screen screen = null;
		Show show = new Show(showName, screen, showTime);
		return show;
	}
	
}
