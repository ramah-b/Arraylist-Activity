package InvoiceLineItemPackage;

import java.util.HashMap;

public class ProductList {
	private HashMap<String, Double> productPrice = new HashMap<String, Double>();
	private HashMap<String, String> productDesc = new HashMap<String, String>();;
	//private Product prod  = new Product(); 
	
	public ProductList() {

		productPrice.put("java", 49.50);
		productPrice.put("jsps", 49.50);
		productDesc.put("java", "Murach's Beginning Java");
		productDesc.put("jsps", "Murach's Java Servlets and JSP");

	}

	public boolean isProductFound(String code) {
		boolean isFound = false;
		if (this.productDesc.containsKey(code))
			return isFound = true;
		else
			return isFound;
	}
	/*
	public Product getProductDetails(String code){
		try{
		if (isProductFound(code)){
			prod.setCode(code);
			prod.setDescription(this.getProductDesc(code));
			prod.setPrice(this.getProductPrice(code));
		}
		}catch (Exception e){
			System.out.println("Product is not Found.");
		}
		return prod;
	}
*/
	public double getProductPrice(String code) {
	
			return this.productPrice.get(code);
		

	}

	public String getProductDesc(String code) {
			return this.productDesc.get(code);
		
	}

	public boolean setProductListItem(String code, String description, double price){
		boolean isAdded = false;
		if (isProductFound(code)){
			this.setProductDesc(code, description);
			this.setProductPrice(code, price);
			isAdded = true;
		}
		return isAdded;
	}
	private void setProductPrice(String code, Double price) {
	
			this.productPrice.put(code, price);

	}

	private void setProductDesc(String code, String description) {
		this.productDesc.put(code, description);
	}
}
