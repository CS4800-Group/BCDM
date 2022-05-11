package OrderRegistration;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="item_id")
	private int itemID;
	
	@ManyToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name="order_id")
	private Order order;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private double price;
	
	public Item() {

	}

	public Item(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "\nItemID: " + itemID + ", Dish: " + name + ", Price: " + price + "\n";
	}
}
