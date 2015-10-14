package InvoiceLineItemPackage;



public class ProductDB {
	
	
	//needs a try/catch block for when the product is not found
	public static Product getProduct(String code){
		ProductList productList = new ProductList();
		Product product = new Product();
		if (productList.isProductFound(code)){
			
			product.setCode(code);
			product.setDescription(productList.getProductDesc(code));
			product.setPrice(productList.getProductPrice(code));
			return product;
		}
		else{
			product.setCode(null);
			return product;
		}
			

		
	}

}
