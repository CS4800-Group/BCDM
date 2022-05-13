package desktopApp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import orderRegistration.Receipt;

@SuppressWarnings("serial")
public class WelcomeView extends JFrame implements ActionListener {

	private JButton buttonCreate, buttonOrders;
	private JPanel panel1, panel2, panel3;
	private Receipt receipt;

	public WelcomeView() {
			this.initializeComponents();
			this.buildUI();
		}

	private void initializeComponents() {
		this.buttonCreate = new JButton("Create Order");
		this.buttonCreate.addActionListener(this);

		this.buttonOrders = new JButton("Order History");
		this.buttonOrders.addActionListener(this);

		this.panel1 = new JPanel();
		this.panel1.setLayout(new FlowLayout(FlowLayout.CENTER));

		this.panel2 = new JPanel();
		this.panel2.setLayout(new FlowLayout(FlowLayout.CENTER));

		this.panel3 = new JPanel();
		this.panel3.setLayout(new FlowLayout(FlowLayout.CENTER));

	}

	private void buildUI() {
		this.panel1.add(this.buttonCreate);
		this.panel2.add(this.buttonOrders);
		
		this.getContentPane().add(panel1, BorderLayout.NORTH);
		this.getContentPane().add(panel2, BorderLayout.CENTER);
		this.getContentPane().add(panel3, BorderLayout.SOUTH);

		this.setTitle("Bronco Centerpointe Dining");
		this.setBounds(100, 100, 550, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new WelcomeView();
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == this.buttonCreate) {
			new OrderView();
			dispose();
		} else if (event.getSource() == this.buttonOrders ) {
			new OrderHistory();
		}
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}
	
	

}
