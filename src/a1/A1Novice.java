package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
				
		Scanner scan = new Scanner(System.in);

		// Read in count of the number of customers
		
		int count = scan.nextInt();
		
		
		// Create an array to store customers
		
		String[][] customers = new String[count][3];
		
		
		// input the data for each customer
		
		for (int i=0; i<customers.length; i++) {
			double total = 0.00;
			customers[i][0] = scan.next();
			customers[i][1] = scan.next();
			customers[i][2] = "0.00";
			int itemsBought = scan.nextInt();
			for (int k=0; k<itemsBought; k++) {
				int itemAmount = scan.nextInt();
				scan.next();
				double itemPrice = scan.nextDouble();
				for (int j=0; j<itemAmount;j++) {
					total += itemPrice;
				}
			}
			
			customers[i][2] = String.format("%.2f", total);

		}
		
		// close the scanner
		scan.close();
		
		for (int i=0; i<customers.length; i++) {
			System.out.println(customers[i][0].charAt(0) + ". " + customers[i][1] + ": " + customers[i][2]);
		}
		
		
		// loop to print out the output
		
		
		
	}
}
