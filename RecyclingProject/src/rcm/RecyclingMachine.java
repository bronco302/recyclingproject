package rcm; 

import java.util.ArrayList;
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
    
    private int machineID = 150; 
    private String activity; 
    private String machine_health; 
    
    public int getMachineID(){
    	return machineID;
    }

}
    
 
 
