package edu.sdsu.michael.goodbuyy.obj;

import java.util.Scanner;

public class Account
{
	private int accountNumber;
	private String customerLastName;
	private String customerFirstName;
	private double creditLimit;
	private double beginningBalance;
	private double currentBalance;
	private double endBalance;
	private int numberOfPurchases;
	private int numberOfTransactions;
	private double totalPurchaseSum;
	private double totalPayments;
	
	public int getAccountNumber()
	{
		return accountNumber;
	}
	
	public void setAccountNumber(int accountNumber)
	{
		this.accountNumber = accountNumber;
	}
	
	public String getCustomerLastName()
	{
		return customerLastName;
	}
	
	public void setCustomerLastName(String customerLastName)
	{
		this.customerLastName = customerLastName;
	}
	
	public String getCustomerFirstName()
	{
		return customerFirstName;
	}
	
	public void setCustomerFirstName(String customerFirstName)
	{
		this.customerFirstName = customerFirstName;
	}
	
	public double getCreditLimit()
	{
		return creditLimit;
	}
	
	public void setCreditLimit(double creditLimit)
	{
		this.creditLimit = creditLimit;
	}
	
	public double getBeginningBalance()
	{
		return beginningBalance;
	}
	
	public void setBeginningBalance(double beginningBalance)
	{
		this.beginningBalance = beginningBalance;
	}
	
	public double getCurrentBalance()
	{
		return currentBalance;
	}
	
	public void setCurrentBalance(double currentBalance)
	{
		this.currentBalance = currentBalance;
	}
	
	public double getEndBalance()
	{
		return endBalance;
	}
	
	public void setEndBalance(double endBalance)
	{
		this.endBalance = endBalance;
	}
	
	public int getNumberOfPurchases()
	{
		return numberOfPurchases;
	}
	
	public void setNumberOfPurchases(int numberOfPurchases)
	{
		this.numberOfPurchases = numberOfPurchases;
	}
	
	public int getNumberOfTransactions()
	{
		return numberOfTransactions;
	}
	
	public void setNumberOfTransactions(int numberOfTransactions)
	{
		this.numberOfTransactions = numberOfTransactions;
	}
	
	public double getTotalPurchaseSum()
	{
		return totalPurchaseSum;
	}
	
	public void setTotalPurchaseSum(double totalPurchaseSum)
	{
		this.totalPurchaseSum = totalPurchaseSum;
	}
	
	public double getTotalPayments()
	{
		return totalPayments;
	}
	
	public void setTotalPayments(double totalPayments)
	{
		this.totalPayments = totalPayments;
	}
	
	public Account(int accountNumber, String customerLastName, String customerFirstName, double creditLimit)
	{
		this.setAccountNumber(accountNumber);
		this.setCustomerLastName(customerLastName);
		this.setCustomerFirstName(customerFirstName);
		this.setCreditLimit(creditLimit);
	}
	
	public void printStatement(Account acct)
	{
		System.out.println("Account number: " + acct.getAccountNumber() + " Customer name: " + acct.getCustomerFirstName()
						+ " " + acct.getCustomerLastName() + " Credit Limit: " + acct.getCreditLimit());
		
		System.out.println("Beginning Balance: " + acct.getBeginningBalance() + " Current Balance: "
				+ acct.getCurrentBalance() + " End Balance: " + acct.getEndBalance());
		
		System.out.println("Number of Purchases: " + acct.getNumberOfPurchases() + " Number of Transcations: "
				+ acct.getNumberOfTransactions() + " Total Purchase Sum: " + acct.getTotalPurchaseSum()
				+ " Total Payments: " + acct.getTotalPayments());
	}
	
