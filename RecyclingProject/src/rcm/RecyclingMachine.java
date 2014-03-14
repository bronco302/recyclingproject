package rcm; 

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Performs the functions of a recycling machine.
 * @author Jonathan & Steven 
 *
 */
 
public class RecyclingMachine extends Observable{
  
    
    private int machineID; 
    private boolean active;
    private String selectedItemType;
    private Payment availableCash;
    private Payment cashCapacity;
    private String location;
    private int group = 1; 
    private Session transaction; 
    private String Status;
    private Timestamp lastEmptied; 
    private Date date= new Date();
	private long time; 
    private double weightCapacity = 10.0;
    private double currentWeight = 0.0;
    private boolean full;
    private Random generator = new Random(); 
    private Map<String, Integer> acceptableItems ; 
    
    public RecyclingMachine(){
    	machineID = generator.nextInt(89999) + 10000;
    	active = true;	
    	transaction = new Session();
    	time = date.getTime();
    	lastEmptied = null;
    	setLocation(new String("Santa Clara"));
    	this.Status = "Enabled"; 
    	availableCash = new Payment(5);
    	cashCapacity = new Payment(5);
    	acceptableItems = new HashMap<String, Integer>();
    	acceptableItems.put("Aluminum" , 1);
		acceptableItems.put("Plastic" , 1);
		acceptableItems.put("Glass" , 0);
    

    }
    
    public int getMachineID(){
    	return machineID;
    }

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	

	public double getAvailableCash(){
		return availableCash.getAmount();
	}
	
	public double getCashCapacity(){
		return cashCapacity.getAmount();
	}
	
	public void initiateSession(String itemType){
		transaction.addRecyclableItem(itemType);
		setSelectedItemType(itemType);
	
	}
	
	public int addItem(){
		if(currentWeight<weightCapacity){
			//System.out.println(currentWeight);
			transaction.addItem(getSelectedItemType());
			currentWeight += transaction.weightByType(getSelectedItemType());
			
			//System.out.println(transaction.getWeight(getSelectedItemType()));
			return 1;
		}
		else{
			full=true;
			return 0;
			
		}
	}
	
	public String getCurrentAmount(){
		DecimalFormat format = new DecimalFormat();
        format.setMaximumFractionDigits(2);
        return(format.format(transaction.updateTotalAmount()));
		
		
	}
	
	public double payCustomer(){
		if(checkFunds(transaction.updateTotalAmount())){
			availableCash.subAmount(transaction.updateTotalAmount());
			return transaction.updateTotalAmount();
		}
		else{
			
			return 0;
			
			//Pay amount in coupon value. 
		}
		
	}
	
	public boolean checkFunds(double tobepaid){
		if(tobepaid>availableCash.getAmount()){
			return false;
		}
		return true;
	}


	public String getSelectedItemType() {
		return selectedItemType;
	}


	public void setSelectedItemType(String selectedItemType) {
		this.selectedItemType = selectedItemType;
	}
	
	public int getQuantity(){
		return transaction.getQuantity(selectedItemType);
	}
	
	public int getQuantity(String type){
		return transaction.getQuantity(type);
	}
	
	public String getWeight(){
		DecimalFormat format = new DecimalFormat();
        format.setMaximumFractionDigits(2);
		return format.format(transaction.getWeight(selectedItemType));		
	}
	
	public double getTransactionWeight(){
		return transaction.totalWeight();
	}

	public String getPaymentForItem(){
		DecimalFormat format = new DecimalFormat();
        format.setMaximumFractionDigits(2);
		return format.format(transaction.getPayingAmountForItem(selectedItemType));
	}

	public String getPaymentForItem(String item){
		DecimalFormat format = new DecimalFormat();
        format.setMaximumFractionDigits(2);
		return format.format(transaction.getPayingAmountForItem(item));
	}
	
	public String getCurrentTotalForItem(String item){
		DecimalFormat format = new DecimalFormat();
        format.setMaximumFractionDigits(2);
		return format.format(transaction.getCurrentAmountForItem(item));
	}
	
	public void updatePaymentForItem(String item,double amount){
		transaction.updatePayingAmountForItem(item, amount);
	}
	
	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}
	
	public void clearData(){
		transaction.clearData();
	}
	public void emptyMachine(){
		Date date= new Date();
		time = date.getTime();
		lastEmptied = new Timestamp(time);
		currentWeight = 0.0;
	}
	
	public Timestamp getLastEmptiedDate(){
		return lastEmptied;
	}

	public double getCurrentWeight() {
		return currentWeight;
	}

	public void setCurrentWeight(double currentWeight) {
		this.currentWeight = currentWeight;
	}

	public double getWeightCapacity() {
		return weightCapacity;
	}

	public void setWeightCapacity(double weightCapacity) {
		this.weightCapacity = weightCapacity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public boolean itemValid(String item){
		if(acceptableItems.get(item)>0){
			return true;
		}
		return false;
	}
	
	public void removeItemType(String item){
		acceptableItems.put(item, 0);
	}
	
	public void addItemType(String item){
		acceptableItems.put(item, 1);
	}



}
    
 
 
