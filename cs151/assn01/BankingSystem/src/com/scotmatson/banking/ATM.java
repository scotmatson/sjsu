/**
 * 
 * COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved.
 * 
 * Classes used to interact with an ATM machine.
 * 
 * Solves CS151 homework assignment #1
 * 
 * @author Scot Matson
 * 
 * @version 1.01 2015/9/18
 * 
 */
package com.scotmatson.banking;

import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ATM implements Scannable<Card>
{

   // ATM attributes.
   private Scanner in;
   private final int ID;
   private int userInput;
   private Bank bank;
   private int maxWithdrawal;
   private boolean activeSession;

   // Stored card attributes.
   private int bankID;
   private int customerID;
   // private int accountID;
   private Date cardExpiration;
   private int pin;

   /**
    * Constructor method.
    * 
    * @param bank
    *           the bank which owns the ATM.
    * @param maxWithdrawal
    *           the max amount of money which may be withdrawn.
    */
   public ATM(int id, Bank bank, int maxWithdrawal, Scanner in)
   {
      this.in = in;
      this.ID = id;
      this.bank = bank;
      this.maxWithdrawal = maxWithdrawal;
      this.activeSession = false;
   }

   /**
    * Scans and stores card information.
    * 
    * @param card
    *           an ATM debit/cash card.
    */
   @Override
   public void scan(Card card)
   {
      int cardNumber = card.getNumber();

      // Parse card data.
      // this.accountID = cardNumber % 100;
      cardNumber /= 100;
      this.customerID = cardNumber % 100;
      cardNumber /= 100;
      this.bankID = cardNumber;
      this.cardExpiration = card.getExpiration();

      System.out.println("### ATM ###");
      System.out.println("Machine ID: " + this.ID);
      System.out.println("Bank ID: " + this.bankID);
      System.out.println();
      System.out.println("*** Card Scanned ***");
      System.out.println();
   }

   /**
    * Validates card and user credentials.
    * 
    */
   public boolean validateCard()
   {
      boolean isValid = false;

      // Validate Bank Affiliation.
      if (bank.getID() == this.bankID)
      {
         // Validate card expiration date.
         Calendar calendar = Calendar.getInstance();
         Date now = calendar.getTime();
         if (now.before(this.cardExpiration))
         {
            // Validate user credentials.
            this.pin = getCustomerPIN();
            isValid = bank.authorizeAccountAcccess(customerID, pin);

         }
         else
         {
            System.out.println("Expired card.");
            System.out.println("Current date: " + now);
            System.out.println("Card EXP date: " + this.cardExpiration);
            System.out.println();
         }
      }
      else
      {
         System.out.println("Card not recognized.");
         System.out.println("ATM Bank ID: " + bank.getID());
         System.out.println("Card Bank ID: " + this.bankID);
         System.out.println();
      }
      return isValid;
   }

   /**
    * Initiates account transaction and launches the user interface.
    */
   public void beginTransaction()
   {
      activeSession = true;
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
    * Interface for entering the customer's PIN.
    * 
    * @return the numerical PIN.
    */
   public int getCustomerPIN()
   {
      System.out.print("Please enter your PIN: ");
      int pin = -1;
      try
      {
         pin = in.nextInt();
      }
      catch (InputMismatchException e)
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
    * @return the user selection.
    */
   public int printATMMenu()
   {
      System.out.println("What would you like to do?");
      System.out.println("1) Make a deposit.");
      System.out.println("2) Make a withdrawal.");
      System.out.println("3) View account balance.");
      System.out.println("4) Return card.");
      System.out.println();

      return enterValue();
   }

   /**
    * Flushes stored values from ATM memory preventing further user interaction.
    */
   public void endTransaction()
   {
      userInput = -1;
      bankID = -1;
      customerID = -1;
      // accountID = -1;
      cardExpiration = null;
      activeSession = false;

      System.out.println("End Transaction.");
      System.out.println("Your card has been returned.");
   }

   /**
    * Reusable helper function for ATM-User interaction.
    * 
    * @return the user's input.
    */
   public int enterValue()
   {
      try
      {
         userInput = in.nextInt();
      }
      catch (InputMismatchException e)
      {
         System.out.println("Invalid user entry.");
         // Flush the Scanner
         in.next();
      }

      return userInput;
   }

   /**
    * Performs a transaction request.
    */
   public void makeDeposit()
   {
      System.out.print("Enter amount to be deposited: ");
      int amount = enterValue();
      System.out.println();

      bank.depositFunds(this.customerID, this.pin, amount);
      System.out.println("Transaction completed.");
      viewBalance();
      System.out.println();
   }

   /**
    * Performs a withdrawal request.
    */
   public void makeWithdrawal()
   {
      System.out.print("Enter amount to be withdrawn: ");
      int amount = enterValue();
      System.out.println();

      if (amount > 0 && amount < maxWithdrawal && amount % 20 == 0)
      {
         boolean isComplete = bank.withdrawalFunds(this.customerID, this.pin, amount);
         if (!isComplete)
         {
            System.out.println("Insufficient funds available.");
            System.out.println();
         }
         else
         {
            System.out.println("Transaction completed.");
            viewBalance();
         }
      }
      else
      {
         System.out.println("Unable to complete transaction.");
         System.out.println("Withdrawals must between $20 - $200");
         System.out.println("in $20 increments.");
         System.out.println();
      }
   }

   /**
    * Displays the account balance.
    */
   public void viewBalance()
   {
      int balance = bank.displayAccountBalance(customerID, pin);
      System.out.println("Current account balance: " + balance);
      System.out.println();
   }
   
   /**
    * Returns the ATM ID.
    * 
    * @return the ATM ID.
    */
   public int getID()
   {
      return this.ID;
   }
}
