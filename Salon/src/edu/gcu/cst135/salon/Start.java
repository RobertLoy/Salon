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
//maram
	
	static final File file = new File("objects.txt");
	static Salon salon; 

	public static void main(String [] args) {

		Start start = new Start();
		start.readFile();
		salon.start();
		start.writeFile();
	}

	@Override
	public void readFile() {
		System.out.println("Loading previous info...");	
		try {

			// Open file to read
			BufferedReader rd = new BufferedReader(new FileReader(file));
			String line; 
			while ((line = rd.readLine()) != null) {
				String [] part = line.split("\\|");
				switch (part[0]) {
				case "Salon":
					System.out.println("Adding Salon Object");
					salon = new Salon(part[1]);
					break;
				case "BeardTrim":
					System.out.println("Adding BeardTrim Object");
					salon.setServices(new BeardTrim(Double.parseDouble(part[2]),Double.parseDouble(part[3])));
					break;
				case "Haircut":
					System.out.println("Adding Haircut Object");
					salon.setServices(new Haircut(Double.parseDouble(part[2]),Double.parseDouble(part[3])));
					break;
				case "Product":
					System.out.println("Adding Catalog Object");
					salon.getCatalog().getProducts().add(new Product(part[1],part[2],Double.parseDouble(part[3])));
					break;
				}
			} 
			rd.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	@Override
	public void writeFile() {
		try {
			// Open file to writ but do not append (Instead erase)
			FileWriter wr = new FileWriter(file, false);

			salonToFile(wr);
			servicesToFile(wr);
			catalogToFile(wr);

			wr.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	private void salonToFile(FileWriter wr) throws IOException{
		System.out.println("Writing Salon Object");
		wr.write(salon + System.lineSeparator());

	}

	private void servicesToFile(FileWriter wr) throws IOException {
		for (Service s : salon.getServices()) {
			if (s.getClass().getSimpleName().equals("BeardTrim")) {
				System.out.println("Writing BeardTrim Object");
				wr.write(s + System.lineSeparator());
			}
			if (s.getClass().getSimpleName().equals("Haircut")) {
				System.out.println("Writing Haircut Object");
				wr.write(s + System.lineSeparator());
			}
		}
	}

	private void catalogToFile(FileWriter wr) throws IOException {
		for (Product p : salon.getCatalog().getProducts()) {
			wr.write(p + System.lineSeparator());
		}
	}
}
