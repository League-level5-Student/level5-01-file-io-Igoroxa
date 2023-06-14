package _04_Directory_Iteration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class DirectoryIterator {
	public static void main(String[] args) {
		/*
		 * The following is an example of how to list all of the files in a directory.
		 * Once the program is running, the directory is chosen using the JFileChooser.
		 */
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File directory = jfc.getSelectedFile();
			fileChoose(directory);

		}

		/*
		 * Your task is to write a program that iterates through the src folder of this
		 * current Java Project. For every .java file it finds, the program will add a
		 * (non-legally binding) copyright statement at the bottom. Be aware of possible
		 * directories inside of directories. (e.g //Copyright © 2019 FirstName
		 * LastName)
		 */
	}

	static void fileChoose(File use) {

		System.out.println(use.getAbsolutePath());
		File[] files = use.listFiles();
		if (files != null) {
			for (File f : files) {
				fileChoose(f);
				if (f.getName().contains(".java")) {
					try {
						System.out.println("works");
						FileWriter fw = new FileWriter(f.getAbsolutePath(), true);

						fw.write("\n//Copyright © 2023 Igor Aliasiuk");

						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

}

//Copyright © 2023 Igor Aliasiuk