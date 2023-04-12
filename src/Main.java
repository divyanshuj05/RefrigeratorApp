import org.w3c.dom.ls.LSResourceResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.util.Scanner;

// 10-04-2023 Divyanshu Jain 102097010  PATHLOCK  Due Date: 2023-04-13  Main.java
public class Main {
	
	public static void main(String[] args) {
		Refrigerator refrigerator = new Refrigerator(); // create a new refrigerator
		Scanner scanner = new Scanner(System.in);
		int option = 0;
		do {
			MainMenu();
			option = scanner.nextInt();
			
			switch (option) {
				case 1 -> Insert(scanner, refrigerator);    // insert a new product
				case 2 -> Consumption(scanner, refrigerator);   // consume a product
				case 3 -> CurrentStatus(refrigerator);  // current status
				case 4 -> ShowHistory(refrigerator);    // show purchase history
				case 5 -> System.out.println("Thank you for using the refrigerator app!");  // exit
				default -> System.out.println("Invalid option. Please try again.");
			}
		} while (option != 5);
		scanner.close();
	}
	
	
	
	private static void MainMenu() {
		System.out.println("Welcome to the refrigerator app!");
		System.out.println("Please select an option:");
		System.out.println("1. Insert a new product");
		System.out.println("2. Consume a product");
		System.out.println("3. Current status");
		System.out.println("4. Show purchase history");
		System.out.println("5. Exit");
	}
	private static void Insert(Scanner scanner, Refrigerator refrigerator) {
		System.out.println("Please enter the name of the product:");
        String name = scanner.next();
        System.out.println("Please enter the quantity of the product:");
        int quantity = scanner.nextInt();
        System.out.println("Enter product type - (units, grams, liters):");
		String unitOfMeasure = scanner.next();
		
        Product product = new Product(name, quantity, unitOfMeasure);   // create a new product
        refrigerator.addProduct(product);   // add the product to the refrigerator
		refrigerator.addPurchaseHistory(product, quantity); // add the purchase history to the product
	}
	private static void Consumption(Scanner scanner, Refrigerator refrigerator) {
		System.out.println("Please enter the name of the product:");
        String name = scanner.next();
        System.out.println("Please enter the quantity of the product:");
        int quantity = scanner.nextInt();
		
        
        Product product = refrigerator.getProductByName(name);
        if (product!= null) {   // if the product exists
			refrigerator.updateProductQuantity(product, quantity, product.getUnitOfMeasure());  // update the quantity of the product
			System.out.println( quantity + " " + product.getUnitOfMeasure() + " of " + product.getName() + " consumed.");
			     
        } else {
            System.out.println("Product not found.");
        }
	}
	private static void CurrentStatus(Refrigerator refrigerator) {
		System.out.println("Current status of the refrigerator:");
		refrigerator.getProducts().forEach(product -> {  // for each product in the refrigerator
			System.out.println(product.getName() + " - " + product.getQuantity() + " " + product.getUnitOfMeasure());
		});
	}

	private static void ShowHistory( Refrigerator refrigerator) {
		System.out.println("Purchase history of each item in the refrigerator:");
		refrigerator.getProducts().forEach(product -> {
			System.out.println(product.getName() + " - " + product.getPurchaseHistory() + " " + product.getUnitOfMeasure());
		});
		
	}

	
}




