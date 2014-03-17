package rmos;

import java.sql.Timestamp;
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
	
	public String getMachineIDS(){
		StringBuilder tempBuilder = new StringBuilder();
	
		for (int i=0;i<objectCounter;i++){
				if(registeredMachines[i].getGroup()==1){
					if(i == (objectCounter-1)){
						tempBuilder.append(registeredMachines[i].getMachineID());
					}
					else{
						tempBuilder.append(registeredMachines[i].getMachineID()+",");
					}
				}
		}
	
		return tempBuilder.toString();
		
	}
	
	public double coupon(int id){
		return registeredMachines[queryMachine(id)].coupon();
	}
	
	
	
	public void deleteRCM(int id){
		registeredMachines[queryMachine(id)].setGroup(0);
	}
	
	public void print(int id){
		System.out.println(queryMachine(id));
	}
	
	public boolean isItemValid(int id,String item){
		return registeredMachines[queryMachine(id)].itemValid(item);
	}
	
	public void removeItem(int id,String item){
		registeredMachines[queryMachine(id)].removeItemType(item);
	}
	
	public void addItemType(int id, String item){
		registeredMachines[queryMachine(id)].addItemType(item);
	}
	
	public String getPriceForItem(String item,int id){
		return registeredMachines[queryMachine(id)].getPaymentForItem(item);
	}
	
	public void updatepPriceForItem(String item,int id,double amount){
		registeredMachines[queryMachine(id)].updatePaymentForItem(item, amount);
	}
	public int queryMachine(int id){
		for (int i=0;i<objectCounter;i++){
			if(registeredMachines[i].getMachineID()==id){
				return i;
			}
		}
		return id;
	}
	
	public void setActive(int id){
		registeredMachines[queryMachine(id)].setActive(true);
	}
	public void setInactive(int id){
		registeredMachines[queryMachine(id)].setActive(false);
	}
	
	public RecyclingMachine getRCM(int id){
		return registeredMachines[queryMachine(id)];
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
	public String getLocation(){
		for (int i=0;i<objectCounter;i++){
			return registeredMachines[i].getLocation();
	
		}
		return registeredMachines[0].getLocation();
	}
	
	public String getOperationalStatus(int machineID){
		
		 if(registeredMachines[queryMachine(machineID)].isActive()){
			 return new String("Active");
		 }
		 else{
			 return new String("Not Active");
		 }
	}
	
	public double getMoneyInMachine(int machineID){
		return registeredMachines[queryMachine(machineID)].getAvailableCash(); 
	}
	
	public double getMoneyCapacityInMachine(int machineID){
		return registeredMachines[queryMachine(machineID)].getCashCapacity(); 
	}
	
	public double getWeightForMachine(int machineID){
		return registeredMachines[queryMachine(machineID)].getCurrentWeight();
	}
	
	public double getWeightCapacityForMachine(int machineID){
		return registeredMachines[queryMachine(machineID)].getWeightCapacity();
	}
	
	public Timestamp getLastTimeEmptied(int machineID){
		return registeredMachines[queryMachine(machineID)].getLastEmptiedDate();
	}
	
	public void emptyRCM(int machineID){
		registeredMachines[queryMachine(machineID)].emptyMachine();
	}
	
}
	

