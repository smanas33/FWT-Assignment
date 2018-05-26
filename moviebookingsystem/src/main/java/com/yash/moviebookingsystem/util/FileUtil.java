package com.yash.moviebookingsystem.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;
import com.yash.moviebookingsystem.exception.FileNotExistException;
import com.yash.moviebookingsystem.model.Screen;

public class FileUtil {
	
	List<Screen> screenList = null;

	public FileUtil() {
		screenList = new ArrayList<Screen>();
	}
	
	private static String filePath = "src//main//resources//operatormenu//screen.json";
	private final static Logger LOGGER = Logger.getLogger(FileUtil.class);
	
	public List<Screen> readFromJsonFile() {
		
		Gson gson = new GsonBuilder().create();
		FileReader jsonFileReader;
		try {
			jsonFileReader = new FileReader(filePath);
			@SuppressWarnings("resource")
			BufferedReader bufferedReader = new BufferedReader(jsonFileReader);
			String jsonfromString = bufferedReader.readLine();
			if (jsonfromString != null) {
				screenList = gson.fromJson(jsonfromString, new TypeToken<List<Screen>>() {
				}.getType());
			}
		} catch (IOException e) {
			LOGGER.error("File Not exist in given path" + filePath);
		}
		return screenList;
	}

	public int writeIntoJsonFile(Screen screen) throws IOException {
		screenList.add(screen);
		Gson gson = new GsonBuilder().create();
		File file = new File(filePath);	
		
		try {			
			if(isFileExist(file)){
				file.createNewFile();
			}
            gson = new Gson();
            String jsonString = gson.toJson(screen);  
            FileWriter jsonFileWriter = new FileWriter(file,true);
            jsonFileWriter.write(jsonString);
            LOGGER.info("Screen added successfully in " + filePath);
            jsonFileWriter.close();
    
			      
        } catch (FileNotExistException e) {
        	LOGGER.error("File Not exist in given path" + filePath);
        }
		return screenList.size();
	}

	private boolean isFileExist(File file) {
		return !file.exists();
	}

	public boolean updateListOfScreens(List<Screen> screenList) {
		Gson gson = new GsonBuilder().create();
		try {
			String jsonInString = gson.toJson(screenList);
			FileWriter jsonFileWriter = new FileWriter("src/main/resources/Json/Screen.json");
			jsonFileWriter.write(jsonInString);
			jsonFileWriter.close();
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public Screen getScreenObject(String screenName) {
		screenList=readFromJsonFile();
		Screen requiredScreen=null;
		for (Screen screen : screenList) {
			if(screen.getScreenName().equalsIgnoreCase(screenName)){
				requiredScreen=screen;
			}
		}
		return requiredScreen;
	}

}
