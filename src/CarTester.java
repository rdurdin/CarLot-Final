////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 151 Fall 2023
//  Section:  0001
// 
//  Project:  CarLotProject
//  File:     CarTester.java
//  
//  Name:     Raegan Durdin
//  Email:    rdurdin@my.waketech.edu
////////////////////////////////////////////////////////////////////////////////

/**
 * Tests the car class
 *
 * <p/> Bugs: (List any known issues or unimplemented features here)
 * 
 * @author Raegan Durdin
 *
 */

public class CarTester
{
	
	/**
     * Starts the program and tests the constructors and methods of car class
     * @param args command line arguments
     */
	
	public static void main(String[] args) {
		
		Car car1 = new Car("test1", 90000, 40, 12500, 20000);
		Car car2 = new Car();
		
		car1.sellCar(19500);
		System.out.println(car1.compareMileage(car2));
		System.out.println(car1.compareMPG(car2));
		System.out.println(car1.compareSalesPrice(car2));
	}
}
