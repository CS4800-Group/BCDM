package OrderRegistration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
	private int orderID;
	
	@OneToMany(mappedBy="order", cascade={CascadeType.PERSIST})
	private List<Item> items;
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="customer_id")
	private Customer customer;

	@Column(name="customer")
	private String customerName;
	
	@Column(name="total")
	private double totalPrice;
	
	@Column(name="date")
	private String date;

	@Column(name="status")
	private String status;
	
	@Column(name="discount")
	private double discount;

	public Order() {
		
	}

	public Order(Customer customer, String status) {
		items = new ArrayList<>();
		setCustomer(customer);
		setCustomerName(customer.getName());
		setStatus(status);
		calculateDiscount(customer);
		setDate();
	}
	
	// add convenience methods for bidirectional relationship
	
	public void add(Item tempItem) {
		if (items == null) {
			items = new ArrayList<>();
		}
		
		items.add(tempItem);
		totalPrice = totalPrice + tempItem.getPrice();
		tempItem.setOrder(this);
	}
	
	public void calculateDiscount(Customer customer) {
		if (customer.getType().equalsIgnoreCase("student")) {
			setDiscount(0.5);
		} else if (customer.getType().equalsIgnoreCase("professor")) {
			setDiscount(0.25);
		}
	}
	
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double price) {
		this.totalPrice = price;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		date = dtf.format(now);
	}

	@Override
	public String toString() {
		return "\nOrderID: " + orderID + "\nDate: " + date + "\nCustomer: " 
				+ customerName + "\nType: " + customer.getType() 
				+ "\nStatus: " + status + "\nItems: \n" + items;
	}
	
}
