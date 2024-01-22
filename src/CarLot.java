////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 151 Fall 2023
//  Section:  0001
// 
//  Project:  CarLotProject
//  File:     CarLot.java
//  
//  Name:     Raegan Durdin
//  Email:    rdurdin@my.waketech.edu
////////////////////////////////////////////////////////////////////////////////

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * CarLot class that stores all the cars information that are in the lot
 *
 * <p/> Bugs: (List any known issues or unimplemented features here)
 * 
 * @author Raegan Durdin
 *
 */
public class CarLot extends ArrayList<Car>
{
	
	/**
     * Default constructor
     */
	
	CarLot() {
		
	}
	
	/**
     * Adds a car to the car lost and storing it to carlot array "theCars"
     * @param the String id of car, the int mileage, int mpg, double cost, and double salesPrice
     */
	public void addCar(String id, int mileage, int mpg, double cost, double salesPrice) {
		Car newCar = new Car(id, mileage, mpg, cost, salesPrice);
		add(newCar);
	}
	
	
	/**
     * Marks car as sold and sets the price sold for
     * @param String id of the car, and double price that the car was sold for
     */
	public void sellCar(String identifier, double priceSold) {
		try {
			for (int i = 0; i < size(); i ++) {
				if (get(i).getId() == identifier) {
					get(i).sellCar(priceSold);
				}
			}
		}
		catch (Exception IllegalArgumentException) {
			System.out.println("Error");
		}
	}
	
	/**
     * Finds the car based off of its id and returns correct car
     * @param String id of the car
     * @return Car that is found or null
     */
	public Car findCarByIdentifier(String identifier) {
		Car theCar = null;
		for (int i = 0; i < size(); i ++) {
			if (get(i).getId().equals(identifier)) {
				theCar = get(i);
			}
		}
		return theCar;
	}
	
	/**
     * Finds car in lot with best mpg
     * @return the Car with best mpg
     */
	public Car getCarWithBestMPG() {
		Car currentCar = get(0);
		for (int i = 1; i < size(); i ++) {
			if (get(i).compareMPG(currentCar) > 0) {
				currentCar = get(i);
			}
		}
		
		return currentCar;
	}
	
	/**
     * Finds car in lot with best mileage
     * @return the Car with best mileage
     */
	public Car getCarWithHighestMileage() {
		Car currentCar = get(0);
		for (int i = 1; i < size(); i ++) {
			if (get(i).compareMileage(currentCar) > 0) {
				currentCar = get(i);
			}
		}
		
		return currentCar;
	}
	
	/**
     * Finds the average mpg of cars in lot
     * @return the Double average mpg of cars
     */
	public double getAverageMpg() {
		double total = 0;
		for (int i = 0; i < size(); i ++ ) {
			total += get(i).getMileage();
		}
		
		return total / size();
	}
	
	/**
     * Finds the total profit of all sold cars
     * @return the Double total profit
     */
	public double getTotalProfit() {
		double total = 0;
		for (int i = 0; i < size(); i ++) {
			if (get(i).getPriceSold() != 0) {
				total += get(i).getPriceSold();
			}
		}
		
		return total;
	}
	
	/**
     * Gets the list of cars and returns
     * @return ArrayList<Car> of cars in lot
     */
	public ArrayList<Car> getCarsInOrderOfEntry() {
		return this;
	}
	
	/**
     * Gets the list of cars sorted by mpg
     * @return ArrayList<Car> of cars in lot sorted by mpg
     */
	public ArrayList<Car> getCarsSortedByMPG() {
		ArrayList<Car> cars = new ArrayList<Car>();
		cars = getCarsInOrderOfEntry();
		for (int i = 0; i < size(); i ++) {
			for (int k = i; k < cars.size(); k ++) {
				if (get(i).compareMPG(cars.get(k)) < 0) {
					Car sub = get(i);
					cars.set(i, cars.get(k));
					cars.set(k, sub);
				}
			}
		}
		return cars;
	}
	
	/**
     * Saves the cars in the CarLot to file "carlot.csv"
     */
	public void saveToDisk() {
		Scanner input = null;
		try
		{
			File f = new File("carlot.csv");
			input = new Scanner(f);
			PrintWriter writer = new PrintWriter(f);
			
			for (int i = 0; i < size(); i ++) {
				writer.print(get(i).getId());
				writer.print(",");
				writer.print(get(i).getMileage());
				writer.print(",");
				writer.print(get(i).getMpg());
				writer.print(",");
				writer.print(get(i).getCost());
				writer.print(",");
				writer.print(get(i).getSalesPrice());
				writer.print(",");
				writer.print(get(i).getSold());
				writer.print(",");
				writer.print(get(i).getPriceSold());
				writer.print(",");
				writer.print(get(i).getProfit());
				writer.println("");
			}
			
			writer.close();
			
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
     * Loads cars from file "carlot.csv" into the lot with correct information
     */
	public void loadFromDisk() {
		Scanner input = null;
		try
		{
			File f = new File("carlot.csv");
			input = new Scanner(f);
			
			while (input.hasNext()) {
				String stats = input.next();
				String[] carStats = stats.split(",");
				Car savedCar = new Car(carStats[0], Integer.parseInt(carStats[1]), Integer.parseInt(carStats[2]), Double.parseDouble(carStats[3]), Double.parseDouble(carStats[4]));
				add(savedCar);
				if (carStats[5].equalsIgnoreCase("TRUE")) {
					for (int i = 0; i < size(); i ++) {
						if (get(i).getId() == savedCar.getId()) {
							get(i).sellCar(Double.parseDouble(carStats[6]));
						}
					}
				}
			}
			
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
