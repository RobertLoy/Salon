package edu.gcu.cst135.salon;

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
	
	public void addWash(){
		// NEED TO ADD FUNCTIONALITY	
	}
	
	// Data object override methods: toString(), hashCode(), equals(), compareTo()	
	
	public String toString() {
		return "Haircut \tid = " + getServiceId() + " Price = $" + getPrice() + " Length = " + getLength();
	}
}
