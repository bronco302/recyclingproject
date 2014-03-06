package rcm; 

import java.util.*;
import java.util.Date;
import java.util.Observable;
import java.util.Random;

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
    private String machine_health; 
    private Session transaction; 
    Random generator = new Random(); 
    
    public RecyclingMachine(){
    	machineID = generator.nextInt(89999) + 10000;
    	active = true;	
    	transaction = new Session();
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

}
    
 
 
