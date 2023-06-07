package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.stream.IntStream;

import javax.swing.JOptionPane;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information in such a way
	 * that only authorized parties can access it and those who are not authorized
	 * cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message down based
	 * on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user. Use the key to
	 * shift each letter in the users input and save the final result to a file.
	 * 
	 */

	public static void main(String[] args) {

		String message = JOptionPane.showInputDialog("What is your message?");
		String wordKey = JOptionPane.showInputDialog("What is the key?");
		int key = Integer.parseInt(wordKey);

		StringBuilder outc = new StringBuilder();

		char[] messageSeparate = message.toCharArray();
		for (int j = 0; j < messageSeparate.length; j++) {
			if (messageSeparate[j] != 32) {

				switch(messageSeparate[j] + key) {
				case (messageSeparate[j] + key > 96):
					
				}
				
			} else {
				outc.append(' ');
			}

			System.out.println(outc.toString());
			try {
				FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/text.txt");
				fw.write(outc.toString());
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
