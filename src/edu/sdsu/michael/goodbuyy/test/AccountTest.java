package edu.sdsu.michael.goodbuyy.test;

import edu.sdsu.michael.goodbuyy.obj.Account;
import java.util.Scanner;

public class AccountTest 
{
	public static void main(String[] args)
	{
		Account acct, acct1, acct2, acct3, acct4, acct5 = null;
		
		Scanner input = new Scanner(System.in);
		
		for(int i = 1; i <= 5; i++)
		{
			int accountNumber = 0;
			String firstName = null;
			String lastName = null;
			double creditLimit = 0;
			double beginningBalance = 0;
			double currentBalance = 0;
			
			System.out.println("Please enter your account number: ");
			accountNumber = input.nextInt();
			
			System.out.println("Please enter your first name: ");
			firstName = input.next();
			
			System.out.println("Please enter your last name: ");
			lastName = input.next();
						
			System.out.println("Please enter your credit limit: ");
			creditLimit = input.nextDouble();
			
			acct = new Account(accountNumber, lastName, firstName, creditLimit);
			
			System.out.println("Please enter your beginning balance: ");
			beginningBalance = input.nextDouble();
			currentBalance = beginningBalance;
			
			acct.setBeginningBalance(beginningBalance);
			acct.setCurrentBalance(currentBalance);
			
			System.out.println("The transaction of customer " + accountNumber + " will begin");
			System.out.println("Enter anything to start. Enter 0 to exit.");
			
			acct.transaction(acct);
			
//			transactionCode = input.nextInt();
//			
//			while(transactionCode != 0)
//			{
//				beginningBalance = currentBalance;
//				
//				System.out.println("Please enter the transaction code. 1 for purchase, 2 for payment without purchase, "
//						+ "3 for bowing without purchase, 0 for end of transaction for current Account.");
//				
//				transactionCode = input.nextInt();
//				
//				if(transactionCode == 1)
//				{
//					System.out.println("Please enter the cost of purchase: ");
//					costOfPurchase = input.nextDouble();
//					
//					System.out.println("Please enter the value of payment: ");
//					valueOfPayment = input.nextDouble();
//					
//					if(Math.abs(currentBalance - costOfPurchase + valueOfPayment) <= creditLimit)
//					{
//						currentBalance = currentBalance - costOfPurchase + valueOfPayment;
//						
//						acct.setCurrentBalance(currentBalance);
//						numberOfPurchases++;
//						
//						acct.setNumberOfPurchases(numberOfPurchases);
//						numberOfTransactions++;
//						
//						acct.setNumberOfTransactions(numberOfTransactions);
//						totalPurchaseSum = totalPurchaseSum + costOfPurchase;
//						
//						acct.setTotalPurchaseSum(totalPurchaseSum);
//						totalPayments = totalPayments + valueOfPayment;
//						
//						acct.setTotalPayments(totalPayments);
//						
//						System.out.println("This transaction is over. Your current balance is " + currentBalance + " System will return to main menu.");
//					}
//					else 
//					{
//						System.out.println("Your purchase has exceeded your credit limit. Your transaction will not be authorized and a $10 penalty will be applied: ");
//						
//						currentBalance = beginningBalance - 10;
//						numberOfTransactions++;
//						acct.setNumberOfTransactions(numberOfTransactions);
//						
//						System.out.println("This transaction is over. Your current balance is " + currentBalance + " System will return to main menu.");
//					}	
//				}
//				else if(transactionCode == 2)
//				{
//					System.out.println("Please enter the amount of money that you want to pay: ");
//					
//					valueOfPayment = input.nextDouble();
//					totalPayments = totalPayments + valueOfPayment;
//					
//					acct.setTotalPayments(totalPayments);
//					
//					currentBalance = currentBalance + valueOfPayment;
//					numberOfTransactions = numberOfTransactions++;
//					
//					acct.setNumberOfTransactions(numberOfTransactions);
//					
//					System.out.println("This transaction is over. Your current balance is " + currentBalance + " System will return to main menu.");
//				}
//				else if(transactionCode == 3)
//				{
//					System.out.println("Please enter the amount of money that you want to borrow: ");
//					
//					costOfPurchase = input.nextDouble();
//					
//					if(Math.abs(currentBalance - costOfPurchase) <= creditLimit)
//					{
//						currentBalance = currentBalance - costOfPurchase;					
//						numberOfPurchases = numberOfPurchases++;
//						numberOfTransactions = numberOfTransactions++;
//						
//						acct.setNumberOfPurchases(numberOfPurchases);
//						acct.setNumberOfTransactions(numberOfTransactions);
//						
//						System.out.println("This transaction is over. Your current balance is " + currentBalance + " System will return to main menu.");
//					}
//					else 
//					{
//						System.out.println("Your borrowing has exceeded your credit limit. Your transaction will not be authorized and a $10 penalty will be applied: ");
//						
//						currentBalance = currentBalance - 10;
//						acct.setCurrentBalance(currentBalance);
//						
//						numberOfTransactions = numberOfTransactions++;
//						acct.setNumberOfTransactions(numberOfTransactions);
//						
//						System.out.println("This transaction is over. Your current balance is " + currentBalance + " System will return to main menu.");
//					}
//				}
//				
//				acct.setEndBalance(currentBalance);
//			}
			
			if(i == 1)
			{
				acct1 = acct;
				
				acct.printStatement(acct1);
			}
			else if(i == 2)
			{
				acct2 = acct;
				
				acct.printStatement(acct2);
			}
			else if(i == 3)
			{
				acct3 = acct;
				
				acct.printStatement(acct3);
			}
			else if(i == 4)
			{
				acct4 = acct;
				
				acct.printStatement(acct4);
			}
			else if(i == 5)
			{
				acct5 = acct;
				
				acct.printStatement(acct5);
			}
			
			System.out.println("Your transaction is over. Thank you.");
		}
		
		input.close();
	}
}
