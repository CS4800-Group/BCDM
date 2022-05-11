package OrderRegistration;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateOrderDemo {
	public static void main(String[] args) {
		String welcomeMsg = "--- Create Order ----";
		String customerMsg = "Enter customer name: ";
		String customerMsg2 = "Enter customer type: ";
		String statusMsg = "Enter status";
		String itemMsg = "Enter item: ";
		String priceMsg = "Enter price: ";
		String addMoreMsg = "Enter add more items? (y/n)";
		String name;
		String type;
		String status;
		String item;
		String choice;
		double price;
		Scanner input = new Scanner(System.in);

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Order.class).addAnnotatedClass(Item.class)
				.addAnnotatedClass(Receipt.class).addAnnotatedClass(Customer.class).buildSessionFactory();
		
		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println(welcomeMsg);
			System.out.println(customerMsg);
			name = input.next();
			
			System.out.println(customerMsg2);
			type = input.next();
			
			// --- Create customer ---
			Customer newCustomer = new Customer(name, type);
			session.save(newCustomer);
			
			System.out.println(statusMsg);
			status = input.next();
			
			// --- Create Order ----
			Order newOrder = new Order(newCustomer, status);
			session.save(newOrder);
			
			do {
				// --- Create item ---
				System.out.println(itemMsg);
				item = input.next();
				
				System.out.println(priceMsg);
				price = input.nextDouble();
				
				Item tempItem = new Item(item, price);
				
				// add items to Order
				newOrder.add(tempItem);
				
				// save the items
				session.save(tempItem);
				
				System.out.println(addMoreMsg);
				choice = input.next();
	
			} while (!choice.equals("n"));
			
			// create receipt
			Receipt receipt = new Receipt(newOrder);
			
			// save receipt
			session.save(receipt);
			
			// System.out.println(newOrder);
			System.out.println(receipt);

			session.getTransaction().commit();
			
			System.out.println("Finished!");
			
			input.close();
			
		} finally {
			factory.close();
		}
	}
}
