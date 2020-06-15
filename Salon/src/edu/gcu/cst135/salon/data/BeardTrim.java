package edu.gcu.cst135.salon.data;

import java.util.ArrayList;

//Concrete class in the Grooming/Haircut family
//The extends keyword makes this a child of Haircut
public class BeardTrim extends Grooming {

	// Class level Attributes go here
	// e.g. private int number;
	private boolean useCream;
	
	// This is the default constructor that Java creates
	// Once the programmer makes their own Constructor,
	// the default one is no longer available 
	// unless the programmer makes their own like the one below
	public BeardTrim(double price, double length) {
		super(price, length);  // Makes an object parent class - Haircut
	}
	
	public BeardTrim(double price, double length, boolean cream, Product product) {
		super(price, length, product);  // Makes an object parent class - Haircut
		this.useCream = cream;
	}
	

	// Appropriate GETTER/SETTER for private attributes

	
	
	// Data object override methods: toString(), hashCode(), equals(), compareTo()	
	public String toString() {
		return "BeardTrim|" + getServiceId() + "|" + getPrice()+ "|" + getLength();
	}
	
	
}
