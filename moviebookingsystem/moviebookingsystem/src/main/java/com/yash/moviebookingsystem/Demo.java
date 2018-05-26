package com.yash.moviebookingsystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo {

	public static void main(String[] args) throws IOException {
		
//		File file = new File("testFile1.txt");
//		FileWriter writer = new FileWriter(file);
//		BufferedWriter bufferedWriter = new BufferedWriter(writer);
//		bufferedWriter.write("********************  Welcome To Movie Booking System  **********************");
//		bufferedWriter.newLine();
//		bufferedWriter.write("Enter your choice: ");
//		bufferedWriter.newLine();
//		bufferedWriter.write("1. Adding Screen to the Theatre");
//		bufferedWriter.newLine();
//		bufferedWriter.write("2. Adding Movie to the Screen");
//		bufferedWriter.newLine();
//		bufferedWriter.write("3. Design Seating arrangement to a Screen");
//		bufferedWriter.newLine();
//		bufferedWriter.write("4. Adding shows for Movie");
//		bufferedWriter.newLine();
//		bufferedWriter.write("5. Book Ticket");
//		bufferedWriter.newLine();
//		bufferedWriter.write("6. Cancel Booking");
//		bufferedWriter.newLine();
//		bufferedWriter.write("7. Show availability");
//		bufferedWriter.newLine();
//		bufferedWriter.write("8. Reports");
//		bufferedWriter.newLine();
//		bufferedWriter.close();
		
		String line = null;
		FileReader reader = new FileReader("testFile1.txt");
		BufferedReader bufferedReader = new BufferedReader(reader);
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println(line);
		}
		bufferedReader.close();

	}

}
