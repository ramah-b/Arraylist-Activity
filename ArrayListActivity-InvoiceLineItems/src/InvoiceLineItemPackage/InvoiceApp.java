package InvoiceLineItemPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import InvoiceLineItemPackage.Validator;
import InvoiceLineItemPackage.Invoice;

public class InvoiceApp {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		String tempCode, moreList = "";
		double tempQty;
		HashMap<String, Double> codeMap = new HashMap<String, Double>();





		System.out.println("Welcome to the invoice application.\n\n");


		// create an invoice object
		Invoice myInvoice = new Invoice();
		
		// loop for Lines Items; user may enter many items until he/she quits
		// inputs will be stored in temporary variables and array lists until
		// the user finishes the entries.
		
		do {
			tempCode = Validator.getString(keyboard, "Enter product code: ");

			if (Validator.getProduct(tempCode)){
			tempQty = Validator.getDouble(keyboard, "Enter quantity:	");
			while (tempQty <= 0 || tempQty > 50){
				tempQty = Validator.getDouble(keyboard, "Enter quantity:	");
			}
			LineItem tempLineItem = new LineItem();
			tempLineItem.setProduct(tempCode);
			tempLineItem.setQty(tempQty);
			
			tempLineItem.setTotal();
			
			if (codeMap.containsKey(tempCode))
				codeMap.put(tempCode, (codeMap.get(tempCode) + tempQty));
			else
				codeMap.put(tempCode, tempQty);

			myInvoice.addItem(tempLineItem);
			
			}else
				System.out.println("Product code entered does not exist.");
			System.out.print("Another line item? (y/n) ");
			moreList = keyboard.next().toLowerCase();
			System.out.println();

		} while (!moreList.equals("n"));
		
		keyboard.close();

		

		// set the line items array of objects to the user's entries
		System.out.format("%-6s %-28s %-8s %-8s %-8s", "Code" , "Description", "Price", "Qty", "Total");
		System.out.println();
		ArrayList<LineItem> invoiceLineItems = new ArrayList<LineItem>();
		invoiceLineItems = myInvoice.getLineItem();
		for (int i=0; i< invoiceLineItems.size(); i++){
			System.out.println(invoiceLineItems.get(i).printLineItem());
		}
		System.out.println("\n\n");
		System.out.println(myInvoice.getInvoiceTotal());
		System.out.println("\n");
		
		
		System.out.format("%-6s %-6s %-8s %-8s", "Code" , "Qty", "Total", "Average");
		System.out.println();
		for (String key : codeMap.keySet()){
			double total;
			Product prod = new Product();
			prod = ProductDB.getProduct(key);
			total = codeMap.get(key) * prod.getPrice();
			System.out.format("%-6s %-6s %-8s %-8s", key ,codeMap.get(key), total, (total/codeMap.get(key)));
			System.out.println();
		}


		
	}

}
