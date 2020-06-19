package edu.gcu.cst135.salon.data;

import java.util.ArrayList;

import edu.gcu.cst135.salon.Style;

// Abstract parent of HairTrim and BeardTrim and Child of Grooming
public abstract class Grooming extends Service {    	

	// Class level Attributes go here
	// e.g. private int number;
	private ArrayList<Style> styles = new ArrayList<>();
	private  Equipment equipment;
	private double length;
	private ArrayList<Product> products = new ArrayList<>();
	
	
	// Constructor Grooming, this is the same one that is 
	// created automatically within Java - no parameters.
	public Grooming(double price, double length) {
		super(price);  // Makes an object parent class - Grooming
		this.length = length;
	}
	
	public Grooming(double price, double length, Product product) {
		super(price);  // Makes an object parent class - Grooming
		this.length = length;
		products.add(product);
	}
	
	// Appropriate GETTER/SETTER for private attributes
	// SETTERS can implement data logic and rules
	// SETTERS can also be omitted to establish a final public attribute
	public double getLength() {
		return this.length;
	}
	
	// Data object override methods: toString(), hashCode(), equals(), compareTo()
}
