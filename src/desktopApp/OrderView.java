package desktopApp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import orderRegistration.Customer;
import orderRegistration.Item;
import orderRegistration.Menu;
import orderRegistration.Order;
import orderRegistration.Receipt;

@SuppressWarnings("serial")
public class OrderView extends JFrame implements ActionListener {
	private JLabel lblName, lblSubtotal, 
			lblDiscount, lblTotal, lblCounter;
	private JButton buttonPizza, buttonChicken, buttonBurger, buttonSandwich, buttonFries,
			buttonCookie, buttonIceCream, buttonBeverage, buttonWater;
	private JButton buttonClear, buttonCheckout, buttonBack;
	private JTextField txtName;
	private JTextArea txtItem;
	private JPanel menuPanel, customerPanel, itemPanel, checkoutPanel;
	private JComboBox<String> comboBox;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem saveItem;
	private JScrollPane scroll;
	private SessionFactory factory;
	private Session session;
	private String customerList[] = { "Student", "Professor" };

	// OrderRegistration objects
	private Customer customer;
	private Order order;
	private Item item;
	private Menu menu;
	private Receipt receipt;
	private List<Item> itemsList;

	public OrderView() {
		menu = new Menu();
		itemsList = new ArrayList<Item>();
		
		// initialize JFrame components
		this.setTitle("Order Registration");
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
		this.setBounds(100, 100, 900, 900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);

		this.initializeComponents();
		this.buildUI();
	}

