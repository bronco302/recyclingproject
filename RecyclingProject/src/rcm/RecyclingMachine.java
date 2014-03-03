<<<<<<< HEAD
package rcm;

public class RecyclingMachine {
	
}
=======
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
 
public class RecylingMachine extends Observable{
  
    public enum MachineHealth{
      ALMOST_FULL, FULL; CASH_NEEDED; COUPONS_NEEDED; FUNCTIONING_WELL; 
    }
    public enum Aciivity{
     INACTIVITY; ACTIVITY;
    }
    
    private String machine_id; 
    private String activity; 
    private String machine_health; 
    private double 
    
 
>>>>>>> FETCH_HEAD
