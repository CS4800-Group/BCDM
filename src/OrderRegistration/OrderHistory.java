package OrderRegistration;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import JSP.WelcomeView;

@SuppressWarnings("serial")
public class OrderHistory extends JFrame implements ActionListener {
	private List<Receipt> receiptList;
	private Receipt receipt;
	private SessionFactory factory;
	private Session session;
	private JPanel orderHistoryPanel, revenuePanel;
	private JTextArea receiptView;
	private JScrollPane scroll;
	private JLabel lblTotal, lblOrders, lblRevenue, lblNumOrders;
	private JButton buttonBack;
	private double totalRevenue;
	
	public OrderHistory() {
		receiptList = new ArrayList<Receipt>();
		setReceipt(null);
		setTotalRevenue(0.0);

		// initialize JFrame components
		this.setTitle("Order Registration");
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		this.setBounds(100, 100, 800, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		
		// order history panel
		orderHistoryPanel = new JPanel();
		orderHistoryPanel.setPreferredSize(new Dimension(500, 500));
		orderHistoryPanel.setBackground(Color.lightGray);
		orderHistoryPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
		orderHistoryPanel.setBorder(new TitledBorder("Order History"));
		
		// order history panel
		revenuePanel = new JPanel();
		revenuePanel.setPreferredSize(new Dimension(300, 200));
		revenuePanel.setBackground(Color.lightGray);
		revenuePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
		revenuePanel.setBorder(new TitledBorder("Information"));
		
		// initialize button
		buttonBack = new JButton("Back");
		buttonBack.addActionListener(this);
		
		// initialize labels
		lblTotal = new JLabel("Total Revenue: ");
		lblOrders = new JLabel("Orders: ");
		lblRevenue = new JLabel();
		lblNumOrders = new JLabel();
		
		// receipt view text area
		receiptView = new JTextArea(20, 30);
		receiptView.setEditable(false);
		
		// vertical scroll bar
		scroll = new JScrollPane(receiptView);
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    
	    // add receipt view/scroll to panel
	    orderHistoryPanel.add(scroll);

	    displayOrderHistory();
	}
	
	public void displayOrderHistory() {
		addReceipts();
		calculateRevenue();
		
		lblRevenue.setText("$" + String.format("%.2f", totalRevenue));
		lblNumOrders.setText(Integer.toString(receiptList.size()));
		
		revenuePanel.add(lblTotal);
		revenuePanel.add(lblRevenue);
		revenuePanel.add(lblOrders);
		revenuePanel.add(lblNumOrders);
		
		// add panel to JFrame
	    this.add(orderHistoryPanel);
	    this.add(revenuePanel);
	    this.add(buttonBack);
	}
	
	public void addReceipts() {
		// configure session
		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Order.class)
				.addAnnotatedClass(Item.class).addAnnotatedClass(Receipt.class).addAnnotatedClass(Customer.class)
				.addAnnotatedClass(OrderHistory.class).buildSessionFactory();

		session = factory.getCurrentSession();
		session.beginTransaction();

		receiptList = loadAllData(Receipt.class, session);
		printReceipts();
	}
	
	// method to load data from table in database
	private static List<Receipt> loadAllData(Class<Receipt> type, Session session) {
	    CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<Receipt> criteria = builder.createQuery(type);
	    criteria.from(type);
	    List<Receipt> data = session.createQuery(criteria).getResultList();
	    
	    return data;
	 }
	
	public void printReceipts() {
		// prints receipts to receipt view
		for (int i = 0; i < receiptList.size(); i++) {
			receiptView.setText(receiptView.getText() + "\n" 
					+ receiptList.get(i).getDate() 
					+ "	" + receiptList.get(i).getOrder().getCustomerName() 
					+ "	$" + String.format("%.2f", receiptList.get(i).getTotalPrice()));
		}
		
	}
	
	public void calculateRevenue() {
		for (int i = 0; i < receiptList.size() - 1; i++) {
			totalRevenue = totalRevenue + receiptList.get(i).getTotalPrice();
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == buttonBack) {
			new WelcomeView();
			dispose();
		}	
	}

	public List<Receipt> getReceiptList() {
		return receiptList;
	}

	public void setReceiptList(List<Receipt> receiptList) {
		this.receiptList = receiptList;
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public String toString() {
		return "OrderHistory [receiptList=" + receiptList + "]";
	}

	public double getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(double totalRevenue) {
		this.totalRevenue = totalRevenue;
	}
}
