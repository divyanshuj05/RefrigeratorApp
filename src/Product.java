import java.util.ArrayList;
import java.util.List;

// 10-04-2023 Divyanshu Jain 102097010  PATHLOCK  Due Date: 2023-04-13  Product.java
public class Product {
	private String name;
	private int quantity;
	
	private String unitOfMeasure;
	private List<String> purchaseHistory = new ArrayList<>();

	public Product(String name, int quantity, String unitOfMeasure) {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("Name cannot be empty");
		}
		this.name = name;
		if (quantity < 0) {
			throw new IllegalArgumentException("Quantity cannot be negative");
		}
		this.quantity = quantity;
		if (unitOfMeasure == null || unitOfMeasure.trim().isEmpty()) {
			throw new IllegalArgumentException("Unit of measure cannot be empty");
		}
		this.unitOfMeasure = unitOfMeasure;
		
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if (quantity < 0) {
			throw new IllegalArgumentException("Quantity cannot be negative");
		}
		this.quantity -= quantity;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}
	public void setUnitOfMeasure(String unitOfMeasure) {
		if (unitOfMeasure == null || unitOfMeasure.trim().isEmpty()) {
            throw new IllegalArgumentException("Unit of measure cannot be empty");
        }
        this.unitOfMeasure = unitOfMeasure;
    }
	
	public void addPurchaseHistory(String purchaseHistory) {
		if (purchaseHistory == null || purchaseHistory.trim().isEmpty()) {
            throw new IllegalArgumentException("Purchase history cannot be empty");
        }
		this.purchaseHistory.add(purchaseHistory);
	}

	public List<String> getPurchaseHistory() {
		return purchaseHistory;
	}





	

}
