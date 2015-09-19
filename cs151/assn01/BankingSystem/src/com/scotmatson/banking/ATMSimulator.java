/**

   COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved.

   Bootstraps together classes in the BankingSystem package
   to simulate an ATM.

   Solves CS151 homework assignment #1

   @author Scot Matson

   @version 1.01 2015/9/18

*/
package com.scotmatson.banking;

import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ATMSimulator
{
	// System codes
	static final int UNSET_INPUT    = 0;
	static final int INVALID_INPUT  = -1;
	
	// System state
	static final int PERSON_BUILDER = 0;
	static final int CARD_SELECTOR = 1;
	static final int ATM_SELECTOR = 2;
	static final int EXIT = 3;
	static int currentState;
	
	// User IO
	static Scanner in = new Scanner(System.in);
	static int userInput = UNSET_INPUT;
	
	// Application components
	static Person person;
	static Customer customer;
	static Bank bankA;
	static Bank bankB;
	static Account account;
	static Card card;
	static ATM atm;
					 		
	/**
	 * Displays the application title and introduction text.
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
        System.out.println("Press the ENTER key to begin.");		
		
		pressAnyKeyToContinue();
	}
	
	/**
	 * Generates a person.
	 */
	public static void buildPerson()
	{
		String fName;
		String lName;
		
		System.out.println("Please enter your first name.");
		fName = in.next();
		System.out.println();
		
		System.out.println("Please enter your last name.");
		lName = in.next();
		System.out.println();
		
		person = new Person(fName, lName);
		currentState = CARD_SELECTOR;
	}
	
	/**
	 * Methods for selecting an ATM card to be
	 * used with an ATM.
	 */
	public static void selectCard()
	{
		int availableOptions = selectCardMenu();
	    
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
	    
	    generateCard(userInput);

	}
	
	/**
	 * Displays the card selection menu.
	 * 
	 * @return the number of menu options.
	 */
	public static int selectCardMenu()
	{
		System.out.println("Please select a debit card from the list below.");
		System.out.println("Upon selecting a card you will be made a customer");
		System.out.println("of either bank A or bank B depending on your selection.");
		System.out.println("As a new customer you will be granted access to a checking");
		System.out.println("account with a balance of $100 which may be accessed");
		System.out.println("through an ATM using your card and a user-defined PIN\n");
	    
		System.out.println("1) Card A (member of Bank A)");
	    System.out.println("2) Card B (member of Bank B)");
	    System.out.println("3) Card C (expired member of Bank A)");
	    System.out.println("4) New customer");
	    System.out.println("5) Exit");
		
	    int numberOfOptions = 5;
		return numberOfOptions;
	}
	
	/**
	 * Creates a new bank customer with an ATM card.
	 * 
	 * @param userInput the customer's input.
	 */
	public static void generateCard(int userInput)
	{
		switch (userInput)
		{
		case 1:
			customer = bankA.addCustomer(person);
			bankA.addCustomerAccount(customer.getID(), 1234);
			account = bankA.getCustomerAccount(customer.getID(), 1234);
			card = new Card(bankA, customer, account);
			currentState = ATM_SELECTOR;
			break;
		case 2:
			customer = bankB.addCustomer(person);
			bankB.addCustomerAccount(customer.getID(), 1234);
			account = bankB.getCustomerAccount(customer.getID(), 1234);
			card = new Card(bankB, customer, account);
			currentState = ATM_SELECTOR;
			break;
		case 3:
			customer = bankA.addCustomer(person);
			bankA.addCustomerAccount(customer.getID(), 1234);
			account = bankA.getCustomerAccount(customer.getID(), 1234);
			
			// Creating an expired card for testing.
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.YEAR, -1);
			Date expiration = cal.getTime();
			card = new Card(bankA, customer, account, expiration);
			currentState = ATM_SELECTOR;
			break;
		case 4:
			currentState = PERSON_BUILDER;
			break;
		case 5:
			currentState = EXIT;
			break;
		}
	}
	
	/**
	 * Selects an ATM to be used with an existing ATM card.
	 */
	public static void selectATM()
	{
		int availableOptions = selectATMMenu();
	    
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
	    
	    generateATM(userInput);
	}
	
	/**
	 * Displays the ATM selection menu.
	 */
	public static int selectATMMenu()
	{
		System.out.println("Please select an ATM from the following list:");
	    System.out.println("1) ATM A0");
	    System.out.println("2) ATM A1");
	    System.out.println("3) ATM B0");
	    System.out.println("4) ATM B1");
	    System.out.println("5) New card");
	    System.out.println("6) Exit");
	    
	    int numberOfOptions = 6;
	    return numberOfOptions;
	}
	
	/**
	 * Creates an ATM machine and 'swipes' an
	 * existing ATM card.
	 * 
	 * @param userInput the user selection.
	 */
	public static void generateATM(int userInput)
	{
		boolean cardIsValid = false;
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
			case 5:
				currentState = CARD_SELECTOR; 
				break;
			case 6:
				currentState = EXIT;
				break;
		}
	}
		
	/**
	 * Halts an application until input is received.
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
	 * Launches the application.
	 */
	static public void run()
	{				
		printApplicationHeader();
		
		// Assign Banks.
		bankA = new Bank("Bank A", 111);
		bankB = new Bank("Bank B", 222);
		
		// Active state machine.
		while (currentState != EXIT)
		{
			switch(currentState)
			{
				case PERSON_BUILDER:
					buildPerson();
					break;
				case CARD_SELECTOR:
					// Select card
					selectCard();
					break;
				case ATM_SELECTOR:
					selectATM();
					break;
			}
		}
		
		quit();
	}
	
	/**
	 * Terminates the application.
	 */
	static public void quit()
	{
		System.out.println("Terminating Simulation.");
		System.exit(0);
	}
	
	/**
	 * Main Method. Entry point for JVM.
	 * 
	 * @param args user-defined arguments.
	 */
	public static void main(String[] args) 
	{
		ATMSimulator.run();
	}
}