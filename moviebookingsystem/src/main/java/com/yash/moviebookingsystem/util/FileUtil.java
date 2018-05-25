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
import com.google.gson.reflect.TypeToken;
import com.yash.moviebookingsystem.exception.FileEmptyException;
import com.yash.moviebookingsystem.exception.FileNotExistException;
import com.yash.moviebookingsystem.model.Screen;

public class FileUtil {
	
	private static String filePath = "src//main//resources//operatormenu//screen.json";
	private final static Logger LOGGER = Logger.getLogger(FileUtil.class);
	private Gson gson;
	
	public List<Screen> readFromJsonFile(String filePath) throws FileEmptyException, IOException {
		List<Screen> screensList = new ArrayList<Screen>();
		try {
            gson = new Gson();
            
            BufferedReader bufferedReader = new BufferedReader(  
                    new FileReader(filePath));
            
            String jsonfromString = bufferedReader.readLine();
            if (jsonfromString != null) {
	            screensList = gson.fromJson(jsonfromString, 
	            		new TypeToken<List<Screen>>() {}.getType());
            }      
            
        } catch (FileNotExistException fileNotExist) {  
        	LOGGER.error("File Not exist in given path" + filePath);
        }  
		return screensList;
	}

	public int writeIntoJsonFile(Screen screen) throws IOException {
		int rowAffected = 0;
		File file = new File(filePath);	
		try {			
			if(isFileExist(file)){
				file.createNewFile();
			}
            gson = new Gson();
            String jsonString = gson.toJson(screen);  
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(jsonString);
            LOGGER.info("Screen added successfully in " + filePath);
            fileWriter.close();
            rowAffected = 1;
			      
        } catch (FileNotExistException e) {
        	LOGGER.error("File Not exist in given path" + filePath);
        }
		return rowAffected;
	}

	private boolean isFileExist(File file) {
		return !file.exists();
	}

	public int writeMovieIntoJsonFile(Screen screen) {
		
		return 0;
	}

}
