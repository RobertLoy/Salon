package edu.gcu.cst135.salon.data;

//Object needed within Grooming (COMPOSITION/HAS-A)
public class Product {

	// Class level Attributes go here
	// e.g. private int number;
	public String brand;
	public String type;
	public double price;
	
	
	public Product(String brand, String type, double price) {
		super();
		this.brand = brand;
		this.type = type;
		this.price = price;
	}
	
	// Appropriate GETTER/SETTER for private attributes
	// SETTERS can implement data logic and rules
	// SETTERS can also be omitted to establish a final public attribute
	public String getBrand() {
		return brand;
	}

	public String getType() {
		return type;
	}

	public double getPrice() {
		return price;
	}	

	// Data object override methods: toString(), hashCode(), equals(), compareTo()
	@Override
	public String toString() {
		return "Product|" + brand + "|" + type + "|" + price;
	}
}
