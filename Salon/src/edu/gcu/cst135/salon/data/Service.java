package edu.gcu.cst135.salon.data;

// The grandparent of BeardTrim and HairTrim and the parent of Grooming
// Since this is abstract, we can not make objects of this class
// to get access to the attribute and behaviors in this class
// we need to create objects of concrete child classes (BeardTrim and HairTrim)
public abstract class Service {   			
	
	// Class level Attributes go here
	// e.g. private int number;
	private static int serviceCounter = 1;  	// TODO: LETS TALK ABOUT THIS
	private int serviceId;
	private double price;

	// Constructor Grooming, this is the same one that is 
	// created automatically within Java - no parameters.
	public Service(double price) {
		super();  // Object constructor
		serviceId = serviceCounter++;
		this.price = price;
	}

	// Appropriate GETTER/SETTER for private attributes
	// SETTERS can implement data logic and rules
	// SETTERS can also be omitted to establish a final public attribute
	public int getServiceId() {
		return this.serviceId;
	}
	public double getPrice() {
		return this.price;
	}
	
	// Data object override methods: toString(), hashCode(), equals(), compareTo()	
}
