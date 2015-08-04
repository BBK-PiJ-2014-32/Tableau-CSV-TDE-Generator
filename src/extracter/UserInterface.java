package extracter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class UserInterface {

	
	public static void setupFrame(){
		JFrame jFrame = new JFrame("CSV TDE creator");
		jFrame.setPreferredSize(new Dimension(250, 250));
		
		JMenuBar greenMenuBar = new JMenuBar();
		
		greenMenuBar.setOpaque(true);
		greenMenuBar.setBackground(new Color(154, 165, 127));
		greenMenuBar.setPreferredSize(new Dimension(200, 20));
		
		jFrame.pack();
		jFrame.setVisible(true);
	}

	public static void main(String[] args){
		setupFrame();
	}
}
