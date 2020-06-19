package edu.gcu.cst135.salon;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.gcu.cst135.salon.data.BeardTrim;
import edu.gcu.cst135.salon.data.Haircut;
import edu.gcu.cst135.salon.data.Product;
import edu.gcu.cst135.salon.data.Service;
import edu.gcu.cst135.salon.data.Wash;
import edu.gcu.cst135.salon.utilities.UserInterface;

// Starting class where we will tie Customer objects to
// Grooming (BeardTrim and HairTrim) objects
public class Salon {

	Scanner sc = new Scanner(System.in);

	private String name;
	private ArrayList<Service> services = new ArrayList<>();
	private static Catalog catalog = new Catalog();

	public Salon() {
		this.name = "DEFAULT";
	}

	public Salon(String name) {
		this.name = name;
	}
	
	public ArrayList<Service> getServices(){
		return services;
	}
	
	public void setServices(BeardTrim s){
		services.add(s);
	}
	public void setServices(Haircut s){
		services.add(s);
	}
	
	public Catalog getCatalog(){
		return catalog;
	}
	
	public void setCatalog(Product p){
		catalog.getProducts().add(p);
	}

	public void start() {

		UserInterface.displayHeader("Welcome to " + name + " SALON");

		main:	// Name this loops we can break out at the appropriate time
			do {
				String [] options = {"Add Service", "Add Product", "List Products", "List all services", "List beard services", "List haircut services", "Search for Service", "Search for Product"};
				int option = UserInterface.displayIntMenu("Service",options);

				switch (option) {
				case 1:
					addService();
					break;
				case 2:
					catalog.setProducts();
					break;
				case 3:
					catalog.getProductList();
					break;
				case 4:
					displayService();
					break;
				case 5:
					displayService("BeardTrim");
					break;
				case 6:
					displayService("Haircut");
					break;
				case 7:
					searchServices();
					break;
				case 8:
					catalog.searchProducts();
					break;
				default:
					exitApplication();
					break main;
				}
			} while (true);
	}

	private void exitApplication() {
		System.out.println("THANK YOU!");
	}

	private void addService() {
		String [] options = {"BeardTrim", "Haircut"};
		int serviceID = UserInterface.displayIntMenu("Service",options);

		double price = UserInterface.getDoubleValue("Price of service: ",999.99);
		double length = UserInterface.getDoubleValue("Length of cut: ",999.99);

		switch(serviceID) {
		case 1:
			doBeardTrim(price, length);
			break;
		case 2: 
			doHaircut(price, length);
			break;
		}
	}

	private void doBeardTrim(double price, double length) {
		boolean useCream = UserInterface.getBooleanValue("Add Shaving Cream? ");
		if (useCream) {
			Product prod = catalog.getProduct("ShavingCream");
			services.add(new BeardTrim(price,length,useCream,prod));
		}
		else {
			services.add(new BeardTrim(price,length));
		}
	}

	private void doHaircut(double price, double length) {
		boolean getWash = UserInterface.getBooleanValue("Include a wash? ");
		if (getWash) {
			int temp = UserInterface.getIntValue("What water temperature: ", 150);
			boolean cond = UserInterface.getBooleanValue("Use conditioner? ");
			Wash wash = new Wash(temp, cond);
			services.add(new Haircut(price,length,wash));
		}
		else {
			services.add(new Haircut(price,length));
		}
	}

	private void displayService() {

		Object [] options = services.toArray();
		System.out.println(options.length);
		UserInterface.displayIntMenu("Service",options);
	}

	private void searchServices() {
		String [] menuOptions = {"Price", "Length"};
		int serviceID = UserInterface.displayIntMenu("Search Critera",menuOptions);		

		ArrayList<Service> subServices = new ArrayList<>();

		switch (serviceID) {
		case 1:
			double maxPrice = UserInterface.getDoubleValue("Highest Price: ",999.99);
			double minPrice = UserInterface.getDoubleValue("Lowest Price: ",999.99);
			for(Service svc : services) 
				if(svc.getPrice() >= minPrice && svc.getPrice() <= maxPrice) 
					subServices.add(svc);
			break;
		case 2:
			double maxLength = UserInterface.getDoubleValue("Longest Cut: ",999.99);
			double minLength = UserInterface.getDoubleValue("Shortest Cut: ",999.99);
			for(Service svc : services) 
				if(svc.getPrice() >= minLength && svc.getPrice() <= maxLength) 
					subServices.add(svc);
			break;
		}

		Object [] options = subServices.toArray();
		System.out.println(options.length);
		UserInterface.displayIntMenu("FOUND SERVICE ITEMS",options);
	}

	private void displayService(String svcType) {
		ArrayList<Service> subServices = new ArrayList<>();
		for(Service svc : services) 
			if(svc.getClass().getSimpleName().equals(svcType)) 
				subServices.add(svc);

		Object [] options = subServices.toArray();
		System.out.println(options.length);
		UserInterface.displayIntMenu(svcType.toUpperCase() + " SERVICE LIST",options);
	}

	// Data object override methods: toString(), hashCode(), equals(), compareTo()
	@Override
	public String toString() {
		return "Salon|" + name;
	}

}
