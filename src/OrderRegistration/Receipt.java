package orderRegistration;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="receipt")
public class Receipt {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="receipt_id")
	private int receiptID;
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="order_id")
	private Order order;
	
	@Column(name="date")
	private String date;
	
	@Column(name="status")
	private String status;

	@Column(name="total")
	private double totalPrice;
	
	@Column(name="discount")
	private double discount;
	
	@Column(name="subtotal")
	private double subtotal;
	
	public Receipt() {
		
	}
	
	public Receipt(Order order) {
		setOrder(order);
		setDate(order.getDate());
		setStatus(order.getStatus());
		setSubtotal(order.getTotalPrice());
		setDiscount(subtotal * order.getDiscount());
		setTotalPrice(subtotal - discount);
	}

	public int getReceiptID() {
		return receiptID;
	}

	public void setReceiptID(int receiptID) {
		this.receiptID = receiptID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getSubtotal() {
		return subtotal;
	}
	
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "\n--- Receipt ---" + "\nReceipt ID: " + receiptID + order + "\nSubtotal: " 
				+ String.format("%.2f", subtotal) + "\nDiscount: " + String.format("%.2f", discount) 
				+ "\nTotal Price: " + String.format("%.2f", totalPrice)+ "\n";
	}

}
