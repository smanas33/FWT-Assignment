package com.yash.operator.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class OperatorUtils {
	
	public PrintStream out = System.out;
	
	public void getOperatorMenu() {
		
		String line = null;
		FileReader reader;
		BufferedReader bufferedReader = null;
		try {
			reader = new FileReader("testFile1.txt");
			bufferedReader = new BufferedReader(reader);
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			e.printStackTrace();
		} 	
	}
}
