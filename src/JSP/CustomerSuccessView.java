package JSP;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CustomerSuccessView {
	
	private JLabel lblName;
	private JPanel panel1;
	
	public CustomerSuccessView (String name) {
		JFrame frame = new JFrame();
		this.lblName = new JLabel("Welcome " + name + "!");
		this.panel1 = new JPanel();
		this.lblName.setFont(new Font("Arial",Font.PLAIN,25));
		this.panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.panel1.add(this.lblName);
		
		frame.getContentPane().add(panel1, BorderLayout.CENTER);
		frame.setBounds(280,120,500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}	

}

