package edu.gcu.cst135.salon.data;

// An object that will interact with the Grooming class through the Salon class
public class Customer {

	private String name;
	private char gender;

	// TICKET# 123456
	// Create ability to make customer with a name
	// Updated 06/15/2020 by Robert Loy
	public Customer(String name) {
		this.name = name;
	}

	// TICKET# 123456
	// Create ability to print customer's name
	// Updated 06/15/2020 by Robert Loy
	public String toString() {
		return "Customer: " + name;
	}
	
}
