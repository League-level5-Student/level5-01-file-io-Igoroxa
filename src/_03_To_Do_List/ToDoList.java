package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 *
	 * When add task is clicked: Create a JOptionPane to ask the user for a task and
	 * add it to an ArrayList
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: Create a JOptionPane to prompt the
	 * user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Create a JOptionPane to Prompt the user
	 * for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */
	ArrayList<String> tasks = new ArrayList<String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();

	JButton add = new JButton("Add Task");
	JButton view = new JButton("View Tasks");
	JButton remove = new JButton("Remove Task");
	JButton save = new JButton("Save List");
	JButton load = new JButton("Load List");

	public static void main(String[] args) {
		ToDoList list = new ToDoList();
		list.fileLoader();
		list.setup();
		
	}
	void fileLoader() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/List.txt"));	
			String line = br.readLine();
			while(line != null){
				tasks.add(line);
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
		
	}

	void setup() {
		frame.add(panel);
		panel.add(load);
		panel.add(save);
		panel.add(remove);
		panel.add(view);
		panel.add(add);

		frame.pack();
		frame.setVisible(true);

		add.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == add) {
			String input = JOptionPane.showInputDialog("What task do you want to add");
			tasks.add(input);
		}
		if (e.getSource() == view) {
			for (int i = 0; i < tasks.size(); i++) {

				JOptionPane.showMessageDialog(null, tasks.get(i));
			}
		}
		if (e.getSource() == remove) {
			String inputted = JOptionPane.showInputDialog("Which task number do you want to remove?");
			int removed = Integer.parseInt(inputted)+1;
			tasks.remove(removed);
		}
		if (e.getSource() == save) {
			for (int i = 0; i < tasks.size(); i++) {
				try {
					FileWriter fr = new FileWriter("src/_03_To_Do_List/List.txt");
					
					fr.write(tasks.get(i));
					fr.close();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}
		if (e.getSource() == load) {
			JFileChooser jfc = new JFileChooser();
			int returnVal = jfc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				String fileName = jfc.getSelectedFile().getAbsolutePath();
				System.out.println(fileName);
		}
	}
	}
}


