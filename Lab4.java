import java.util.Scanner;

/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * AUTHOR: Hien Luong
 * FILENAME: Lab4.java
 * SPECIFICATION:	This program should prompt the user a menu including four 
 * 					options, ask the user for one option, and  perform  the  
 * 					corresponding  computation.  This  process  will  repeat  
 * 					until  the  user  chooses "Quit". 
 * FOR: CSE 110-Lab #4
 * TIME SPENT: 120 minutes
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

public class Lab4 {

    public static void main(String[] args) {
        //Declare some variables you need
    	int opts = 0;
    	int m = 0;
    	int sum = 0;
    	int fact = 1;
    	int left = 0;
    	//create scanner
    	Scanner users = new Scanner(System.in);
        do {
            // Display the menu
            displayMenu();

            // Ask the user for one option
            opts = users.nextInt();

            switch (opts) {
                // Define four cases for different options. Don't forget "break".
            //Calc the sum of 1 to m 
            case 1: 
            	System.out.print("Enter a number: ");
            	m = users.nextInt();
            	for (int i = 0; i <= m; i++) {
            		sum += i;
            	}
            	System.out.println("The sum of 1 to " + m + " is " + sum);
            	sum = 0; //reset the memory for sum 
            	break;
            //Calc factorial of m	
            case 2: 
            	System.out.print("Enter a number: ");
            	m = users.nextInt();
            	for (int i = 1; i <= m; i++) {
            		fact = fact*i;
            	}
            	System.out.println("The factorial of " + m + " is " + fact);
            	fact = 1; //reset the memory for fact 
            	break;
            //Find the leftmost digit of the given number	
            case 3: 
            	System.out.print("Enter a number: ");
            	m = users.nextInt();
            	int i = 0;
            	System.out.print("The leftmost digit of " + m);
            	while (m > 0) {
            		left = m;
            		m /= 10;
            	}
            	System.out.println( " is " + left);
            	left = 0; //reset the memory for left 
            	break;
            //Quit function	
            case 4: 
            	System.out.println("Bye");
            	break;
            //Warning message!	
            default:
            	System.out.println("Enter a number between 1 and 4 ");
            	break;
            }
        } while (opts != 4); //Stop if user choose option 4

    }

    /**
     * Print the menu
     */
    private static void displayMenu() {
        System.out.println("Please choose one option from the following menu:");
        System.out.println("1) Calculate the sum of integers from 1 to m");
        System.out.println("2) Calculate the factorial of a given number");
        System.out.println("3) Display the leftmost digit of a given number");
        System.out.println("4) Quit");
    }
}