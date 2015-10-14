package InvoiceLineItemPackage;

import java.text.NumberFormat;
import java.util.ArrayList;

import InvoiceLineItemPackage.LineItem;

public class Invoice {

	private ArrayList<LineItem> lineItemsList;
	private static int indexCounter;

	public Invoice() {
		lineItemsList = new ArrayList<LineItem>();
		indexCounter = 0;
	}

	// set the Line Items object variables
	public void addItem(LineItem lineItem) {

		lineItemsList.add(indexCounter, lineItem);
		indexCounter++;

	}

	public ArrayList<LineItem> getLineItem() {

		return this.lineItemsList;
	}

	public String getInvoiceTotal() {
		double invoiceTotal = 0.0;
		for (int i = 0; i < indexCounter; i++) {
			invoiceTotal += this.lineItemsList.get(i).getTotal();
		}
		String str= String.format("%60s %3s", "Total Invoice: ", this.getFormattedPrice(invoiceTotal));
		return str;

	}

	public String getFormattedPrice(double amount) {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return currency.format(amount);
	}


}
