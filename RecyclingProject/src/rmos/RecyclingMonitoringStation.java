package rmos;

import java.sql.Timestamp;
import java.util.ArrayList;

import rcm.*;

public class RecyclingMonitoringStation {
	
	private RecyclingMachine registeredMachines[];
	private int objectCounter = 0;
	private static final long serialVersionUID = 1L;
	private Admin[] managers = new Admin[2];
	

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
	

