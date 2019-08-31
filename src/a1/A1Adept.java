package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int numberOfProducts = scan.nextInt();
		
		String[] productsName = new String [numberOfProducts];
		double[] productsPrice = new double [numberOfProducts];
		
		for (int i=0; i<numberOfProducts; i++) {
			productsName[i] = scan.next();
			productsPrice[i] = scan.nextDouble();
		}
		
		int numberOfCustomers = scan.nextInt();
		
		String[][] customers = new String[numberOfCustomers][2];
		double[] customersTotal = new double[numberOfCustomers];
		
		for (int i=0; i<numberOfCustomers; i++) {
		customers[i][0] = scan.next();
		customers[i][1] = scan.next();
		
		int numberOfItems = scan.nextInt();
		int numberOfPurchesed;

			for (int j=0; j<numberOfItems; j++) {
				numberOfPurchesed = scan.nextInt();
				String nameOfItem = scan.next();
				for (int k=0;k<productsName.length; k++) {
					if (productsName[k].equals(nameOfItem)) {
						customersTotal[i] += numberOfPurchesed*productsPrice[k];
					}
					
				}
			}
			
			

		}
		System.out.println(biggest(customers,customersTotal));
		System.out.println(smallest(customers,customersTotal));
		System.out.println("Average: " + String.format("%.2f", average(customersTotal)));
		
	}
	
	
	static String biggest(String[][] names, double[] totals) {
		int biggest = 0;
		
		for (int i=1; i<totals.length; i++) {
			if (totals[biggest]<totals[i]) {
				biggest = i;
			}
		}
		
		return "Biggest: " + names[biggest][0] + " " + names[biggest][1] + " (" + String.format("%.2f", totals[biggest]) + ")";
		}
	
	static String smallest(String[][] names, double[] totals) {
		int smallest = 0;
		
		for (int i=1; i<totals.length; i++) {
			if (totals[smallest]>totals[i]) {
				smallest = i;
			}
		}
		
		return "Smallest: " + names[smallest][0] + " " + names[smallest][1] + " (" + String.format("%.2f", totals[smallest]) + ")";
		}
	
	
	
	
	static double average(double[] total) {
	double average = 0;
	for (int i=0; i<total.length; i++) {
		average += total[i];
	}
	
	return average/total.length;
	}
	
}
