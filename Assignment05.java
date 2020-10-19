/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * CSE 110		:	Class #76383 / Friday at 11:50 AM - 12:40 PM
 * Assignment	:	#05
 * AUTHOR		:	Hien Luong & 1220061609
 * FILENAME		:	Assignment05.java
 * Description	:	Within the the Assignment05.java file, you must define the
 * 					following static methods. In the main method, you may 
 * 					write any code that wish to test the methods you have been 
 * 					asked to define.
 * TIME SPENT	:	40 minutes
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class Assignment05 {
	public static void main(String[] args) {
		//test 10 methods defined below.
		displayGreeting();
		
		displayText("Hello");
		displayText("123");
		displayText("abc" + "123");
		
		printTotal(0, 0, 0);
		printTotal(0, 1, 3);
		printTotal(100, 23, 2);
		
		System.out.println(getTotal(0,0,0));
		System.out.println(getTotal(0,1,3));
		System.out.println(getTotal(100,23,2));
		
		System.out.println(getAverage(0,0,0));
	    System.out.println(getAverage(0,1,3));
	    System.out.println(getAverage(100,13,7));
	    
	    System.out.println(averageLength("a", "abc", "ab"));
	    System.out.println(averageLength("hello", "goodbye", "monday"));
	    System.out.println(averageLength("wednesday", "tuesday", "monday"));
	    
	    System.out.println(lengthOfShortest("abc","ab"));
	    System.out.println(lengthOfShortest("hello","goodbye"));
	    System.out.println(lengthOfShortest("thursday","friday"));
	    
	    System.out.println(stringOfStars("abc"));
	    System.out.println(stringOfStars("Hello, world!"));
	    System.out.println(stringOfStars("0123456789"));
	    
	    System.out.println(maxStringOfStars("a","abc"));
	    System.out.println(maxStringOfStars("hello","goodbye"));
	    System.out.println(maxStringOfStars("thursday","friday"));
	    
	    System.out.println(midStringOfStars("a","abc","ab"));
	    System.out.println(midStringOfStars("hello","goodbye","yes"));
	    System.out.println(midStringOfStars("123456","12","1234"));
		
	}
	
	/*
	 * method name: displayGreeting
	 * that takes no arguments and returns no value.   
	 * When this function is called, 
	 * it should print the text "Hello, and welcome!".
	 */
	static void displayGreeting() {
		System.out.println("Hello, and welcome");
	} //End of Method 1
	/* 
	 * method name: displayText
	 * that takes a single String argument and returns no value.  
	 * When this function is called, 
	 * it should print the value of the argument that was passed to it.
	 */
	static void displayText(String text) {
		System.out.println(text);
	} //End of Method 2
	
	/*
	 * method name:	printTotal
	 * that takes three int arguments.
	 * When this function is called, 
	 * it should print the sum of the three arguments passed to it.
	 * This function should return no value.
	 */
	static void printTotal(int arg1, int arg2, int arg3) {
		System.out.println(arg1 + arg2 + arg3);
	} //End of Method 3
	
	/*
	 * method name: getTotal
	 * that takes three int arguments.
	 * When this function is called, it should return the sum     
	 * of the three arguments passed to it as an int.
	 */
	static int getTotal(int arg1, int arg2, int arg3) {
		return arg1 + arg2 + arg3;
	} //End of Method 4
	
	/*
	 * method name: getAverage
	 * that takes three int arguments.     
	 * When this function is called, it should return the average     
	 * of the three arguments passed to it as a double.
	 */
	static double getAverage(int arg1, int arg2, int arg3) {
		return (double) (arg1 + arg2 + arg3)/3;
	} //End of Method 5
	
	/*
	 * method name: averageLength
	 * that takes three String arguments.      
	 * When this function is called, it should return the average length (number of characters)     
	 * of the String arguments passed to it as a double.
	 */
	static double averageLength(String str1, String str2, String str3) {
		int l1 = str1.length(); //length of the first String value
		int l2 = str2.length(); //length of the second String value
		int l3 = str3.length(); //length of the third String value
		return (double) (l1 + l2 + l3)/3;
	} //End of Method 6
	
	/*
	 * method name: lengthOfShortest
	 * that takes two String arguments. 
	 * When this function is called,    
	 * it should return the length (number of characters)    
	 * of the shortest String argument passed to it as an int.
	 */
	static int lengthOfShortest(String str1, String str2) {
		return Math.min(str1.length(), str2.length()); 
	} //End of Method 7
	
	/*
	 * method name: stringOfStars
	 * that takes one String argument.
	 * When this function is called, 
	 * it should return a String of asterisks (*)     
	 * that is the same length as the string argument passed to it.
	 */
	static String stringOfStars(String str) {
		String stars = "";
		//for-loop to print out the correct number of stars
		for (int i = 1; i <= str.length(); i++) {
			stars += "*";
		}
		return stars; 
	} //End of Method 8
	
	/*
	 * method name: maxStringOfStars
	 * that takes two String arguments.     
	 * When this function is called, 
	 * it should return a String of asterisks (*)     
	 * that is the same length as the longest string argument passed to it.
	 */
	static String maxStringOfStars(String str1, String str2) {
		
		//Determine which String is the longest one.
		int maxStringLength = Math.max(str1.length(), str2.length());
		
		//for-loop out the correct number of stars with the longest String
		String stars = "";
		for (int i = 1; i <= maxStringLength; i++) {
			stars += "*";
		}
		return stars;
	} //End of Method 9
	
	/*
	 * method name: midStringOfStars
	 * that takes three String arguments. 
	 * When this function is called, 
	 * it should return a String of asterisks (*)  
	 * that is the same length as the string argument with the length    
	 * that would be in the middle 
	 * if the lengths of the arguments were arranged in ascending order.
	 */
	static String midStringOfStars(String str1, String str2, String str3) {
		String midString = "";
		
		/*
		 * if- else statements
		 * Determine which one is the middString
		 */
		//Assign length of each String variable into a, b, and c.
		int a = str1.length(); int b = str2.length(); int c = str3.length();
		int m = midString.length();
		
		//Checking for b
		if ((a < b && b < c) || (c < b && b < a)) {
			m = b;
		}
		
		//Checking for a
		else if ((b < a && a < c) || (c < a && a < b)) {
			m = a;
		} else {
			m = c;
		}
		
		//for-loop to return the correct num of stars 
		for (int i = 1; i <= m; i++) {
			midString += "*";
		}
		return midString;
	} //End of Method 10
} //End of Main