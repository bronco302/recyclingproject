package rmos;

import java.io.Serializable;


public class TypeofItem implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private double price;

	/**
	 * Creates new item type with given fields
	 * @param name
	 * @param price
	 */
	public TypeofItem(String name, double price){
		this.name = name;
		this.price = price;
	}

	/**
	 * Default constructor
	 */
	public TypeofItem(){
		name = "default";
		price = 0;
	}

	public String getName(){
		return name;
	}

	public double getPrice(){
		return price;
	}

	public void setName(String name){
		this.name = name;
	}

	public void setPrice(double price){
		this.price = price;
	}
}
