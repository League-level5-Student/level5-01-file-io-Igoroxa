package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and
	 * understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up, at
	 * the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is
	 * decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */
	public static void main(String[] args) {

		String decry = new String();
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_02_File_Encrypt_Decrypt/text.txt"));

			String line = br.readLine();
			decry = line;
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}

			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		StringBuilder outc = new StringBuilder();
		int temp = 0;

		char[] messageSeparate = decry.toCharArray();
		for (int j = 0; j < messageSeparate.length; j++) {
			if (messageSeparate[j] != ' ') {
				if (Character.isUpperCase(messageSeparate[j])) {
					if (messageSeparate[j] - 4 > 'A') {

						messageSeparate[j] -= 4;
						outc.append(messageSeparate[j]);
					} else {
						temp = 26 - 4;
						messageSeparate[j] += temp;
						outc.append(messageSeparate[j]);

					}

				}
				if (Character.isLowerCase(messageSeparate[j])) {

					if (messageSeparate[j] - 4 > 'a') {

						messageSeparate[j] -= 4;
						outc.append(messageSeparate[j]);
					} else {
						temp = 26 - 4;
						messageSeparate[j] += temp;
						outc.append(messageSeparate[j]);

					}

				}

			} else {
				outc.append(' ');

			}
		}
		System.out.println(outc.toString());

	}
}
