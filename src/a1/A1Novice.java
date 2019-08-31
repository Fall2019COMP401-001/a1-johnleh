package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		// creating the scanner	
		Scanner scan = new Scanner(System.in);

		// Read in count of the number of customers
		int count = scan.nextInt();
		
		// Create a 2d array to store each customer and their data (first name, last name, total)
		// each row of the array is a customer 
		// the columns are organized by first name, last name, total
	
		String[][] customers = new String[count][3];
		
		
		// input the data for each customer
		// the first loop is to cycle through the costumers and saves their data to the array
		for (int i=0; i<customers.length; i++) {
			
			// initialize a double to store the total for each customer
			double total = 0.00;
			// scans and inputs the first name
			customers[i][0] = scan.next();
			// scans and inputs the last name
			customers[i][1] = scan.next();
			
			// scans and finds out how many items that the customer has purchased
			// this is used to learn how many loops the program needs to do in order to total all the items
			int itemsBought = scan.nextInt();
			
			// this loop is where the items a custumer has bought are totaled up
			// knowing how many items bought i am able to loop that amount of times and scan the appropriate amount
			// which each loop the price of each item is added to the total which keeps a running count of the price the costumer is paying
			for (int k=0; k<itemsBought; k++) {
				// this variable is how much of an item is bought
				int itemAmount = scan.nextInt();
				// this skips the name of the item since there is no need to know the name of the item
				scan.next();
				/* knowing how many of an item, i can then multiply the price of the item with the amount 
				*this figures out how much money a costumer is paying for the quantity of the item
				*item amount is how much of an item and "scan.nextDouble();" scans the price
				*the product is then added to the running total
				*/ 
				total += itemAmount*scan.nextDouble();
			}
			
			// Finally the total price (which currently is a double) is converted to a string and added to the array in the proper column
			customers[i][2] = String.format("%.2f", total);
			
		}
		
		// close the scanner
		scan.close();
		
		// after the scanner is closed, this loop then prints the output 
		// the output is the rows each customer and their data line by line
		for (int i=0; i<customers.length; i++) {
			System.out.println(customers[i][0].charAt(0) + ". " + customers[i][1] + ": " + customers[i][2]);
		}		
		
	}
}
