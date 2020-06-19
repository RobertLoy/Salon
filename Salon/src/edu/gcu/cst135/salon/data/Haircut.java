package edu.gcu.cst135.salon.data;

// Concrete class in the Grooming/Haircut family
// The extends keyword makes this a child of Haircut
public class Haircut extends Grooming {
	
	private Wash wash;

	// This is the default constructor that Java creates
	// Once the programmer makes their own Constructor,
	// the default one is no longer available 
	// unless the programmer makes their own like the one below
	public Haircut(double price, double length) {
		super(price, length);  // Makes an object parent class - Haircut
	}
	
	public Haircut(double price, double length, Wash wash) {
		super(price, length);  // Makes an object parent class - Haircut
		this.wash = wash;
	}
	
	// TICKET# 123457
	// Manage the ability to update the wash object
	// Updated 06/15/2020 by Robert Loy
	public void addWash() {
		System.out.println("Adding a wash to the haircut.");
	}
	
	// Data object override methods: toString(), hashCode(), equals(), compareTo()	
	
	public String toString() {
		return "Haircut|" + getServiceId() + "|" + getPrice() + "|" + getLength();
	}
}
