/**
 * 
 */
package com.scotmatson.banking;

import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ATMSimulator
{
	// System Codes
	static final int UNSET_INPUT    = 0;
	static final int INVALID_INPUT  = -1;
	static final int EXIT           = 10;
	
	static Scanner in = new Scanner(System.in);
	static int userInput = UNSET_INPUT;
					 		
	/**
	 * 
	 */
	public static void printApplicationHeader()
	{
		System.out.println("###################################################");
	    System.out.println("#                                                 #");
		System.out.println("#            Welcome to Scot Matson's             #");			
		System.out.println("#          	   ** SIM ATM **                  #");
		System.out.println("#                                                 #");
		System.out.println("###################################################\n");

		System.out.println("SIM ATM is an interactive program which simulates");
        System.out.println("the basic functions of an ATM machine.\n");
        System.out.println("To continue, press the ENTER key.");		
		
		pressAnyKeyToContinue();
	}
	
	/**
	 * 
	 * @return
	 */
	public static Person personBuilder()
	{
		String fName;
		String lName;
		
		System.out.println("Please enter your first name.");
		fName = in.nextLine();
		System.out.println();
		
		System.out.println("Please enter your last name.");
		lName = in.nextLine();
		System.out.println();
		
		return new Person(fName, lName);
	}
	
	/**
	 * 
	 */
	public static int printCardSelectionMenu()
	{
		System.out.println("Please select a debit card from the list below.");
		System.out.println("Upon selecting a card you will be made a customer");
		System.out.println("of either bank A or bank B depending on your selection.");
		System.out.println("As a new customer you will be granted access to a checking");
		System.out.println("account with a balance of $100 which may be accessed");
		System.out.println("through an ATM using your card and a user-defined PIN\n");
	    
		System.out.println("1) Card A (member of Bank A)");
	    System.out.println("2) Card B (member of Bank B)");
	    System.out.println("3) Expired Card");
	    System.out.println("4) Exit");
		int availableOptions = 4;	    	    
	    
	    try 
	    {
	    	userInput = in.nextInt();
	    	
		    if (userInput <= UNSET_INPUT || userInput > availableOptions)
		    {
		    	System.out.println("Invalid user selection.");
		    	userInput = INVALID_INPUT;
		    }
	    }
	    catch (InputMismatchException e)
	    {
	    	System.out.println("Invalid user entry.");
	    	// Flush the Scanner.
	    	in.nextLine();
	    }
	    
	    return userInput;
	}
	
	public static int printATMSelectionMenu()
	{
		System.out.println("Please select an ATM from the following list:");
		
	    System.out.println("1) ATM A0");
	    System.out.println("2) ATM A1");
	    System.out.println("3) ATM B0");
	    System.out.println("4) ATM B1");
	    int availableOptions = 4;
	    
	    try
	    {
	    	userInput = in.nextInt();
	    	
	    	if (userInput <= UNSET_INPUT || userInput > availableOptions)
	    	{
	    		System.out.println("Invalid user selection.");
	    		userInput = INVALID_INPUT;
	    	}
	    }
	    catch(InputMismatchException e)
	    {
	    	System.out.println("Invalid user entry.");
	    	// Flush the Scanner
	    	in.next();
	    }
	    
		return userInput;
	}
		
	/**
	 * 
	 */
	public static void pressAnyKeyToContinue()
	{
		try
		{
			System.in.read();
		}		
		catch(Exception e){}
	}
			
	/**
	 * 
	 */
	static public void run()
	{		
		// Assign Banks.
		Bank bankA = new Bank("Bank A", 111);
		Bank bankB = new Bank("Bank B", 222);
		
		// Assign person.
		Person person = personBuilder();
		
		// Initialize variables for later assignment.
		Customer customer = null;
		Account account = null;
		Card card = null;
		
		// Select card
		userInput = printCardSelectionMenu();
		
		switch (userInput)
		{
		case 1:
			System.out.println("ONE");
			customer = bankA.addCustomer(person);
			bankA.addCustomerAccount(customer.getID(), 1234);
			account = bankA.getCustomerAccount(customer.getID(), 1234);
			card = new Card(bankA, customer, account);
			break;
		case 2:
			System.out.println("TWO");
			customer = bankB.addCustomer(person);
			bankB.addCustomerAccount(customer.getID(), 1234);
			account = bankB.getCustomerAccount(customer.getID(), 1234);
			card = new Card(bankB, customer, account);
			break;
		case 3:
			System.out.println("ONE");
			customer = bankA.addCustomer(person);
			bankA.addCustomerAccount(customer.getID(), 1234);
			account = bankA.getCustomerAccount(customer.getID(), 1234);
			
			// Creating an expired card for testing.
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.YEAR, -1);
			Date expiration = cal.getTime();
			card = new Card(bankA, customer, account, expiration);
			break;
		}
		
		userInput = printATMSelectionMenu();
		
		// Initialize ATM for later assignment
		ATM atm;
		boolean cardIsValid = false;
		
		// 4 different ATM's to choose from,
		// 2 per bank.
		switch(userInput)
		{
			case 1:
				atm = new ATM(bankA, 200);
				atm.scan(card);
				cardIsValid = atm.validateCard();
				if (cardIsValid) {
					atm.beginTransaction();
				}
				break;
			case 2:
				atm = new ATM(bankA, 200);
				atm.scan(card);
				cardIsValid = atm.validateCard();
				if (cardIsValid) {
					atm.beginTransaction();
				}
				break;
			case 3:
				atm = new ATM(bankB, 200);
				atm.scan(card);
				cardIsValid = atm.validateCard();
				if (cardIsValid) 
				{
					atm.beginTransaction();
				}
				break;
			case 4:
				atm = new ATM(bankB, 200);
				atm.scan(card);
				cardIsValid = atm.validateCard();
				if (cardIsValid) {
					atm.beginTransaction();
				}
				break;
		}
	}
	
	static public void launch()
	{
		printApplicationHeader();
		
		while (userInput != EXIT) {
			run();
		}
		
		if (userInput == EXIT)
		{
			quit();
		}
	}
	
	/**
	 * 
	 */
	static public void quit()
	{
		System.exit(0);
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		ATMSimulator.launch();
	}
}