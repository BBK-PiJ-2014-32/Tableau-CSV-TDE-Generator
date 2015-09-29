package extracter;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Scanner;

import com.tableausoftware.TableauException;
import com.tableausoftware.extract.*;
import com.tableausoftware.common.*;

import javax.swing.*;


public class UserInterface {

	public static JButton enterButton;
	public static int columnCount;
	public static String[] headingArray;
	public static Type[] typeArray;
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
			int count = 0;
			@Override
		    public void actionPerformed(ActionEvent event) {
				if(count < columnCount-1){
					headingArray[count] = textBox.getText();
					textBox.setText("");
					count++;
				} else {
				headingArray[count] = textBox.getText();
				jFrame.dispose();
				setType(columnCount);
				}
			}
		});
		
	}
	
	public static void setType(int columnCount){
		Type [] TypeChoices = {Type.DATETIME, Type.CHAR_STRING, Type.UNICODE_STRING, Type.DOUBLE, 
				Type.INTEGER, Type.BOOLEAN, Type.DATE};
		JFrame jFrame = new JFrame("Set Type");
		jFrame.setPreferredSize(new Dimension(250, 100));
		jFrame.setLayout(new FlowLayout());
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JComboBox typeList = new JComboBox(TypeChoices);
		typeList.setSelectedIndex(6);
		
		jFrame.add(typeList);
		jFrame.pack();
		jFrame.setVisible(true);
		
		typeArray = new Type[columnCount];
		
		typeList.addActionListener(new ActionListener() {
			int count = 0;
			@Override
		    public void actionPerformed(ActionEvent event) {
				if(count < columnCount-1){
					typeArray[count] = (Type) typeList.getSelectedItem();
					count++;
				} else {
				typeArray[count] = (Type) typeList.getSelectedItem();
				jFrame.dispose();
				startExtracter();
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
	
	public static void startExtracter(){
		JFrame jFrame = new JFrame("Start Extracter");
		jFrame.setPreferredSize(new Dimension(250, 100));
		jFrame.setLayout(new FlowLayout());
		
		JLabel label1 = new JLabel("Would you like to start the Extract?");
		
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
        JButton button = new JButton("Ok");
		
        jFrame.getContentPane().add(button);
        jFrame.add(label1);
		jFrame.pack();
		jFrame.setVisible(true);
		
		button.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent event) {
			        jFrame.dispose();
		    }
		});
		
		Extracter ex = new Extracter(columnCount, headingArray, typeArray, path);
		try {
			 TableDefinition tableDef = ex.makeTableDef();
			 ex.printTableDefinition(tableDef);
			 ex.csvReader();
		} catch (TableauException e) {
			e.printStackTrace();
		}
		
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

	
