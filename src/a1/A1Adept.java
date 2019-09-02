package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		// number of products being scanned in
		int numberOfProducts = scan.nextInt();
		
		// these arrays keeps track of the name and price of each item
		// an item and price will have matching index thus i am able to keep track of what item costs what
		// the length of the array is the number of products
		String[] productsName = new String [numberOfProducts];
		double[] productsPrice = new double [numberOfProducts];
		
		// this loop adds each item and price to the arrays
		// knowing the number of products i know how many loops to loop the array
		for (int i=0; i<numberOfProducts; i++) {
			productsName[i] = scan.next();
			productsPrice[i] = scan.nextDouble();
		}
		
		// this scans the number of customers
		int numberOfCustomers = scan.nextInt();
		
		// these arrays keep track of each customer through their index
		// for example Bill Smith has his data kept on index 1 of both arrays
		// this allows for the use of two different arrays to stay orginized
		// this array keeps track of the customers first and last name
		String[][] customers = new String[numberOfCustomers][2];
		// this keeps track of the totals that a customer will spend
		double[] customersTotal = new double[numberOfCustomers];
		
		// this for loop cycles through all customers
		for (int i=0; i<numberOfCustomers; i++) {
		// it gets the first and last name of each customer
		customers[i][0] = scan.next();
		customers[i][1] = scan.next();
		// it gets the number of items that customer is buying
		int numberOfItems = scan.nextInt();

			for (int j=0; j<numberOfItems; j++) {
				// the number of purchases is totaled 
				int numberOfPurchesed = scan.nextInt();
				// the name the current item is then scanned
				String nameOfItem = scan.next();
				// this loop then finds the item scanned in the list made at the beginning of the code
				// when it finds the product the products price is then multiplied with the number of the item purchased
				// the product is then added to the customers total
				for (int k=0;k<productsName.length; k++) {
					
					// if the product that the customer bought matches one of the products in the list the price is then added
					if (productsName[k].equals(nameOfItem)) {
						customersTotal[i] += numberOfPurchesed*productsPrice[k];
					}
					
				}
			}
			
			

		}
		
		// prints out the needed outputs
		System.out.println(biggest(customers,customersTotal));
		System.out.println(smallest(customers,customersTotal));
		System.out.println("Average: " + String.format("%.2f", average(customersTotal)));
		
	}
	
	// this is a simple method that returns the biggest totals out of the customers
	static String biggest(String[][] names, double[] totals) {
		//begins with saying the biggest total is found on index 0
		int biggest = 0;
		
		// this loop goes through each of the totals to find which index contains the largest total
		for (int i=1; i<totals.length; i++) {
			if (totals[biggest]<totals[i]) {
				biggest = i;
			}
		}
		// knowing that the index of totals and customer data match, the total of biggest also points to the correct customer
		return "Biggest: " + names[biggest][0] + " " + names[biggest][1] + " (" + String.format("%.2f", totals[biggest]) + ")";
		}
	
	// this is the same as the method above but flipped to find the smallest using the same method as above
	static String smallest(String[][] names, double[] totals) {
		int smallest = 0;
		
		for (int i=1; i<totals.length; i++) {
			if (totals[smallest]>totals[i]) {
				smallest = i;
			}
		}
		
		return "Smallest: " + names[smallest][0] + " " + names[smallest][1] + " (" + String.format("%.2f", totals[smallest]) + ")";
		}
	
	
	
	// this method goes through the list of totals and averages the amount
	static double average(double[] total) {
	// average starts as 0
	double average = 0;
	
	// this loops and adds up each total to the average
	for (int i=0; i<total.length; i++) {
		average += total[i];
	}
	
	// this returns the sum of all totals and divides it by the number of customers which finds the average
	return average/total.length;
	}
	
}
