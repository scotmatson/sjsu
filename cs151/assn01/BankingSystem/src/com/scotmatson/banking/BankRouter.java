/**
 * Establishes a line of communication between an ATM and a bank.
 */
package com.scotmatson.banking;

import java.util.ArrayList;
import java.util.List;

public class BankRouter {

	// Needs to know the banks
	List<Integer> routingNumbers;
	
	public BankRouter()
	{
		routingNumbers = new ArrayList<>();
	}
	
	// 121042882 wells fargo
	// 121000358 bank of america
	// MasterCard account numbers start with prefixes ranging from “51” to “55”, and are 16 digits in length.
	
	
	//The first six digits of any credit or debit card identify the issuing authority or bank
	
	public Bank transactionRequest(int bankIdentifier)
	{
		
		return null;
	}
	// Needs to know the ATMs... or do you? Just returning information...
	
	/*
	 *	Steps:
	 *	Receives user request
	 *		Request should open a connection with a bank
	 *		As long as the connection remains opens the ATM should freely be able to interact with the bank.
	 * 
	 */
}
