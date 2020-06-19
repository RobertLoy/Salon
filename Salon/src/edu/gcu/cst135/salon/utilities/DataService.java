package edu.gcu.cst135.salon.utilities;

// Interface for the reading and writing of objects to a file
// this will allow persistence between the running of the application
public interface DataService {
	
	abstract void read();
	
	abstract void write();

}
