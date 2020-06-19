package edu.gcu.cst135.salon;

import java.util.ArrayList;
import java.util.List;

import edu.gcu.cst135.salon.data.Product;
import edu.gcu.cst135.salon.utilities.UserInterface;

// A container class that will contain all the product objects
public class Catalog {

	// Class level Attributes go here
	// e.g. private int number;
	private List<Product> products = new ArrayList<>();
	
	public List<Product> getProducts(){
		return products;
	}
	
	// Appropriate GETTER/SETTER for private attributes
	public void setProducts() {
		UserInterface.displayHeader("Add Product to Catalog");
		String brand = UserInterface.getStringValue("Brand: ");
		String type = UserInterface.getStringValue("Type: ");
		double price = UserInterface.getDoubleValue("Cost: ",999.99);
		products.add(new Product(brand, type, price));
	}
	
	public void getProductList() {
		Object [] options = products.toArray();
		System.out.println(options.length);
		UserInterface.displayIntMenu("Products",options);
	}
	
	public void searchProducts() {
		Object [] options = products.toArray();
		System.out.println(options.length);
		UserInterface.displayIntMenu("Products",options);
	}
	
	public Product getProduct(String type) {
		
		ArrayList<Product> subProducts = new ArrayList<>();
		for(Product prod : products) 
			if(prod.getType().equals(type)) 
				subProducts.add(prod);
		
		Object [] options = subProducts.toArray();
		int option = UserInterface.displayIntMenu("Products",options);
		return subProducts.get(option+1);

	}
	
	// Data object override methods: toString(), hashCode(), equals(), compareTo()

}
