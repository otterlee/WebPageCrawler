package edu.handong.csee.java.bonushw;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileWriter {
	String outputPath = "";
	String allLines = "";
	
	FileWriter(String outputPathToSave, String linesToWrite){
		this.outputPath = outputPathToSave;
		this.allLines = linesToWrite;
	}
	
	public void write() {
		
		PrintWriter outputStream = null;

		try {
			outputStream = new PrintWriter(outputPath);
			System.out.println(allLines);
			outputStream.println(allLines);
		} catch(FileNotFoundException e) {
			System.out.println("Error creating the file in" + outputPath);
			System.exit(0);
		}
		outputStream.close();
		System.out.println ("Those lines were written to " + outputPath);
	}
}
