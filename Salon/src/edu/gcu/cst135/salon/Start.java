package edu.gcu.cst135.salon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import edu.gcu.cst135.salon.data.BeardTrim;
import edu.gcu.cst135.salon.data.Haircut;
import edu.gcu.cst135.salon.data.Product;
import edu.gcu.cst135.salon.data.Service;
import edu.gcu.cst135.salon.utilities.DataService;

public class Start implements DataService {

	// test pe
	
	static final File file = new File("objects.txt");
	static Salon salon; 
	

	public static void main(String [] args) {

		Start start = new Start();
		//start.readFile();
		salon = new Salon();
		salon.start();
		start.write();
	}

	@Override
	public void read() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write() {
		// TODO Auto-generated method stub
		// store Salon
		try {
			FileWriter wr = new FileWriter(file, false);
			storeSalonObject(wr);
			storeServiceObjects(wr);
			storeProductObjects(wr);
			wr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// products
	
	}
	
	private void storeSalonObject(FileWriter writer) throws IOException {

		System.out.println("Writing our Salon Object to File");
		writer.write(salon + System.lineSeparator());
	}
	
	private void storeServiceObjects(FileWriter writer) throws IOException {

		for (Service s : salon.getServices()) {
			if (s.getClass().getSimpleName().equals("BeardTrim")) {
				System.out.println("Writing our BeardTrim Object to File");
				writer.write(s + System.lineSeparator());
			}
			if (s.getClass().getSimpleName().equals("Haircut")) {
				System.out.println("Writing our Haircut Object to File");
				writer.write(s + System.lineSeparator());
			}
		}
		
	}
	private void storeProductObjects(FileWriter writer) throws IOException {
		for (Product prod : salon.getCatalog().getProducts()) {
			System.out.println("Writing our Product Object to File");
			writer.write(prod + System.lineSeparator());		
			
		}
		
	}


}
