package extracter;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Scanner;

import javax.swing.*;


public class UserInterface {

	public static JButton enterButton;
	public static int columnCount;
	public static String[] headingArray;
	public static String[] typeArray;
	private static String ENTER = "Enter";
    public static JTextArea output;
    public static JTextField input;
    static JFrame frame;
    static JPanel panel;
	public static String myString;
	public static JTextArea editTextArea = new JTextArea("Type Here!");
	public static String path;
	
	public static void setHeaders(int columnCount){
		headingArray = new String[columnCount];
		JFrame jFrame = new JFrame("Set Headers");
		jFrame.setPreferredSize(new Dimension(250, 100));
		jFrame.setLayout(new FlowLayout());
		JTextField textBox = new JTextField();
		textBox.setPreferredSize(new Dimension(100, 30));
		jFrame.add(textBox);
		
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
        JButton button = new JButton("Submit");
		
        jFrame.getContentPane().add(button);
		jFrame.pack();
		jFrame.setVisible(true);
		
		button.addActionListener(new ActionListener() {
			int count = 1;
			@Override
		    public void actionPerformed(ActionEvent event) {
				if(count < columnCount){
					headingArray[count] = textBox.getText();
					textBox.setText("");
					count++;
				} else {
				
				jFrame.dispose();
				setType(columnCount);
				}
			}
		});
		
	}
	
	public static void setType(int columnCount){
		String [] TypeChoices = {"Type.DATETIME", "Type.CHAR_STRING", "Type.UNICODE_STRING", "Type.DOUBLE", 
				"Type.INTEGER", "Type.BOOLEAN", "Type.DATE"};
		JFrame jFrame = new JFrame("Set Type");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JComboBox typeList = new JComboBox(TypeChoices);
		typeList.setSelectedIndex(6);
		
		jFrame.add(typeList);
		jFrame.pack();
		jFrame.setVisible(true);
		
		typeArray = new String[columnCount];
		
		typeList.addActionListener(new ActionListener() {
			int count = 1;
			@Override
		    public void actionPerformed(ActionEvent event) {
				if(count < columnCount){
					typeArray[count] = (String) typeList.getSelectedItem();
					count++;
				} else {
				
				jFrame.dispose();
				}
			}
		});
	}
	
	
	public static void setColumnCount(){
		JFrame jFrame = new JFrame("Set column count");
		jFrame.setPreferredSize(new Dimension(250, 100));
		jFrame.setLayout(new FlowLayout());
		JTextField textBox = new JTextField();
		textBox.setPreferredSize(new Dimension(100, 30));
		jFrame.add(textBox);
		
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
        JButton button = new JButton("Submit");
		
        jFrame.getContentPane().add(button);
		jFrame.pack();
		jFrame.setVisible(true);
		
		button.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent event) {
		    	try {
		    		columnCount = Integer.parseInt(textBox.getText());
			        jFrame.dispose();
			    	setCSVFile(); 
		    	}
		    	catch (NumberFormatException ex) {
		    		JOptionPane.showMessageDialog(frame, "Please enter an integer");
		    	}
		    	
		    }
		});
		
		
	}
	
	public static void setCSVFile(){
		JFrame parentFrame = new JFrame();
		 
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to open");   
		 
		int userSelection = fileChooser.showOpenDialog(parentFrame);
		 
		if (userSelection == JFileChooser.APPROVE_OPTION) {
		    	File fileToOpen = fileChooser.getSelectedFile();
		    	path = fileToOpen.getAbsolutePath();
		   
		   setHeaders(columnCount);
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException{
		setColumnCount();	
	}
}

	