	public Account transaction(Account account)
	{
		int transactionCode = 0;
		double costOfPurchase = 0;
		double valueOfPayment = 0;
		int numberOfPurchases = 0;
		int numberOfTransactions = 0;
		double totalPurchaseSum = 0;
		double totalPayments = 0;
		double currentBalance = account.getCurrentBalance();
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		transactionCode = input.nextInt();
		
		while(transactionCode != 0)
		{
//			beginningBalance = currentBalance;
			
			System.out.println("Please enter the transaction code. 1 for purchase, 2 for payment without purchase, "
					+ "3 for bowing without purchase, 0 for end of transaction for current Account.");
			
			transactionCode = input.nextInt();
			
			// 
			if(transactionCode == 1)
			{
				System.out.println("Please enter the cost of purchase: ");
				costOfPurchase = input.nextDouble();
				
				System.out.println("Please enter the value of payment: ");
				valueOfPayment = input.nextDouble();
				
				// 
				if(Math.abs(currentBalance - costOfPurchase + valueOfPayment) <= creditLimit)
				{
					currentBalance = currentBalance - costOfPurchase + valueOfPayment;
					
					account.setCurrentBalance(currentBalance);
					numberOfPurchases++;
					
					account.setNumberOfPurchases(numberOfPurchases);
					numberOfTransactions++;
					
					account.setNumberOfTransactions(numberOfTransactions);
					totalPurchaseSum = totalPurchaseSum + costOfPurchase;
					
					account.setTotalPurchaseSum(totalPurchaseSum);
					totalPayments = totalPayments + valueOfPayment;
					
					account.setTotalPayments(totalPayments);
					
					System.out.println("This transaction is over. Your current balance is " + currentBalance + " System will return to main menu.");
				}
				else 
				{
					System.out.println("Your purchase has exceeded your credit limit. Your transaction will not be authorized and a $10 penalty will be applied: ");
					
//					currentBalance = beginningBalance - 10;
					currentBalance -= 10;
					numberOfTransactions++;
					account.setNumberOfTransactions(numberOfTransactions);
					
					System.out.println("This transaction is over. Your current balance is " + currentBalance + " System will return to main menu.");
				}	
			}
			// 
			else if(transactionCode == 2)
			{
				System.out.println("Please enter the amount of money that you want to pay: ");
				
				valueOfPayment = input.nextDouble();
				totalPayments = totalPayments + valueOfPayment;
				
				account.setTotalPayments(totalPayments);
				
				currentBalance = currentBalance + valueOfPayment;
//				numberOfTransactions = numberOfTransactions++;
				numberOfTransactions++;
				
				account.setNumberOfTransactions(numberOfTransactions);
				
				System.out.println("This transaction is over. Your current balance is " + currentBalance + " System will return to main menu.");
			}
			// 
			else if(transactionCode == 3)
			{
				System.out.println("Please enter the amount of money that you want to borrow: ");
				
				costOfPurchase = input.nextDouble();
				
				if(Math.abs(currentBalance - costOfPurchase) <= creditLimit)
				{
					currentBalance = currentBalance - costOfPurchase;					
//					numberOfPurchases = numberOfPurchases++;
//					numberOfTransactions = numberOfTransactions++;
					numberOfPurchases++;
					numberOfTransactions++;
					
					account.setNumberOfPurchases(numberOfPurchases);
					account.setNumberOfTransactions(numberOfTransactions);
					
					System.out.println("This transaction is over. Your current balance is " + currentBalance + " System will return to main menu.");
				}
				else 
				{
					System.out.println("Your borrowing has exceeded your credit limit. Your transaction will not be authorized and a $10 penalty will be applied: ");
					
					currentBalance = currentBalance - 10;
					account.setCurrentBalance(currentBalance);
					
//					numberOfTransactions = numberOfTransactions++;
					numberOfTransactions++;
					account.setNumberOfTransactions(numberOfTransactions);
					
					System.out.println("This transaction is over. Your current balance is " + currentBalance + " System will return to main menu.");
				}
			}
			
			account.setEndBalance(currentBalance);
		}
		return account;
	}
}
