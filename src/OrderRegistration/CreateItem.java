package OrderRegistration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateItem {
	public static void main(String[] args) {
		
		// Note: add all annotated classes
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Order.class).addAnnotatedClass(Item.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		// start a transaction
		session.beginTransaction();
		
		// get the order from database
		int id = 3;
		Order tempOrder = session.get(Order.class, id);

		// create some items
		Item tempItems1 = new Item("Chicken", 7.99);
		Item tempItems2 = new Item("Fries", 3.99);
		
		
		// add items to Order
		tempOrder.add(tempItems1);
		tempOrder.add(tempItems2);
		
		
		// save the items
		session.save(tempItems1);
		session.save(tempItems2);
		
		// commit transaction
		session.getTransaction().commit();
		
		System.out.println(tempOrder);
		System.out.println("Finished!");
		
		System.out.println("Items: " + tempOrder.getItems());
		
	}
}
