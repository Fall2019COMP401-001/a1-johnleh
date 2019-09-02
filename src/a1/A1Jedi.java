package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// this scans the number of products 
		int numberOfProducts = scan.nextInt();
		
		// this arrays is a menu of all the named items
		String[] productsName = new String [numberOfProducts];
		
		//this array keeps track of 2 things for each item
		// [x][0] is how much of an item is bought
		// [x][1] is how many different customers bought the product
		int [][] productsAmount = new int [numberOfProducts][2];
		
		// this is an array of values that is used to check if the same customer bought the item twice (explained more when it's used)
		Boolean[] boughtOnce = new Boolean [numberOfProducts];

		// this loop scans each item and saves its name on an array
		for (int i=0; i<numberOfProducts; i++) {
			productsName[i] = scan.next();
			scan.next();
		}
		
		// this scans for the number of customers
		int numberOfCustomers = scan.nextInt();
				
		// this loop is the main code
		// it cycles through ever customer and logs how many of an item is bought
		for (int i=0; i<numberOfCustomers; i++) {
			//these two scan past the name of a customer since its not needed
			scan.next();
			scan.next();
			
			/* boughtOnce is used to check if an item has been bought multiple times from the same person
			 * it is only needed when a person is imputed as such
			 * 
			 * Bill Smith 3 1 Apple 2 Banana 1 Apple
			 * 
			 * the array is vital in stopping the code from thinking 2 people bought apples rather then 1
			 */
			
			for (int h=0; h<productsAmount.length; h++) {
				boughtOnce[h]= true;
			}
			
			// this scans the number of items a customer bought 
			int numberOfItems = scan.nextInt();

				for (int j=0; j<numberOfItems; j++) {
					//This is to scan how many of an item the customer is buying
					int numberOfPurchesed = scan.nextInt();
					//This is used to scan the name of the item to know which item to change the amount
					String nameOfItem = scan.next();
					
					// this loop is used to find which index the item bought is located in
					for (int k=0;k<productsName.length; k++) {
						// if there is a match then the amount of the product is increased
						if (productsName[k].equals(nameOfItem)) {
							productsAmount[k][0] += numberOfPurchesed;
							// this if statement is used increase the number of each how many customers bought an item
							// the boughtOnce is used to know if the customers purchase of an item is counted before
							// if the item was recorded twice then the boughtOnce value would be false thus it wouldnt count it a second time
							if (boughtOnce[k]) {
								boughtOnce[k] = false;
								productsAmount[k][1] += 1;

							}
							
							
						}
					
					}	
				}
			
			

		}
		// this loop then produces the output for the program
		// if no customers bought an item it then states a different sentence then if a customer did
		for(int k=0; k<productsName.length; k++) {
			if (productsAmount[k][0] == 0) {
				System.out.println("No customers bought " + productsName[k]);
			}
			else {
				System.out.println(productsAmount[k][1] + " customers bought " + productsAmount[k][0] + " " + productsName[k]);
			}
		}
		
	}
}
