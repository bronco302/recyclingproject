package rcm; 

import java.util.*;

/**
 * Performs the functions of a recycling machine.
 * @author Jonathan & Steven 
 *
 */
 
public class RecyclingMachine extends Observable{
  
    //public enum MachineHealth{
     // ALMOST_FULL, FULL; CASH_NEEDED; COUPONS_NEEDED; FUNCTIONING_WELL; 
   // }
   // public enum Aciivity{
    // INACTIVITY; 
   //  ACTIVITY;
   // }
    
    private int machineID; 
    private boolean active;
    private String selectedItemType;
    private Payment availableCash;
    private String machine_health; 
    private Session transaction; 
    public String Status; 
    Random generator = new Random(); 
    
    public RecyclingMachine(){
    	machineID = generator.nextInt(89999) + 10000;
    	active = true;	
    	transaction = new Session();
<<<<<<< HEAD
    	this.Status = "Disabled"; 
=======
    	availableCash = new Payment(.2);
>>>>>>> FETCH_HEAD
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
	
<<<<<<< HEAD

=======
	public double getAvailableCash(){
		return availableCash.getAmount();
	}
	
	public void initiateSession(String itemType){
		transaction.addRecyclableItem(itemType);
		setSelectedItemType(itemType);
	
	}
	
	public void addItem(){
		transaction.addItem(getSelectedItemType());
	}
	
	
	
	public double payCustomer(){
		if(checkFunds(transaction.updateTotalAmount())){
			availableCash.subAmount(transaction.updateTotalAmount());
			
			return transaction.updateTotalAmount();
		}
		else{
			System.out.println("Due to insufficient funds, we will give you a coupon redeemable at any store for the same cash value.");
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
>>>>>>> FETCH_HEAD

}
    
 
 
