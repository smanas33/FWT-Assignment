package com.yash.moviebookingsystem.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;
import com.yash.moviebookingsystem.exception.FileNotExistException;
import com.yash.moviebookingsystem.model.Screen;
import com.yash.moviebookingsystem.model.Show;

/**
 * This is file util class for writing into and reading from file are done
 * 
 * @author sahoo.manas
 * 
 */
public class FileUtil {

	private List<Screen> screenList = null;
	private List<Show> showList = null;

	public FileUtil() {
		screenList = new ArrayList<Screen>();
		showList = new ArrayList<Show>();
	}

	private static String screenFilePath = "src//main//resources//operatormenu//screen.json";
	private static String showFilePath = "src//main//resources//operatormenu//show.json";
	private final static Logger LOGGER = Logger.getLogger(FileUtil.class);

	public List<Screen> readFromJsonFile() {

		Gson gson = new GsonBuilder().create();
		FileReader jsonFileReader;
		try {
			jsonFileReader = new FileReader(screenFilePath);
			@SuppressWarnings("resource")
			BufferedReader bufferedReader = new BufferedReader(jsonFileReader);
			LOGGER.info("Reading file inside fileutil");
			String jsonfromString = bufferedReader.readLine();
			if (jsonfromString != null) {
				screenList = gson.fromJson(jsonfromString, new TypeToken<List<Screen>>() {
				}.getType());
			}
		} catch (IOException e) {
			LOGGER.error("File Not exist in given path" + screenFilePath);
		}
		return screenList;
	}

	public int writeIntoJsonFile(Screen screen) throws IOException {
		screenList.add(screen);
		Gson gson = new GsonBuilder().create();
		File file = new File(screenFilePath);

		try {
			if (isFileExist(file)) {
				file.createNewFile();
			}
			gson = new Gson();
			String jsonString = gson.toJson(screenList);
			FileWriter jsonFileWriter = new FileWriter(file, true);
			jsonFileWriter.write(jsonString);
			LOGGER.info("Screen added successfully in " + screenFilePath);
			jsonFileWriter.close();

		} catch (FileNotExistException e) {
			LOGGER.error("File Not exist in given path" + screenFilePath);
		}
		return screenList.size();
	}

	private boolean isFileExist(File file) {
		return !file.exists();
	}

	public boolean updateListOfScreens(List<Screen> screenList) {
		Gson gson = new GsonBuilder().create();
		try {
			LOGGER.info("Updating screen inside fileutil");
			String jsonInString = gson.toJson(screenList);
			FileWriter jsonFileWriter = new FileWriter(screenFilePath);
			jsonFileWriter.write(jsonInString);
			jsonFileWriter.close();
		} catch (ConcurrentModificationException exception) {
			LOGGER.error("Concurrent Modification");
		} catch (JsonIOException exception) {
			exception.printStackTrace();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		return true;
	}

	public Screen getScreenObject(String screenName) {
		screenList = readFromJsonFile();
		Screen requiredScreen = null;
		for (Screen screen : screenList) {
			if (screen.getScreenName().equalsIgnoreCase(screenName)) {
				requiredScreen = screen;
			} else {
				throw new NullPointerException();
			}
		}
		return requiredScreen;
	}

	public List<Show> readShowFromJsonFile() {
		Gson gson = new GsonBuilder().create();
		FileReader jsonFileReader;
		try {
			jsonFileReader = new FileReader(showFilePath);
			@SuppressWarnings("resource")
			BufferedReader bufferedReader = new BufferedReader(jsonFileReader);
			String jsonfromString = bufferedReader.readLine();
			if (jsonfromString != null) {
				showList = gson.fromJson(jsonfromString, new TypeToken<List<Show>>() {
				}.getType());
			}
		} catch (IOException e) {
			LOGGER.error("File Not exist in given path" + showFilePath);
		}
		return showList;
	}

	public int writeIntoShowJsonFile(Show show) {
		showList.add(show);
		Gson gson = new GsonBuilder().create();
		File file = new File(showFilePath);

		try {
			if (isFileExist(file)) {
				file.createNewFile();
			}
			gson = new Gson();
			String jsonString = gson.toJson(showList);
			FileWriter jsonFileWriter = new FileWriter(file, true);
			jsonFileWriter.write(jsonString);
			LOGGER.info("Screen added successfully in " + showFilePath);
			jsonFileWriter.close();

		} catch (FileNotExistException e) {
			LOGGER.error("File Not exist in given path" + showFilePath);
		} catch (IOException e) {
			LOGGER.error("File Not Found" + showFilePath);
		}
		return screenList.size();
	}

	public int updateListOfShows(List<Show> showList) {
		Gson gson = new GsonBuilder().create();
		try {
			LOGGER.info("Updating show inside fileutil");
			String jsonInString = gson.toJson(showList);
			FileWriter jsonFileWriter = new FileWriter(showFilePath);
			jsonFileWriter.write(jsonInString);
			jsonFileWriter.close();
		} catch (ConcurrentModificationException exception) {
			LOGGER.error("Concurrent Modification");
		} catch (JsonIOException exception) {
			exception.printStackTrace();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		return showList.size();
	}

}
