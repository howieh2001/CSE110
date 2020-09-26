import java.util.Scanner;

/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * AUTHOR: Hien Luong
 * FILENAME: Assignment02.java
 * SPECIFICATION:	Within the main method in the Assignment02.java file,
 * 					you must write a program to compute the materials and 
 * 					costs required for a specified road construction project.
 * 					Your program must prompt the user's to enter the 4 input 
 * 					values described below. It must collect the user's input 
 * 					and store these values in 4 different variables.It must 
 * 					collect the inputs in the order shown below.
 * FOR: CSE 110-Assignment #02
 * TIME SPENT: 360 minutes
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class Assignment02 {
	public static void main(String[] args)
	{
		//Create scanner 
		Scanner scanner = new Scanner(System.in);
		//Declare four input variables
		double miles = 0.00;
		int laneNum = 0;
		int depth = 0;
		int days = 0;
		
		//while-loop to collect input
		int i = 0;
		while (i < 4) {
			//if i = 0: ask for length of road project
			if(i == 0) {
				System.out.print("Length of road project (miles): ");
				miles = scanner.nextDouble();
				if (miles <= 0) {
					//the length of road project grade is not valid
					System.out.println("The length of road project grade is invalid! ");
					//let the user re-try 
					System.out.print("Please enter the length of road project again: ");
					miles = scanner.nextDouble();
				} else {
					//update the loop variable
					i++;
				}
			}
			//if i = 1: ask for number of lanes
			if(i == 1) {
				System.out.print("Number of lanes : ");
				laneNum = scanner.nextInt();
				if (laneNum < 1 || laneNum > 8) {
					//the number of lanes is not valid
					System.out.println("The number of lanes is invalid! ");
					//let the user re-try 
					System.out.print("Please enter the number of lanes again: ");
					laneNum = scanner.nextInt();
				} else {
					//update the loop variable
					i++;
				}
			}
			//if i = 2: ask for depth of asphalt (inches)
			if(i == 2) {
				System.out.print("Depth of asphalt (inches): ");
				depth = scanner.nextInt();
				if (depth <= 0 ) {
					//the depth of asphalt (inches) is not valid
					System.out.println("The depth of asphalt (inches) is invalid! ");
					//let the user re-try 
					System.out.print("Please enter the depth of asphalt (inches) again: ");
					depth = scanner.nextInt();
				} else {
					//update the loop variable
					i++;
				}
			}
			//if i = 3: ask for days to complete project
			if(i == 3) {
				System.out.print("Days to complete project : ");
				days = scanner.nextInt();
				if (days <= 0 ) {
					//the depth of asphalt (inches) is not valid
					System.out.println("The number of days to complete project is invalid! ");
					//let the user re-try 
					System.out.print("Please enter the number of days to complete project again: ");
					days = scanner.nextInt();
				} else {
					//update the loop variable
					i++;
				}
			}
				
		}
		scanner.close(); //stop entering inputs
		
		//Calc materials and display
		System.out.println("=== Amount of materials needed ===");
		
		int truckLoads = (int)(Math.ceil((miles*5280)*(depth/(double)12)*(12)*150*laneNum/(double)10000)); //truckloads of Asphalt
		System.out.println("Truckloads of Asphalt\t: " + truckLoads);

		int intersections = (int) miles; //number of intersections

		int stoplights = intersections*(laneNum+2); //stoplights
		System.out.println("Stoplights\t\t: " + stoplights);

		int conduitPipes = (int) Math.round(miles*5280/24); //Conduit pipes
		System.out.println("Conduit pipes\t\t: " + conduitPipes);

		int crewMembers = (int) Math.round(50*miles*laneNum/days);
		System.out.println("Crew members needed\t: " + crewMembers);

		//Calc the cost of materials and display
		System.out.println("=== Cost of Materials ============");

		double costOfAsphalt = truckLoads*1000; //cost of Asphalt
		System.out.printf("Cost of Asphalt\t\t: $%.2f\n", costOfAsphalt);

		double costOfStoplights = 25000*stoplights; //cost of stoplights
		System.out.printf("Cost of Stoplights\t: $%.2f\n", costOfStoplights);

		double costOfConduitPipes = 500*conduitPipes; //Cost of Conduit pipes
		System.out.printf("Cost of Conduit pipes\t: $%.2f\n", costOfConduitPipes);

		double costOfLabor = days*8*25*crewMembers; //cost of labor
		System.out.printf("Cost of Labor\t\t: $%.2f\n", costOfLabor);

		//calc total cost of the project
		System.out.println("=== Total Cost of Project ========");

		double totalCost = costOfAsphalt + costOfStoplights + costOfConduitPipes + costOfLabor;
		System.out.printf("Total cost of project\t: $%.2f\n", totalCost);
		
		
		
	} //End of main
} //End of class
