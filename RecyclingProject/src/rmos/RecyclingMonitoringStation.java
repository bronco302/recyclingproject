package rmos;

import java.util.ArrayList;

import rcm.*;
import rmos.Machine.Status;

public class RecyclingMonitoringStation {
	
	private RecyclingMachine registeredMachines[];
	private int objectCounter = 0;
	private static final long serialVersionUID = 1L;
	private Admin[] managers = new Admin[2];
	private ArrayList<Machine> rcmGroup = new ArrayList<Machine>();
	private TypeofItem[] itemTypes = new TypeofItem[2];
	private ArrayList<Item> acceptedItems = new ArrayList<Item>();

	private double totalAluminum;
	private double totalGlass;

	private transient String metric;
	private transient String timeframe;
	private transient String chartTitle;
	

	/**
	 * Creates new RMOS with default managers and item types
	 */
	public RecyclingMonitoringStation(){
		
		registeredMachines = new RecyclingMachine[10];
		managers[0] = new Admin("admin", "pass");
		managers[1] = new Admin("manager", "password");

		itemTypes[0] = new TypeofItem("Glass", 1.00);
		itemTypes[1] = new TypeofItem("Aluminum", 0.75);

		totalAluminum = 80;
		totalGlass = 20;

		metric = "Value";
		timeframe = "Day";
		chartTitle = "Value By Day";
	}

	/**
	 * Verifies username and password
	 * @param username
	 * @param password
	 * @return True if username and password match a manager in the system, False otherwise
	 */
	public boolean authenticate(String username, String password){
		for (Admin m: managers){ 
			if(m.getUsername().equals(username) && m.getPassword().equals(password)) return true;
		}
		return false;
	}

	public ArrayList<Machine> getRCMGroup(){
		return rcmGroup;
	}

	/**
	 * Adds RecyclingMachine to RCM group
	 * @param RecyclingMachine
	 */
	public void addMachine(){
		//rcmGroup.add(RecyclingMachine);
		if(objectCounter>0){
			registeredMachines[objectCounter] = new RecyclingMachine();
			objectCounter++;
			
		}
		else{
			registeredMachines[objectCounter] = new RecyclingMachine();
			objectCounter++;
		}
		//new RecyclingMachine();
	}
	
	public void addExistingMachine(RecyclingMachine machine){
		if(objectCounter>0){
			registeredMachines[objectCounter] = machine;
			objectCounter++;
			
		}
		else{
			registeredMachines[objectCounter] = machine;
			objectCounter++;
		}
	}
	
	public void getMachineIDS(){
		for (int i=0;i<objectCounter;i++){
				if(registeredMachines[i].getGroup()==1){
				System.out.println(registeredMachines[i].getMachineID());	
				}
		}
	}
	
	public void print(int id){
		System.out.println(queryMachine(id));
	}
	
	public int queryMachine(int id){
		for (int i=0;i<objectCounter;i++){
			if(registeredMachines[i].getMachineID()==id){
				return i;
			}
		}
		return id;
	}
	/**
	 * Gets rid of Machine with given id from RCM group
	 * @param id
	 */
	public void removeMachine(String id){
		Machine machineToRemove = null;
		for(Machine m : rcmGroup){
			if (m.getID().equals(id)) machineToRemove = m;
		}
		rcmGroup.remove(machineToRemove);
	
	}

	/**
	 * Changes status of RCM with given id
	 * @param id
	 * @param status new status
	 */
	public void changeRCMstatus(String id, Status status){
		int index = 0;
		for(Machine m : rcmGroup){
			if (m.getID().equals(id)) break;
			index++;
		}
		if (index < rcmGroup.size()){
			rcmGroup.get(index).setStatus(status);
		
		}
	}

	/**
	 * Calculates number of active RCMs in RCM group
	 * @return
	 */
	public int getNumActiveRCMs(){
		int num = 0;
		for (Machine machine: rcmGroup){
			if (machine.getStatus() == Status.ACTIVE) num++;
		}
		return num;
	}

	public ArrayList<Item> getAcceptedItems(){
		return acceptedItems;
	}

	/**
	 * Adds item to accepted items list
	 * @param newItem
	 */
	public void addItem(Item newItem){
		acceptedItems.add(newItem);
		rcmGroup.get(0).getAcceptedItems().add(newItem);

	}

	/**
	 * Removes item from accepted items list
	 * @param name
	 */
	public void removeItem(String name){
		Item itemToRemove = null;
		for(Item i : acceptedItems){
			if (i.getName().equals(name)) itemToRemove = i;
		}
		acceptedItems.remove(itemToRemove);
		rcmGroup.get(0).getAcceptedItems().remove(itemToRemove);
	
	}

	public TypeofItem getGlass(){
		return itemTypes[0];
	}

	public TypeofItem getAluminum(){
		return itemTypes[1];
	}

	public TypeofItem[] getItemTypes(){
		return itemTypes;
	}

	/**
	 * Changes price of glass items
	 * @param price
	 */
	public void setGlassPrice(double price){
		itemTypes[0].setPrice(price);

	}

	/**
	 * Changes price of aluminum items
	 * @param price
	 */
	public void setAluminumPrice(double price){
		itemTypes[1].setPrice(price);

	}

	public double getTotalAluminumWeight(){
		return totalAluminum;
	}

	public double getTotalGlassWeight(){
		return totalGlass;
	}

	public void setItemStatistics(){
		totalAluminum = 60;
		totalGlass = 40;

	}

	public String getMetric() {
		return metric;
	}

	public String getTimeframe() {
		return timeframe;
	}

	public String getChartTitle() {
		return chartTitle;
	}

	public void setChart(String title, String metric, String timeframe){
		chartTitle = title;
		this.metric = metric;
		this.timeframe = timeframe;

	}

	public ArrayList<String> getIDs(){
		ArrayList<String> ids = new ArrayList<String>();
		for(Machine m: rcmGroup){
			ids.add(m.getID());
		}
		return ids;
	}

	public ArrayList<Double> getValues(){
		ArrayList<Double> values = new ArrayList<Double>();
		for(Machine m: rcmGroup){
			values.add(1000 + Double.parseDouble(m.getID()));
		}
		return values;
	}

}
	

