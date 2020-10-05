import java.util.Scanner;

/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * AUTHOR: Hien Luong
 * FILENAME: Assignment03.java
 * SPECIFICATION:	Within the main method in the Assignment03.java file, you 
 * 					must design and write a program to determine whether to 
 * 					buy, sell, or hold shares in a stock market. Your program 
 * 					must prompt the user to enter the 4 input values described 
 * 					below. It must collect the user's input and store these 
 * 					values in 4 different variables. It must collect the 
 * 					inputs in the order shown below.Your program must 
 * 					determine whether the user should buy, sell, or hold their 
 * 					shares based on the input data. It must print out an 
 * 					appropriate message to the user. The output must be 
 * 					formatted exactly like the Expected output examples shown 
 * 					below.
 * FOR: CSE 110-Assignment #03
 * TIME SPENT: 40 minutes
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class Assignment03 {
	public static void main(String[] args) {
		//create scanner
		Scanner input = new Scanner(System.in);
		
		//Declare variables
		final int TRANSACTION_FEE = 10; //store transaction fee = $10
		int currentShares = 0, marketPrice = 0, availableFunds = 0, purchasePrice = 0; //required inputs
		
		//prompt users to enter the inputs
		System.out.print("Current Shares: ");
		currentShares = input.nextInt(); //This is the number of shares of this stock currently held in the account
		
		System.out.print("Purchase Price: ");
		purchasePrice = input.nextInt(); //(per share) paid for current stock in the account
		
		System.out.print("Market Price: "); 
		marketPrice = input.nextInt(); //(per share) of this stock. This is the current market price for buying or selling this stock
		
		System.out.print("Available Funds: "); 
		availableFunds = input.nextInt(); //he amount the client is willing to spend on a transaction
		
		
		/*
		 * Calculation
		 */
		//number of shares to buy if capable
		int numberOfSharesToBuy =  (int) Math.floor((availableFunds - TRANSACTION_FEE)/marketPrice);
		
		//total cost to buy some shares including transaction fee
		int totalBuyCost = TRANSACTION_FEE + marketPrice;
		
		//buy-value per share
		int perShareBuyValue = purchasePrice - marketPrice;
		
		//total buy-value
		int totalBuyValue = perShareBuyValue * numberOfSharesToBuy;
		
		//sale value per share
		int perShareSellValue = marketPrice - purchasePrice;
		
		//total sale value
		int totalSellValue = perShareSellValue * currentShares;
		
		/*
		 * first if-else or if statements to determine whether the user should buy, sell, or hold their shares based on the input data
		 */
		if (marketPrice < purchasePrice & availableFunds > TRANSACTION_FEE) {
			//if all requirements are satisfied, buy some.
			System.out.println("Buy " + numberOfSharesToBuy + " shares");
		} else if(totalSellValue > (totalBuyValue + TRANSACTION_FEE)) {
			//if selling the current shares can cover up the transaction fee and make profits, then sell.
			System.out.println("Sell " + currentShares + " shares");
		} else {
			//hold the shares if none of two above cases happens
			System.out.println("Hold shares");
		}
	}
	
}
