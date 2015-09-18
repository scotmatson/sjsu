/**
 * 
 */
package com.scotmatson.banking;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ATMSimulator
{
	// System Codes
	static final int UNSET_INPUT    = 0;
	static final int INVALID_INPUT  = -1;
	static final int CARD_A00       = 1;			// Bank A : Valid
	static final int CARD_B00       = 2;			// Bank B : Valid
	static final int CARD_C00       = 3;			// Bank ? : Expired
	static final int EXIT           = 4;
	static final int VALID_OPTIONS  = 4;
	
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
		
		System.out.println("Please enter your last name.");
		lName = in.nextLine();
		
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
		System.out.println("through an ATM using your card and a user-defined PIN");
	    System.out.println("1) Card A (member of Bank A)");
	    System.out.println("2) Card B (member of Bank B)");
	    System.out.println("3) Expired Card");
	    System.out.println("4) Exit");
	    	    
	    try 
	    {
	    	userInput = in.nextInt();
	    	
		    if (userInput <= UNSET_INPUT || userInput > VALID_OPTIONS)
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
	    
	    try
	    {
	    	userInput = in.nextInt();
	    	
	    	if (userInput <= UNSET_INPUT || userInput > VALID_OPTIONS)
	    	{
	    		System.out.println("Invalid user selection.");
	    		userInput = INVALID_INPUT;
	    	}
	    }
	    catch(InputMismatchException e)
	    {
	    	System.out.println("Invalid user entry.");
	    	// Flush the Scanner
	    	in.nextLine();
	    }
	    
		return -1;
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
		Bank bankA = new Bank("Bank A", 000);
		Bank bankB = new Bank("Bank B", 111);
		
		// Assign person.
		Person person = personBuilder();
		
		// Initialize variables for later assignment.
		Customer customer;
		Account account;
		Card card;
		
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
			System.out.println("THREE");
//			Card cardC = new Card();
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