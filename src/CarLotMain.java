////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 151 Fall 2023
//  Section:  0001
// 
//  Project:  CarLotProject
//  File:     CarLotMain.java
//  
//  Name:     Raegan Durdin
//  Email:    rdurdin@my.waketech.edu
////////////////////////////////////////////////////////////////////////////////

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * CarLotMain class (the main inteface of the program)
 *
 * <p/> Bugs: (List any known issues or unimplemented features here)
 * 
 * @author Raegan Durdin
 *
 */
public class CarLotMain
{
	/**
     * Starts the program and tests the constructors and methods of car class
     * @param args command line arguments
	 * @throws IOException 
     */
	public static void main(String[] args) throws IOException {
		/**
	     * variables for input, carLot and user option is created, loads the previous cars
	     * from the csv file into the lot
	     */
		Scanner input = new Scanner(System.in);
		CarLot carLot = new CarLot();
		carLot.loadFromDisk();
		System.out.println("Welcome to the CarLot Manager!");
		System.out.println("------------------------------");
		int option = 0;
		
		/**
	     * do while loop, for each user input given 0-8 it responds appropriately.
	     */
		do {
			// prints the menu out again
			option = printMenu(input);
						
			if (option == 0) {
				// breaks out of program
				break;
			}
			else if (option == 1) {
				// for option one, it takes the users input and makes a new car to add to the CarLot
				System.out.print("Enter an identifier for the car: " );
				String id = input.next();
				System.out.print("Enter the mileage of the car: ");
				int mileage = input.nextInt();
				System.out.print("Enter the mpg of the car: ");
				int mpg = input.nextInt();
				System.out.print("Enter the cost of the car: ");
				double cost = input.nextDouble();
				System.out.print("Enter the sales price of the car: ");
				double salesPrice = input.nextDouble();
				
				carLot.addCar(id, mileage, mpg, cost, salesPrice);
				System.out.println("Car was successfully added to the lot");
				System.out.println("");
			}
			else if(option == 2) {
				// for option two, sells a car that the user inputs and provides correct feedback
				System.out.print("Enter the id of the car: ");
				String id = input.next();
				boolean sold = false;
				while (sold == false) {
					if (carLot.findCarByIdentifier(id) != null) {
						System.out.print("Enter the price the car sold for: ");
						double priceSold = input.nextDouble();
						carLot.findCarByIdentifier(id).sellCar(priceSold);
						System.out.println(id + " was sold for " + priceSold);
						sold = true;
					}
					else {
						System.out.print("Invalid id, please try again: ");
						id = input.next();
					}
				}
				System.out.println("");
			}
			else if (option == 3) {
				// for option three it returns the CarLot and prints the cars out appropriately
				for (int i = 0; i < carLot.size(); i ++) {
					System.out.println(carLot.getCarsInOrderOfEntry().get(i));
				}
				System.out.println("");
			}
			else if (option == 4) {
				// for option 4, it sorts the cars by mpg and prints
				for (int i = 0; i < carLot.size(); i ++) {
					System.out.println(carLot.getCarsSortedByMPG().get(i));
				}
				System.out.println("");
			}
			else if (option == 5) {
				// for option five it prints the car with best mpg
				System.out.println(carLot.getCarWithBestMPG());
				System.out.println("");
			}
			else if (option == 6) {
				// for option six it prints the car with highest mileage
				System.out.println(carLot.getCarWithHighestMileage());
				System.out.println("");
			}
			else if (option == 7) {
				// for option seven it gets average mpg of all cars in the lot
				System.out.println(carLot.getAverageMpg());
				System.out.println("");
			}
			else if (option == 8) {
				// for option eight it gets the total profit made from the lot
				System.out.println(carLot.getTotalProfit());
				System.out.println("");
			}
			else {
				// if the user inputs a number not one of the choices, prints try again
				System.out.print("Invalid Input, please try again. \n");
				System.out.println("");
			}
			
			
		} while (option != 0);
		
		// saves the current carLot to the csv file
		carLot.saveToDisk();
		
		Desktop desktop = Desktop.getDesktop();
		File f = new File("carlot.csv");
		desktop.open(f);
		
	}
	
	/**
     * prints the main menu inteface that the user interacts with\
     * @param Scanner input, input that the user gives
     * @return int that stores the users input information
     */
	public static int printMenu(Scanner input) {
		int i = 1;
		System.out.println("[0] Exit");
		System.out.println("[1] Add a car to inventory");
		System.out.println("[2] Sell a car from inventory");
		System.out.println("[3] List inventory by order of acqusition");
		System.out.println("[4] List Inventory From Best MPG to Worst MPG");
		System.out.println("[5] Display car with best MPG");
		System.out.println("[6] Display car with the highest mileage");
		System.out.println("[7] Display overall MPG for the entire inventory");
		System.out.println("[8] Display profit for all sold cars");
		System.out.print("Enter a number from 0 to 8 : ");
		try {
			return input.nextInt();
		}
		catch (InputMismatchException e) {
			System.out.println("Input is incorrect, please try again. \n");
			input.nextLine();
			return printMenu(input);
		}
	}
}
