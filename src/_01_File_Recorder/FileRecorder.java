package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	
	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("What text would you want to add to your file?");
		
		
		try {
			FileWriter fw = new FileWriter("src/_01_File_Recorder/worked.txt");
			fw.write(input);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

//Copyright © 2023 Igor Aliasiuk