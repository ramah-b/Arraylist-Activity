package InvoiceLineItemPackage;

import java.text.NumberFormat;

public class LineItem {
	private double Qty;
	private double total;
	private Product product;

	public LineItem() {
	}

	public double getQty() {
		return Qty;
	}

	public void setQty(double qty) {
		Qty = qty;
	}

	public double getTotal() {

		return total;
	}

	public void setTotal() {
		this.total = this.Qty * this.product.getPrice();
	}

	public Product setProduct(String code) {

		return this.product = ProductDB.getProduct(code);

	}

	public String getProduct() {
		String str = "";
		str = this.product.getCode() + this.product.getDescription()
				+ this.product.getPrice();
		return str;
	}

	public String printLineItem() {
		String str = String.format("%-6s %-28s %-8s %-8s %-8s",
				this.product.getCode(), this.product.getDescription(),
				this.getFormattedPrice(this.product.getPrice()), this.getQty(),
				this.getFormattedPrice(getTotal()));

		return str;

	}

	public String getFormattedPrice(double amount) {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		String amountStr = String.format("%.2f", amount);
		amount = Double.parseDouble(amountStr);
		return currency.format(amount);

	}

}
