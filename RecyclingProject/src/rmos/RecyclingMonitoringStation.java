package rmos;

import java.util.ArrayList;
import java.util.Observable;

import rcm.RecyclingMachine.Activity;

/**
 * Works on collecting information on RecyclingMachine and statistics for Machines
 * @author StevenChua
 *
 */

public class RecyclingMonitoringStation extends Observable{

	private Manager[] managers = new Manager[2];
	private Item[] itemTypes = new ItemType[2];
	private ArrayList<Item> acceptedItems = new ArrayList<Item>();

	/**
	 * Creates new RMOS with default managers and item types
	 */
	public RecyclingMonitoringStation(){
		managers[0] = new Manager("admin", "pass");
		managers[1] = new Manager("manager", "password");

		itemTypes[0] = new ItemType("Glass", 1.00);
		itemTypes[1] = new ItemType("Aluminum", 0.75);
	}
	
	public boolean authenticate(String username, String password){
		for (Manager m: managers){ 
			if(m.getUsername().equals(username) && m.getPassword().equals(password)) return true;
		}
		return false;
	}

	public ArrayList<RCM> getRCMGroup(){
		return rcmGroup;
	}
	
	
