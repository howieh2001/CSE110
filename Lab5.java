import java.util.Scanner;

/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * AUTHOR: Hien Luong
 * FILENAME: Lab5.java
 * SPECIFICATION:	This program should prompt the user a menu including four 
 * 					options, ask the user for one option, and  perform  the  
 * 					corresponding  computation.  This  process  will  repeat  
 * 					until  the  user  chooses "Quit". 
 * FOR: CSE 110-Lab #5
 * TIME SPENT: 60 minutes
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class Lab5 {
	public static void main(String[] args) {
		//Declare final type variables 
		final char SIDE_SYMB = '-';
		final char MID_SYMB = '*';
		
		//Create scanner 
		Scanner input = new Scanner(System.in);
		
		//Declare variables
		String inputStr = " ";
		char choice = ' ';
		int numSymbols = -1, sideWidth = -1, midWidth = -1;
		
		//do-while loop with built-in switch to start the program with 4 options
		do {
			displayMenu();
			inputStr = input.nextLine();
			if (inputStr.length() > 0) {
				choice = inputStr.charAt(0);
			} else {
				choice = ' ';
			}
			
			switch (choice) {
			// if user choose option r, then draw rows
			case 'r': 
				System.out.println("Width of the sides?");
				sideWidth = input.nextInt();
				System.out.println("Width of the middle?");
				midWidth = input.nextInt();
				input.nextLine(); //Flush junk newLine symbols
				
				System.out.println();
				System.out.println(buildRow(
						SIDE_SYMB, sideWidth, MID_SYMB, midWidth));
				
				break;
			// if user choose option p, then draw pyramids
			case 'p':
				System.out.println("Number of symbols on the lowest layer?");
				numSymbols = input.nextInt();
				input.nextLine(); //Flush junk newline symbols
				
				System.out.println();
				System.out.println(buildPyramid(SIDE_SYMB, MID_SYMB, numSymbols));
				
				break;
			// if user choose option d, then draw shallow diamonds
			case 'd':     
				//prompt user to enter value
				System.out.println("Number of symbols on the middle layer?");                
				numSymbols = input.nextInt();                
				input.nextLine();  // Flush junk newline symbols                
				System.out.println();                
				System.out.println(buildDiamond('*', ' ', numSymbols));
				
				break;
			// if user choose option q, then stop the loop
			case 'q': 
				System.out.println("Bye");
				break;
			// if user chose an unlisted option, then ask the user to choose a valid option from the menu	
			default:
				System.out.println("Please choose a valid option from the menu.");
				break;
			}
			System.out.println();
		} while (choice != 'q'); //end of loop
		
		input.close(); //end of scanner
		}
	
	/**
	 * Build a row of symbols (pattern) with the given parameters.
	 * 
	 * For example, -----*****----- can be built by the parameters
	 * 
	 * sideWidth = 5, midWidth = 5, sideSymb = '-', midSymb = '*'
	 * 
	 * @param sideSymb	A char to be repeated on both sides
	 * @param sideWidth	Number of symbols on each side
	 * @param midSymb	A char to repeated in the middle
	 * @param midWidth	Number of symbols in the middle
	 * @return			A String of a row of the designed pattern
	 */
	private static String buildRow(
		char sideSymb, int sideWidth, char midSymb, int midWidth) {
		String result = "";
		
		for (int i = 0; i < sideWidth; i++) {
			result += sideSymb;
		}
		for (int i = 0; i < midWidth; i++) {
			result += midSymb;
		}
		for (int i = 0; i < sideWidth; i ++) {
			result += sideSymb;
		}
		
		return result;
	}	// End of buildRow
	
	/**
	 * Build a pyramid pattern with the given parameters.
	 * 
	 * For example, the following pattern
	 * 
	 * -----*-----
	 * ----***----
	 * ---*****---
	 * --*******--
	 * -*********-
	 * ***********
	 * 
	 * can be built by sideSymb = '-', midSymb = '*', numSymbols = 11
	 * 
	 * When ptnHeight is not an odd integer, replace it by the closest
	 * even integer below. For example, if numSymbols is 10, use 9 instead.
	 * 
	 * When numSymb is 0, return an empty String.
	 * 
	 * @param 	sideSymb	A char to be repeated on both sides
	 * @param 	midSymb		A char to be repeated in the middle
	 * @param	numSymb		The number of symbols on the lowest layer
	 * @return				A String of the pyramid pattern.
	 */
	private static String buildPyramid(
		char sideSymb, char midSymb, int numSymb) {
		String result = "";
		
		
		//check if the input is an odd number
		if (numSymb % 2 == 0) {
			System.out.println("The input is not an odd number. Use the closest odd number below " + numSymb);
			numSymb -= 1;
		}
		
		int totalSymbOneRow = numSymb; //total symbol on on row at each time.
		
		//for-loop to draw a pyramid
		for (int numStars = 1; numStars <= numSymb; numStars += 2) {
			int numDashed = (totalSymbOneRow - numStars) / 2;
			String row = buildRow(sideSymb, numDashed, midSymb, numStars);
			result += row + "\n";
		}
		
		return result;
	} //End of buildPyramid
	
	/**
	 * Build a diamond pattern. The parameters are the same 
	 * 
	 * For example, the following pattern:
	 * ***** *****
	 * ****   ****
	 * ***     ***
	 * **       **
	 * *         *
	 * 
	 * *         *
	 * **       **
	 * ***     ***
	 * ****   ****
	 * ***** *****
	 * 
	 * When ptnHeight is not an odd integer, replace it by the closest
	 * even integer below. For example, if numSymbols is 10, use 9 instead.
	 * 
	 * When numSymb = 0, String result return 'empty'
	 * 
	 * as {@link #buildPyramid(char, char, int)}.
	 * 
	 * @param 	sideSymb	A char to be repeated on both sides
	 * @param 	midSymb		A char to be repeated in the middle
	 * @param	numSymb		The number of symbols on the lowest and highest layers
	 * @return				A String of the inverted diamond pattern.
	 */
	private static String buildDiamond(        
		char sideSymb, char midSymb, int numSymb) {        
		String result = "";
		
		//check if the input is an even number
		if (numSymb % 2 == 0) {
			System.out.println("The input is not an odd number. Use the closest odd number below " + numSymb);
			numSymb -=1;
		}
		
		int totalSymb = numSymb; //total symbol on on row at each time.
		
		//for-loop to draw a upper half of the shallow diamond
		for (int numSpaces = 1; numSpaces <= numSymb ; numSpaces += 2) {
			int numStars = (totalSymb - numSpaces)/2;
			String row = buildRow(sideSymb, numStars, midSymb, numSpaces);
			result += row + "\n";
		}
		
		//for-loop to draw a lower half of the shallow diamond
		for (int numStars = 1; numStars <= (numSymb-1)/2; numStars++) {
			int numSpaces = (totalSymb - numStars*2);
			String row = buildRow(sideSymb, numStars, midSymb, numSpaces);
			result += row + "\n";
		}
		
		return result;    
	} //End of buildDiamond 
	
	/**
	 * Display the menu
	 */
	private static void displayMenu() {
		System.out.println("Please choose one pattern from the list: ");
		System.out.println("r) Row");
		System.out.println("p) Pyramid");
		System.out.println("d) Shallow diamond");
		System.out.println("q) Quit");
	} //End of displayMenu
} //End of lab5
