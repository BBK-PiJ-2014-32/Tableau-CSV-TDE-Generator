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
	
	public static String[] getHeaders(int count){
		headingArray = new String[count];
		JFrame jFrame = new JFrame("CSV TDE creator");
		jFrame.setPreferredSize(new Dimension(250, 250));
		jFrame.setLayout(new FlowLayout());
		JTextField textBox = new JTextField();
		textBox.setPreferredSize(new Dimension(75, 50));
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
				if(count < 4){
					headingArray[count] = textBox.getText();
					System.out.println(headingArray[count] + count);
					System.out.println(textBox.getText());
					count++;
				} else {
				
				jFrame.dispose();
				}
			}
		});
		
		return headingArray;
		
	}
	
	
	
	public static int getColumnCount(){
		JFrame jFrame = new JFrame("CSV TDE creator");
		jFrame.setPreferredSize(new Dimension(250, 250));
		jFrame.setLayout(new FlowLayout());
		JTextField textBox = new JTextField();
		textBox.setPreferredSize(new Dimension(75, 50));
		jFrame.add(textBox);
		
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
        JButton button = new JButton("Submit");
		
        jFrame.getContentPane().add(button);
		jFrame.pack();
		jFrame.setVisible(true);
		
		button.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent event) {
		        System.out.println("The column count is: " + textBox.getText());
		        jFrame.dispose();
		    }
		});
		
		return columnCount;
		
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
	
	public static void main(String[] args) throws InterruptedException{
		//setupFrame();
		
		//columnCount = getColumnCount();
		//path = getCSVFile();
		String[] testArray = getHeaders(4);
		Thread.sleep(10000);
		
		for(int i = 0; i < 4; i++){
			System.out.println(testArray[i]);
		}
		
	}
}

	
