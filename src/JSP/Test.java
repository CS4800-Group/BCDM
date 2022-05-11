package JSP;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test {
	public static void main(String[] args) {
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 250, 150);
		
		JPanel panel2 = new JPanel();
		panel.setBounds(100, 100, 250, 250);
		
		JLabel label = new JLabel(); // create label
		label.setText("Bro, do you even code?");
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.CENTER);
		label.setBounds(100, 100, 250, 250);
		label.setFont(new Font("Times", Font.PLAIN, 18));
		
		// JFrame: a GUI window to add components to
		JFrame frame = new JFrame();	// creates a frame
		
		frame.setTitle("JFrame title goes here"); // sets title of frame
		frame.setResizable(false); // prevents frame from being resized
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
		frame.setLayout(null);
		frame.setSize(750, 750);	// set the x-dimension and y-dimension of frame
		frame.setVisible(true);	// make frame visible
		frame.add(label);
		frame.add(panel);
		frame.add(panel2);
		
	}
}
