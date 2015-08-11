package extracter;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;


public class UserInterface {

	public static JButton enterButton;
	private static String ENTER = "Enter";
    public static JTextArea output;
    public static JTextField input;
    static JFrame frame;
    static JPanel panel;
	public static String myString;
	public static JTextArea editTextArea = new JTextArea("Type Here!");
	public static String path;

	
	public static void setupFrame(){
		JFrame jFrame = new JFrame("CSV TDE creator");
		jFrame.setPreferredSize(new Dimension(1000, 1000));
		
		JMenuBar greenMenuBar = new JMenuBar();
		
		greenMenuBar.setOpaque(true);
		greenMenuBar.setBackground(new Color(154, 165, 127));
		greenMenuBar.setPreferredSize(new Dimension(200, 20));
		
		JTextField textField = new JTextField();
		textField.setBounds(6, 41, 134, 28);
		jFrame.add(textField);
	    textField.setColumns(10);

	    enterButton = new JButton();
        enterButton.setPreferredSize(new Dimension(40, 40));
        jFrame.add(enterButton);
     
        JButton fat = new JButton("Fat");
        JButton skinny = new JButton("Skinny");

        JPanel buttonPane = new JPanel();
        buttonPane.add(skinny);

        JFrame frame = new JFrame("Testing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(fat, BorderLayout.NORTH);
        frame.add(buttonPane, BorderLayout.SOUTH);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
		
		jFrame.pack();
		jFrame.setVisible(true);
	
		
	
	}
	
	public static String getCSVFile(){
		JFrame parentFrame = new JFrame();
		 
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to open");   
		 
		int userSelection = fileChooser.showOpenDialog(parentFrame);
		 
		if (userSelection == JFileChooser.APPROVE_OPTION) {
		    File fileToOpen = fileChooser.getSelectedFile();
		   path = fileToOpen.getAbsolutePath();
		}
		return path;
	}
	
	public static void main(String[] args){
		setupFrame();
		System.out.println(getCSVFile());
	}
}
