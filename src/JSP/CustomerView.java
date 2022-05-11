package JSP;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import OrderRegistration.Customer;

@SuppressWarnings("serial")
public class CustomerView extends JFrame implements ActionListener {

	private JButton buttonCreate, buttonOrders, buttonManagement;
	private JPanel panel1, panel2, panel3;

	public CustomerView() {
			this.initializeComponents();
			this.buildUI();
		}

	private void initializeComponents() {
		this.buttonCreate = new JButton("Create Order");
		this.buttonCreate.addActionListener(this);

		this.buttonOrders = new JButton("Order History");
		this.buttonOrders.addActionListener(this);
		
		this.buttonManagement = new JButton("Management");
		this.buttonManagement.addActionListener(this);

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
		this.panel3.add(this.buttonManagement);
		
		this.getContentPane().add(panel1, BorderLayout.NORTH);
		this.getContentPane().add(panel2, BorderLayout.CENTER);
		this.getContentPane().add(panel3, BorderLayout.SOUTH);

		this.setTitle("Bronco Centerpointe Dining");
		this.setBounds(350, 140, 550, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new CustomerView();
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == this.buttonCreate) {
			try {

				// Customer customer = new Customer(txtName.getText(), txtType.getText());
				
				new OrderView();
				dispose();

			} catch (MessageException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
	}

}
