////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 151 Fall 2023
//  Section:  0001
// 
//  Project:  CarLotProject
//  File:     Car.java
//  
//  Name:     Raegan Durdin
//  Email:    rdurdin@my.waketech.edu
////////////////////////////////////////////////////////////////////////////////

/**
 * Car class that holds information about the car
 *
 * <p/> Bugs: (List any known issues or unimplemented features here)
 * 
 * @author Raegan Durdin
 *
 */
public class Car
{
	private String id = "";
	private int mileage;
	private int mpg;
	private double cost;
	private double salesPrice;
	private boolean sold;
	private double priceSold;
	private double profit;
	
	/**
     * Default constructor
     */
	
	Car() {
		this.id = "newCar";
		this.mileage = 100000;
		this.mpg = 30;
		this.cost = 10000;
		this.salesPrice = 15000;
	}
	
	/**
     * Constructor used when creating a new Car that will be added to a CarLot
     * @param id, mileage, mpg, cost, salesPrice
     */
	
	Car(java.lang.String id, int mileage, int mpg, double cost, double salesPrice) {
		this.id = id;
		this.mileage = mileage;
		this.mpg = mpg;
		this.cost = cost;
		this.salesPrice = salesPrice;
	}
	
	/**
     * Creates string reprsentation and returns it
     * @return a human-consumable and well-formatted representation of this Car instance as a String
     */
	public String toString() {
		if (sold) {
			return ("\n" + id + " has a Mileage of " + mileage + ", MPG " + mpg + " Sold: Yes" + ", Cost: " + cost + ", "
					+ "Sales price: " + salesPrice + ", Sold For " + priceSold + ", Profit: " + profit);	
		}
		else {
			return ("\n" + id + " has a Mileage of " + mileage + ", MPG " + mpg + " Sold: No" + ", Cost: " + cost + ", "
					+ "Sales price: " + salesPrice + ", Sold For " + priceSold + ", Profit: " + profit);	
		}
	}
	
	/**
     * Marks car as sold and updates appropriate values
     * @param double priceSold, price that the car was sold for
     */
	public void sellCar(double priceSold) {
		sold = true;
		this.priceSold = priceSold;
		profit = priceSold - cost;
	}
	
	public boolean isSold() {
		if (sold) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
     * Compares the miles per gallon of two cars
     * @return int comparision of mpgs
     * @param Car otherCar, the other car we are comparing
     */
	public int compareMPG(Car otherCar) {
		return this.mpg - otherCar.mpg;
	}
	
	/**
     * Compares the miles of two cars
     * @return an int comparision of miles
     * @param Car otherCar, the other car we are comparing
     */
	public int compareMileage(Car otherCar) {
		return this.mileage - otherCar.mileage;
	}
	
	/**
     * Compares the sales prices of two cars
     * @return a double comparision of sales prices
     * @param Car otherCar, the other car we are comparing
     */
	public double compareSalesPrice(Car otherCar) {
		return this.salesPrice - otherCar.salesPrice;
	}
	
	/**
     * Getters and setters for each of the variables in the car class
     * @return double sellprice, double profit, double sales price, boolean sold, int mileage, int mpg, string id, double cost
     * @param double priceSold, double cost, String id, int mileage, int mpg, double price sold, double profit, double sales price, boolean sold
     */
	public double getCost() {
		return this.cost;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public int getMileage() {
		return this.mileage;
	}
	
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	
	public int getMpg() {
		return this.mpg;
	}
	
	public void setMpg(int mpg) {
		this.mpg = mpg;
	}
	
	public double getPriceSold() {
		return this.priceSold;
	}
	
	public void setPriceSold(double priceSold) {
		this.priceSold = priceSold;
	}
	
	public double getProfit() {
		return this.profit;
	}
	
	public void setProfit(double profit) {
		this.profit = profit;
	}
	
	public double getSalesPrice() {
		return this.salesPrice;
	}
	
	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}
	
	public void setSold(boolean sold) {
		this.sold = sold;
	}
	
	public boolean getSold() {
		return this.sold;
	}
	
	
}
