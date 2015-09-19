/**
 * 
 */
package com.scotmatson.banking;

import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ATM implements Scannable<Card> {
	
	// ATM attributes.
	Scanner in;
	private int userInput;
	private Bank bank;
	private int maxWithdrawal;
	private boolean activeSession;
	
	// Stored card attributes.
	private int bankID;
	private int customerID;
	private int accountID;
	private Date cardExpiration;
	private int pin;
	
	/**
	 * Constructor method.
	 * 
	 * @param bank
	 * @param maxWithdrawal
	 */
	public ATM (Bank bank, int maxWithdrawal)
	{
		in = new Scanner(System.in);
		this.bank = bank;
		this.maxWithdrawal = maxWithdrawal;
		this.activeSession = false;
	}
	
	/**
	 * Scan and store card information.
	 * 
	 * @param card
	 */
	@Override
	public void scan(Card card) {
		int cardNumber = card.getNumber();
		this.accountID = cardNumber % 100;
		cardNumber /= 100;
		
		this.customerID = cardNumber % 100;
		cardNumber /= 100;
		
		this.bankID = cardNumber;
		
		this.cardExpiration = card.getExpiration();
		
		System.out.println("Scanned");
	}	
	
	/**
	 * Validates card and user credentials.
	 */
	public boolean validateCard()
	{
		boolean isValid = false;
		System.out.println(bank.getID());
		System.out.println(this.bankID);
		
		// Validate Bank Affiliation.
		if (bank.getID() == this.bankID)
		{	
			// Validate card expiration date.
			Calendar calendar = Calendar.getInstance();
			Date now = calendar.getTime();	
			if (now.before(this.cardExpiration))
			{
				// Validate user credentials.
				int pin = getCustomerPIN();
				isValid = bank.authorizeAccountAcccess(customerID, pin);
			}
		}
		return isValid;
	}
	
	/**
	 * Initiates account transaction.
	 */
	public void beginTransaction() 
	{
		activeSession = true;
		Account account = bank.getCustomerAccount(customerID, pin); 
		while (activeSession)
		{
			userInput = printATMMenu();

			switch (userInput)
			{
				case 1:
					makeDeposit();
					break;
				case 2:
					makeWithdrawal();
					break;
				case 3:
					viewBalance();
					break;
				case 4:
					endTransaction();
					break;
			}
		}
	}
	
	/**
	 * Interface for entering the
	 * customer's PIN.
	 * 
	 * @return
	 */
	public int getCustomerPIN()
	{
		System.out.print("Enter your PIN: ");
		int pin = -1;
		try 
		{
			pin = in.nextInt();
		}
		catch(InputMismatchException e)
		{
		    	System.out.println("Invalid user entry.");
		    	// Flush the Scanner
		    	in.next();
		}
		return pin;
	}
	
	/**
	 * Displays ATM menu.
	 * 
	 * @return
	 */
	public int printATMMenu()
	{
		System.out.println("What would you like to do?");
		System.out.println("1) Make a deposit.");
		System.out.println("2) Make a withdrawal.");
		System.out.println("3) View account balance.");
		System.out.println("4) Return card.");
		
		return enterValue();
	}
	
	/**
	 * Flushes stored values from ATM memory
	 * preventing further user interaction.
	 */
	public void endTransaction()
	{
		userInput 		= -1;
		bankID 			= -1;
		customerID 		= -1;
		accountID 		= -1;
		cardExpiration  = null;
		activeSession = false;
		
		System.out.println("End Transaction.");
		System.out.println("Your card has been returned.");
	} 
	
	/**
	 * 
	 * @param amount
	 */
	public void makeDeposit()
	{
		System.out.println("Enter amount to be deposted.");
		int amount = enterValue();
		bank.depositFunds(this.customerID, this.pin, amount);
	}
	
	/**
	 * 
	 * @return
	 */
	public int enterValue()
	{
		try
		{
			userInput = in.nextInt();
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
	 * @param amount
	 */
	public void makeWithdrawal()
	{
		System.out.println("How much would you like to withdrawal?");
		int amount = enterValue();
		if (amount > 0 && amount < maxWithdrawal)
		{
			bank.withdrawalFunds(this.customerID, this.pin, amount);
		}
		else
		{
			System.out.println("Out of range.");
		}
	}
	
	public void viewBalance()
	{
		int balance = bank.displayAccountBalance(customerID, pin);
		System.out.println(balance);
	}
}
