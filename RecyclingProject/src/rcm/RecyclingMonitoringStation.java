package rcm;

import java.util.ArrayList;
import java.util.Observable;

import rcm.RecyclingMachine.Activity;

/**
 * Represents recyling management system
 * @author StevenChua
 *
 */

public class RMOS extends Observable{

	private Manager[] managers = new Manager[2];
	private ArrayList<RCM> rcmGroup = new ArrayList<RCM>();
	private ItemType[] itemTypes = new ItemType[2];
	private ArrayList<Item> acceptedItems = new ArrayList<Item>();

	/**
	 * Creates new RMOS with default managers and item types
	 */
	public RMOS(){
		managers[0] = new Manager("admin", "pass");
		managers[1] = new Manager("manager", "password");

		itemTypes[0] = new ItemType("Glass", 1.00);
		itemTypes[1] = new ItemType("Aluminum", 0.75);
	}
