package edu.gcu.cst135.salon.utilities;

import java.util.Scanner;

// A collection of user input and output methods
public class UserInterface {
	
	static Scanner sc = new Scanner(System.in);
	
	////////////
	// Header and Menu functions to display static content
	////////////
	public static void displayHeader(String title) {
		System.out.println();
		System.out.println("++++++++++++++++++++++++++");
		System.out.println("++ " + title.toUpperCase());		
		System.out.println("++++++++++++++++++++++++++");
		System.out.println();
	}
	
	public static void displayMenu(String title, Object [] options) {
		displayHeader(title + " menu");
		for (Object opt : options) {
			System.out.println(opt.toString().toUpperCase());
		}
	}
	
	public static int displayIntMenu(String title, Object [] options) {
		displayHeader(title + " menu");
		int counter = 1;
		for (Object opt : options) {
			System.out.println(counter++ + "] " + opt.toString().toUpperCase());
		}
		return getIntValue("Pick your option [0 = Return]: ", options.length);

	}
	
	////////////
	// Input functions to get and validate input from the user
	////////////
	public static String getStringValue(String message) {
		System.out.println(message);
		return sc.nextLine();
	}
	
	public static int getIntValue(String message, int high) {
		try {
			System.out.println(message);
			int value = Integer.parseInt(sc.nextLine());
			if (value < 0 || value > high) {
				throw new Exception();
			}
			return value;
		} catch(Exception e) {
			System.out.println("Bad User Input");
			return 0;
		}
	}
	
	public static double getDoubleValue(String message, double high) {
		try {
			System.out.println(message);
			double value = Double.parseDouble(sc.nextLine());
			if (value < 0 || value > high) {
				throw new Exception();
			}
			return value;
		} catch(Exception e) {
			System.out.println("Bad User Input");
			return 0;
		}
	}
	
	public static boolean getBooleanValue(String message) {
		try {
			System.out.println(message + "[true | false] : ");
			return  Boolean.parseBoolean(sc.nextLine());
		} catch(Exception e) {
			System.out.println("Bad User Input");
			return false;
		}
	}

}
