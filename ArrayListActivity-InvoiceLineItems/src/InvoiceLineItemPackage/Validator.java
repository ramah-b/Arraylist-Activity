package InvoiceLineItemPackage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validator {

	public static String getString(Scanner sc, String prompt) {
		System.out.print(prompt);
		String s = sc.next(); // read user entry
		sc.nextLine(); // discard any other data entered on the line
		return s;
	}

	

	public static double getDouble(Scanner sc, String prompt) {
		double d = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			try{
				d = sc.nextDouble();
				isValid = true;
			} catch(InputMismatchException e){
				System.out
				.println("Incorrect input. Please enter a valid number.");
	}

			sc.nextLine(); // discard any other data entered on the line
		}
		return d;
	}

	public static boolean getProduct(String code){
		boolean isFound = false;
			
				Product tempProduct = new Product();
			
				tempProduct = ProductDB.getProduct(code);
				if (tempProduct.getCode() != null)
					isFound = true;
			
			return isFound;
	}
	
}
