package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int numberOfProducts = scan.nextInt();
		
		String[] productsName = new String [numberOfProducts];
		int [][] productsAmount = new int [numberOfProducts][2];
		
		for (int i=0; i<numberOfProducts; i++) {
			productsName[i] = scan.next();
			scan.next();
		}
		
		int numberOfCustomers = scan.nextInt();
				
		for (int i=0; i<numberOfCustomers; i++) {
			scan.next();
			scan.next();

			int numberOfItems = scan.nextInt();
			int numberOfPurchesed;

				for (int j=0; j<numberOfItems; j++) {
					numberOfPurchesed = scan.nextInt();
					String nameOfItem = scan.next();
					for (int k=0;k<productsName.length; k++) {
						if (productsName[k].equals(nameOfItem)) {
							productsAmount[k][0] += numberOfPurchesed;
							productsAmount[k][1] += 1;

						}
					
					}	
				}
			
			

		}
		
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
