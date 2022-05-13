package desktopApp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import orderRegistration.Receipt;

@SuppressWarnings("serial")
public class ReceiptView extends JFrame implements ActionListener{
	private Receipt receipt;
	private JPanel receiptPanel;
	private JTextArea receiptView;
	private JScrollPane scroll;	

	public ReceiptView(Receipt receipt) {
		setReceipt(receipt);
		
		// initialize JFrame components
		this.setTitle("Order Receipt");
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0 ,30));
		this.setBounds(1050, 200, 500, 500);
		//this.setDefaultCloseOperation();
		this.setResizable(false);
		this.setVisible(true);
		
		printReceipt();
	}
	
	public void printReceipt() {
		receiptPanel = new JPanel();
		receiptPanel.setPreferredSize(new Dimension(400, 400));
		receiptPanel.setBackground(Color.lightGray);
		receiptPanel.setLayout(new FlowLayout());
		
		receiptView = new JTextArea(20, 25);
		receiptView.setEditable(false);
		
		scroll = new JScrollPane(receiptView);
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    
	    receiptView.setText(this.receipt.toString());
	    receiptPanel.add(scroll);
	    this.add(receiptPanel);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}
	
	
	
}
