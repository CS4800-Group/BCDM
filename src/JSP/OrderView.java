package JSP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import OrderRegistration.Customer;
import OrderRegistration.Order;

@SuppressWarnings("serial")
public class OrderView extends JFrame implements ActionListener {
	private JLabel lblMenu, lblName, lblType, lblDate;
	private JLabel customerName, customerType, date;
	private JButton buttonPizza, buttonChicken, buttonFries,
	buttonSprite, buttonPepsi, buttonWater, buttonStudent, 
	buttonProfessor;
	private JTextField txtName, txtType;
	private JPanel menuPanel1, customerPanel, itemPanel, datePanel, 
	panel, panel2, panel3;
	private JRadioButton studentButton, professorButton;
	private ButtonGroup group;
	
	private Customer customer;
	private Order order;

	public OrderView() {
			this.initializeComponents();
			this.buildUI();	
		}

	private void initializeComponents() {

		// initialize labels
		lblMenu = new JLabel("Menu");
		lblMenu.setLayout(new FlowLayout());
		lblMenu.setFont(new Font("Arial", Font.PLAIN, 20));
		lblMenu.setBounds(175, 15, 50, 25);
		
		lblName = new JLabel("Name:   	");
		lblName.setFont(new Font("Arial", Font.PLAIN, 18));
		lblName.setLayout(null);
		lblName.setBounds(30, 30, 75, 25);
		
		lblType = new JLabel("Type:   	");
		lblType.setFont(new Font("Arial", Font.PLAIN, 18));
		lblType.setBounds(0, 0, 75, 75);
		
		lblDate = new JLabel("Date:	");
		lblDate.setFont(new Font("Arial", Font.PLAIN, 18));
		lblDate.setBounds(0, 0, 75, 75);
		
		// initialize text fields
		txtName = new JTextField(23);
		txtName.setLayout(null);
		txtName.setBounds(100, 30, 150, 30);
		
		/*
		customerName = new JLabel(customer.getName());
		customerType = new JLabel(customer.getType());
		date = new JLabel(order.getDate());
		*/

		// initialize buttons
		
		buttonPizza = new JButton("Pizza");
		buttonPizza.setLayout(new FlowLayout());
		buttonPizza.setFont(new Font("Arial", Font.PLAIN, 18));
		//buttonPizza.setBounds(25, 50, 100, 75);
		buttonPizza.addActionListener(this);
		
		buttonChicken = new JButton("Chicken");
		buttonChicken.setLayout(new FlowLayout());
		buttonChicken.setFont(new Font("Arial", Font.PLAIN, 18));
		//buttonChicken.setBounds(150, 50, 100, 75);
		buttonChicken.addActionListener(this);
		
		buttonFries = new JButton("Fries");
		buttonFries.setLayout(new FlowLayout());
		buttonFries.setFont(new Font("Arial", Font.PLAIN, 18));
		//buttonFries.setBounds(275, 50, 100, 75);
		buttonFries.addActionListener(this);
		
		buttonSprite = new JButton("Sprite");
		buttonSprite.setLayout(new FlowLayout());
		buttonSprite.setFont(new Font("Arial", Font.PLAIN, 18));
		buttonSprite.setBounds(25, 150, 100, 75);
		buttonSprite.addActionListener(this);
		
		buttonPepsi = new JButton("Pepsi");
		buttonPepsi.setLayout(new FlowLayout());
		buttonPepsi.setFont(new Font("Arial", Font.PLAIN, 18));
		buttonPepsi.setBounds(150, 150, 100, 75);
		buttonPepsi.addActionListener(this);
		
		buttonWater = new JButton("Water");
		buttonWater.setLayout(new FlowLayout());
		buttonWater.setFont(new Font("Arial", Font.PLAIN, 18));
		buttonWater.setBounds(275, 150, 100, 75);
		buttonWater.addActionListener(this);
		
		buttonStudent = new JButton("Student");
		buttonStudent.setLayout(new FlowLayout());
		buttonStudent.setFont(new Font("Arial", Font.PLAIN, 18));
		buttonStudent.setBounds(25, 75, 100, 40);
		buttonStudent.addActionListener(this);
		
		buttonProfessor = new JButton("Professor");
		buttonProfessor.setLayout(new FlowLayout());
		buttonProfessor.setFont(new Font("Arial", Font.PLAIN, 18));
		buttonProfessor.setBounds(150, 75, 100, 40);
		buttonProfessor.addActionListener(this);
		
		studentButton = new JRadioButton("Student");
		professorButton = new JRadioButton("Professor");
		
		group = new ButtonGroup();
		group.add(studentButton);
		group.add(professorButton);
		
		// initialize panels
		menuPanel1 = new JPanel();
		menuPanel1.setBackground(Color.red);
		menuPanel1.setLayout(new FlowLayout());
		menuPanel1.setBounds(0, 0, 400, 300);

		customerPanel = new JPanel();
		customerPanel.setBackground(Color.blue);
		customerPanel.setLayout(new FlowLayout());
		customerPanel.setBounds(0, 300, 400, 200);

		itemPanel = new JPanel();
		itemPanel.setBackground(Color.green);
		itemPanel.setLayout(new FlowLayout());
		itemPanel.setBounds(400, 0, 300, 300);
		
		datePanel = new JPanel();
		datePanel.setBackground(Color.gray);
		datePanel.setBounds(300, 0, 150, 150);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(300, 250));
		panel.setBackground(Color.lightGray);
		panel.setLayout(new FlowLayout());
		
		panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension(300, 250));
		panel2.setBackground(Color.darkGray);
		panel2.setLayout(new FlowLayout());
		
		panel3 = new JPanel();
		panel3.setPreferredSize(new Dimension(300, 250));
		panel3.setBackground(Color.green);
		panel3.setLayout(new FlowLayout());

	}

	private void buildUI() {

		/*
		// add to menu panel
		menuPanel1.add(lblMenu);
		menuPanel1.add(buttonPizza);
		menuPanel1.add(buttonChicken);
		menuPanel1.add(buttonFries);
		menuPanel1.add(buttonSprite);
		menuPanel1.add(buttonPepsi);
		menuPanel1.add(buttonWater);

		
		// add to customer panel
		customerPanel.add(lblName);
		customerPanel.add(txtName);
		customerPanel.add(buttonStudent);
		customerPanel.add(buttonProfessor);
		*/
		

		
		// add to button panel
	
		/*
		// add to date panel
		datePanel.add(this.lblDate);
		datePanel.add(this.date);
		*/
		
		/*
		// add to JFrame
		this.add(menuPanel1);
		this.add(customerPanel);
		this.add(itemPanel);
		// this.add(buttonPanel);
		 * 
		 */
		
		
		panel.add(new JButton("Pizza"));
		panel.add(new JButton("Chicken"));
		panel.add(new JButton("Fries"));
		panel.add(new JButton("Sprite"));
		panel.add(new JButton("Coke"));
		panel.add(new JButton("Water"));
		
		panel2.add(new JLabel("Name"));
		panel2.add(new JTextField(20));
		panel2.add(studentButton);
		panel2.add(professorButton);
		
		this.add(panel);
		this.add(panel2);
		// this.add(panel3);
		
		/*
		this.getContentPane().add(panel4, BorderLayout.BEFORE_FIRST_LINE);
		this.getContentPane().add(panel1, BorderLayout.CENTER, 1);
		this.getContentPane().add(panel2, BorderLayout.CENTER, 2);
		this.getContentPane().add(panel3, BorderLayout.SOUTH);
		*/
		
		// initialize JFrame components
		this.setTitle("Order Registration");
		this.setLayout(new FlowLayout());
		this.setBounds(100, 100, 800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		/*
		if (event.getSource() == this.buttonSubmit) {
			try {
				
				new OrderSuccessView(customer.getName());
				dispose();

			} catch (MessageException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		} else {
			this.txtName.setText("");
			this.txtType.setText("");
		}
		*/
	}
	
}