	private void initializeComponents() {
		// initialize panels
		
		// menu panel
		menuPanel = new JPanel();
		menuPanel.setPreferredSize(new Dimension(350, 350));
		menuPanel.setBackground(Color.lightGray);
		menuPanel.setLayout(new GridLayout(3, 3, 5, 5));
		menuPanel.setBorder(new TitledBorder("Menu"));

		// customer panel
		customerPanel = new JPanel();
		customerPanel.setPreferredSize(new Dimension(350, 350));
		customerPanel.setBackground(Color.lightGray);
		customerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		customerPanel.setBorder(new TitledBorder("Customer"));

		// item panel
		itemPanel = new JPanel();
		itemPanel.setPreferredSize(new Dimension(350, 350));
		itemPanel.setBackground(Color.lightGray);
		itemPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
		itemPanel.setBorder(new TitledBorder("Items"));
		
		// checkout panel
		checkoutPanel = new JPanel();
		checkoutPanel.setPreferredSize(new Dimension(350, 350));
		checkoutPanel.setBackground(Color.lightGray);
		checkoutPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 130, 30));
		checkoutPanel.setBorder(new TitledBorder("Checkout"));
		
		// initialize labels
		lblName = new JLabel("Name:");
		lblSubtotal = new JLabel("Subtotal: ");
		lblDiscount = new JLabel("Discount: ");
		lblTotal = new JLabel("Total:		");
		
		lblCounter = new JLabel("Counter");
		lblCounter.setForeground(Color.RED);
		
		//lblPrice = new JLabel("Price");
		
		// initialize text fields
		txtName = new JTextField(20);
		
		// initialize text area
		txtItem = new JTextArea(10, 20);
		txtItem.setEditable(false);
		// txtItem.setWrapStyleWord(true);
		
	    scroll = new JScrollPane(txtItem);
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		// initialize buttons
		
		// menu buttons
		buttonPizza = new JButton("Pizza");
		buttonPizza.addActionListener(this);
		
		buttonChicken = new JButton("Chicken");
		buttonChicken.addActionListener(this);
		
		buttonBurger = new JButton("Burger");
		buttonBurger.addActionListener(this);
		
		buttonSandwich = new JButton("Sandwich");
		buttonSandwich.addActionListener(this);
		
		buttonFries = new JButton("Fries");
		buttonFries.addActionListener(this);
		
		buttonCookie = new JButton("Cookie");
		buttonCookie.addActionListener(this);
		
		buttonIceCream = new JButton("Ice Cream");
		buttonIceCream.addActionListener(this);
		
		buttonBeverage = new JButton("Beverage");
		buttonBeverage.addActionListener(this);
		
		buttonWater = new JButton("Water");
		buttonWater.addActionListener(this);

		// drop-down menu
		comboBox = new JComboBox<String>(customerList);
		comboBox.addActionListener(this);
		
		// menu bar
		menuBar = new JMenuBar();
		
		// file tab
		fileMenu = new JMenu("File");	
		
		// save tab
		saveItem = new JMenuItem("Save");
		saveItem.addActionListener(this);
		
		// other buttons
		buttonClear = new JButton("Clear");
		buttonClear.addActionListener(this);
		
		buttonCheckout = new JButton("Checkout");
		buttonCheckout.addActionListener(this);
		
		buttonBack = new JButton("Back");
		buttonBack.addActionListener(this);
	}

	private void buildUI() {
		// add to menu panel
		menuPanel.add(buttonPizza);
		menuPanel.add(buttonChicken);
		menuPanel.add(buttonBurger);
		menuPanel.add(buttonSandwich);
		menuPanel.add(buttonFries);
		menuPanel.add(buttonCookie);
		menuPanel.add(buttonIceCream);
		menuPanel.add(buttonBeverage);
		menuPanel.add(buttonWater);
		
		// add to customer panel
		customerPanel.add(lblName);
		customerPanel.add(txtName);
		customerPanel.add(comboBox);
		customerPanel.add(buttonBack);
		
		// add to item panel
		itemPanel.add(scroll);
		itemPanel.add(buttonClear);
		itemPanel.add(buttonCheckout);
		
		// add to checkout panel
		checkoutPanel.add(lblCounter);
		checkoutPanel.add(lblSubtotal); 
		checkoutPanel.add(lblDiscount); 
		checkoutPanel.add(lblTotal);
		
		// add to menu bar
		fileMenu.add(saveItem);
		menuBar.add(fileMenu);
		
		// add to JFrame
		this.setJMenuBar(menuBar);
		this.add(menuPanel);
		this.add(itemPanel);
		this.add(customerPanel);
		this.add(checkoutPanel);			
	}
	
	public void actionPerformed(ActionEvent event) {
		// configure session
		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Order.class)
				.addAnnotatedClass(Item.class).addAnnotatedClass(Receipt.class).addAnnotatedClass(Customer.class)
				.buildSessionFactory();

		session = factory.getCurrentSession();
		session.beginTransaction();
				
		// get customer name from drop down list
		if (event.getSource() == comboBox) {
			customer = new Customer(txtName.getText(), (String) comboBox.getSelectedItem());
			session.save(customer);	
			order = new Order(customer, "counter");
			session.save(order);
		}
		
		// back button
		if (event.getSource() == buttonBack) {
			new WelcomeView();
			dispose();
		}
			
		// menu actions
		if (event.getSource() == buttonPizza) {
			txtItem.setText(txtItem.getText() + "\n $" + menu.getPizzaPrice() + "	" + menu.getPizza());
			item = new Item(menu.getPizza(), menu.getPizzaPrice());
			order.add(item);
			session.save(item);
			
		} else if (event.getSource() == buttonChicken) {
			txtItem.setText(txtItem.getText() + "\n $" + menu.getChickenPrice() + "	" + menu.getChicken());
			item = new Item(menu.getChicken(), menu.getChickenPrice());
			order.add(item);
			session.save(item);

		} else if (event.getSource() == buttonBurger) {
			txtItem.setText(txtItem.getText() + "\n $" + menu.getBurgerPrice() + "	" + menu.getBurger());
			item = new Item(menu.getBurger(), menu.getBurgerPrice());
			order.add(item);
			session.save(item);
			
		} else if (event.getSource() == buttonSandwich) {
			txtItem.setText(txtItem.getText() + "\n $" + menu.getSandwichPrice() + "	" + menu.getSandwich());
			item = new Item(menu.getSandwich(), menu.getSandwichPrice());
			order.add(item);
			session.save(item);
			
		} else if (event.getSource() == buttonFries) {
			txtItem.setText(txtItem.getText() + "\n $" + menu.getFriesPrice() + "	" + menu.getFries());
			item = new Item(menu.getFries(), menu.getFriesPrice());
			order.add(item);
			session.save(item);
			
		} else if (event.getSource() == buttonCookie) {
			txtItem.setText(txtItem.getText() + "\n $" + menu.getCookiePrice() + "	" + menu.getCookie());
			item = new Item(menu.getCookie(), menu.getCookiePrice());
			order.add(item);
			session.save(item);

		} else if (event.getSource() == buttonIceCream) {
			txtItem.setText(txtItem.getText() + "\n $" + menu.getIceCreamPrice() + "	" + menu.getIceCream());
			item = new Item(menu.getIceCream(), menu.getIceCreamPrice());
			order.add(item);
			session.save(item);
			
		} else if (event.getSource() == buttonBeverage) {
			txtItem.setText(txtItem.getText() + "\n $" + menu.getBeveragePrice() + "	" + menu.getBeverage());
			item = new Item(menu.getBeverage(), menu.getBeveragePrice());
			order.add(item);
			session.save(item);
			
		} else if (event.getSource() == buttonWater) {
			txtItem.setText(txtItem.getText() + "\n $" + menu.getWaterPrice() + "	" + menu.getWater());
			item = new Item(menu.getWater(), menu.getWaterPrice());
			order.add(item);
			session.save(item);		
		}
		
		// item panel actions
		if (event.getSource() == buttonClear) {
			txtItem.setText("");
			itemsList.clear();
		}
		
		if (event.getSource() == buttonCheckout) {
			// create receipt
			receipt = new Receipt(order);
			
			lblSubtotal.setText("Subtotal:		" + String.format("%.2f", receipt.getSubtotal()));
			lblDiscount.setText("Discount:		" + String.format("%.2f", receipt.getDiscount()));
			lblTotal.setText("Total:		" + String.format("%.2f", receipt.getTotalPrice()));
			
			session.save(receipt);
			order.setTotalPrice(receipt.getTotalPrice());
			new ReceiptView(receipt);
		}
		
		session.getTransaction().commit();			
	}	
}
