/**
 * 
 */
package com.scotmatson.banking;

import java.util.Scanner;

public class ATM implements Scannable<Card> {
	
	private int bankAffiliation;
	private int maxWithdrawal; // Although - never runs out of cash.
	private Card scannedCard;
	
	public ATM (int bankAffiliation, int maxWithdrawal)
	{
		this.bankAffiliation = bankAffiliation;
		this.maxWithdrawal = maxWithdrawal;
	}
	
	/**
	 * 
	 */
	@Override
	public void scan(Card card) {
		this.scannedCard = card;
	}	
	
	/**
	 * 
	 */
	public void validateCard()
	{
		
	}
	
	/**
	 * 
	 */
	public void beginTransaction() 
	{
		
	}
	
	/**
	 * 
	 */
	public void endTransaction()
	{
		
	}
	
	/**
	 * 
	 */
	public void makeDeposit()
	{
		
	}
	
	/**
	 * 
	 */
	public void makeWithdrawal()
	{
		
	}
		// Should this application start in a Tester class instead?
		// Since this simulations an ATM, we assume the information must already exist.
		// The ATM is enforcing the rules
		// The bank set the rules for the ATM to follow
		// The card is the key to use the ATM
		
		// Menu
			// Choose from 2 banks
			// 4 ATM
			// Different customers?
			
		
		// May need Error Codes
			// Error types
			//
			// Expired Card
			// Invalid Input
			// Invalid amount
			// Invalid card number
		
		// Customers may open accounts in bank a, bank b, or both
}
