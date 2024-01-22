////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 151 Fall 2023
//  Section:  0001
// 
//  Project:  CarLotProject
//  File:     CarLotTesterClass.java
//  
//  Name:     Raegan Durdin
//  Email:    rdurdin@my.waketech.edu
////////////////////////////////////////////////////////////////////////////////

import java.io.FileNotFoundException;

/**
 * CarLotTesterClass (tests the CarLot class)
 *
 * <p/> Bugs: (List any known issues or unimplemented features here)
 * 
 * @author Raegan Durdin
 *
 */
public class CarLotTesterClass
{
	/**
     * Starts the program and tests the constructors and methods of car class
     * @param args command line arguments
     */
	
	public static void main(String[] args) throws FileNotFoundException {
		CarLot lot = new CarLot();
		
		lot.loadFromDisk();
		
		System.out.println("Find Car By ID: " + lot.findCarByIdentifier("coolCar"));
		System.out.println("");
		System.out.println("Car with Best mpg: " + lot.getCarWithBestMPG());
		System.out.println("");
		System.out.println("Car with highest mileage: " + lot.getCarWithHighestMileage());
		System.out.println("");
		System.out.println("Average mpg of lot: " + lot.getAverageMpg());
		System.out.println("");
		System.out.println("Total profit of lot: " + lot.getTotalProfit());
		System.out.println("");
		System.out.println("Cars in lot in order of entry: " + lot.getCarsInOrderOfEntry());
		System.out.println("");
		System.out.println("Sorted cars in lot by mpg: " + lot.getCarsSortedByMPG());
		System.out.println("");
		lot.findCarByIdentifier("elantra").sellCar(30000);
		System.out.println("Elantra now sold: " + lot.getCarsInOrderOfEntry());
		
		lot.saveToDisk();
	}
}
