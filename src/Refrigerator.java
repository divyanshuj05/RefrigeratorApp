import java.util.ArrayList;
import java.util.List;

// 10-04-2023 Divyanshu Jain 102097010  PATHLOCK  Due Date: 2023-04-13  Refrigerator.java
public class Refrigerator {
	private List<Product> products;

	public Refrigerator() {
		products = new ArrayList<>();
	}

	public void addProduct(Product product) {
		products.add(product);  // add product to the list
	}

	public void updateProductQuantity(Product product, int quantity, String unitOfMeasure) {    // update product quantity
		product.setQuantity(quantity);
		product.setUnitOfMeasure(unitOfMeasure);
	}

	public Product getProductByName(String name) {  // get product by name
		for (Product product : products) {  // iterate through the list
			if (product.getName().equals(name)) {   // if the product name matches the name entered by the user
				return product;
			}
		}
		return null;
	}

	public List<Product> getProducts() {    // get all products
		return products;
	}
	
	public void showHistory(Product product) {  // show purchase history
		System.out.println("Purchase history for " + product.getName() + ":");
		for (String purchaseHistory : product.getPurchaseHistory()) {   // iterate through the list
			System.out.println(purchaseHistory);
		}
	}
	
	public void addPurchaseHistory(Product product, int quantity) { // add purchase history
        product.addPurchaseHistory(String.valueOf(quantity));   // add the quantity to the purchase history
    }


	
	
	
}
