package com.scotmatson.testing;
import com.scotmatson.banking.*;

public class BankTester {

	public static void main(String[] args)
	{
		System.out.println("*** Instantiating Objects ***");
		System.out.println("Instantiating Bank.");
		Bank bank = new Bank("Bank", 0000);
		
		System.out.println("Instantiating Person.");
		Person person = new Person("Scot", "Matson");
		
		System.out.println("Instantiating Customer.");
		Customer customer = bank.addCustomer(person);
		
		System.out.println("Instantiating Account.");
		int customerID = customer.getID();
		int pin = 1234;
		
		bank.addCustomerAccount(customerID, pin);
		Account account = bank.getCustomerAccount(customerID, pin);
		System.out.println();
		
		System.out.println("*** TESTING RESULTS ***");
		System.out.println("Get Bank info");
		System.out.println(bank.getName());
		System.out.println(bank.getID());
		System.out.println();
		
		System.out.println("Get Person info.");
		System.out.println(person.getFirstName());
		System.out.println(person.getLastName());
		System.out.println();
		
		System.out.println("Get Customer info.");
		System.out.println(customer.getFirstName());
		System.out.println(customer.getLastName());
		System.out.println(customer.getID());
		System.out.println();
		
		System.out.println("Get Account info.");
		System.out.println(account.getID());
		System.out.println(account.getType());
		System.out.println(account.getBalance());	
	}
}
