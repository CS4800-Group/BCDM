package JSP;

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

import OrderRegistration.Receipt;

@SuppressWarnings("serial")
public class ReceiptView extends JFrame implements ActionListener{

	public ReceiptView(Receipt receipt) {
		// initialize JFrame components
		this.setTitle("Order Receipt");
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0 ,30));
		this.setBounds(100, 100, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		
		printReceipt(receipt);
	}
	
	public void printReceipt(Receipt receipt) {
		JPanel receiptPanel = new JPanel();
		receiptPanel.setPreferredSize(new Dimension(400, 400));
		receiptPanel.setBackground(Color.lightGray);
		receiptPanel.setLayout(new FlowLayout());
		
		JTextArea receiptView = new JTextArea(20, 25);
		receiptView.setEditable(false);
		
		JScrollPane scroll = new JScrollPane(receiptView);
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    
	    receiptView.setText(receipt.toString());
	    receiptPanel.add(scroll);
	    this.add(receiptPanel);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
