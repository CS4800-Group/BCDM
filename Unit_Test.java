package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import OrderRegistration.Customer;
import OrderRegistration.Item;
import OrderRegistration.Order;
import OrderRegistration.Receipt;

public class Unit_Test {
	
	@Test
	public void test1() {
		Customer student = new Customer("John", "student");
		Order order1 = new Order(student, "counter");
		order1.calculateDiscount(student);
		double discount = order1.getDiscount();
		assertEquals("Passed", 0.5, discount);
	}
	
	@Test
	public void test2() {
		Customer professor = new Customer("Hugh", "professor");
		Order order2 = new Order(professor, "counter");
		order2.calculateDiscount(professor);
		double discount = order2.getDiscount();
		assertEquals("Passed", 0.25, discount);
	}
	
	@Test
	public void test3() {
		String status = "counter";
		Customer student = new Customer("Hugh", "student");
		Order order = new Order(student, status);
		String testStatus = order.getStatus();
		assertEquals("Passed", status, testStatus);
	}
	
	@Test
	public void test4() {
		double price = 10.00;
		Customer student = new Customer("John", "student");
		Order order1 = new Order(student, "counter");
		Item tempItem = new Item("Pizza", 10.00);
		order1.add(tempItem);
		double testprice = order1.getTotalPrice();
		assertEquals("Passed", testprice, price);
	}
	
	@Test
	public void test5() {
		Customer student = new Customer("John", "student");
		Order order1 = new Order(student, "counter");
		Item tempItem = new Item("Pizza", 10.00);
		order1.add(tempItem);
		Receipt receipt = new Receipt(order1);
		
		String orderDate = order1.getDate();
		String receiptDate = receipt.getDate();
		
		assertEquals("Passed", orderDate, receiptDate);
	}
	
	@Test
	public void test6() {
		Customer student = new Customer("John", "student");
		Order order1 = new Order(student, "counter");
		Item tempItem = new Item("Pizza", 10.00);
		order1.add(tempItem);
		Receipt receipt = new Receipt(order1);
		
		String printReceipt = "\n--- Receipt ---" + "\nReceipt ID: 11\nSubtotal: 10.00" 
				+ "\nDiscount: 0.5" + "\nTotal Price: 5.00\n";
		String testReceipt = receipt.toString();
		
		assertEquals("Passed", printReceipt, testReceipt);
	}
}
