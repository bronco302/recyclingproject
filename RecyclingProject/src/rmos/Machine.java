package rmos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * This will calculate the changes and identify the characteristics of a recycling machine.
 * @author Steven 
 *
 */
public class Machine implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * Status options for Machine
	 * Default Status is INACTIVE
	 * @author Steven
	 *
	 */
	public enum Status {
		ACTIVE, INACTIVE;
	}

	/**
	 * State options for Machine
	 * Default State is OPERATIONAL
	 * @author Steven 
	 *
	 */
	public enum State {
		OPERATIONAL, NONOPERATIONAL;
	}

	private String id;
	private String location;
	private Status status;
	private State state;
	private double capacity, weight, cash;
	private int couponPaper;
	private Calendar timeLastEmptied;

	private String maintenanceKey;
	private double sessionWeight;
	private double sessionValue;
	private ArrayList<Item> sessionItems;
	/**
	 * shared array list of accepted items
	 */
	private static ArrayList<Item> acceptedItems = new ArrayList<Item>();

	public Machine(String location, String id){
		this.id = id;
		this.location = location;
		status = Status.INACTIVE;
		state = State.OPERATIONAL;
		capacity = 250;
		weight = 0;
		cash = 500;
		couponPaper= 100;
		timeLastEmptied = Calendar.getInstance();
		maintenanceKey = "1234";
		sessionValue = 0;
		sessionWeight = 0;
	}

	public Machine(){
		new Machine("not set", "-1");
	}

	public String getID(){
		return id;
	}

	public String getLocation(){
		return location;
	}


	public State getState(){
		return state;
	}

	public Status getStatus(){
		return status;
	}

	public double getCapacity(){
		return capacity;
	}

	public double getWeight(){
		return weight;
	}

	public double getCash(){
		return cash;
	}

	public int getCouponPaper(){
		return couponPaper;
	}

	public Calendar getTimeLastEmptied(){
		return timeLastEmptied;
	}

	public ArrayList<Item> getAcceptedItems(){
		return acceptedItems;
	}

	public void setStatus(Status status){
		this.status = status;
	}

	public void addCash(double cash){
		this.cash += cash;
	}

	public void recycleItem(Item item){
		sessionItems.add(item);
	}

	public boolean aunthenticateWorker(String key){
		return key.equals(maintenanceKey);
	}

	public void finishSession(){
		sessionValue = 0;
		sessionWeight = 0;
		for(Item i : sessionItems){
			sessionValue += i.getValue();
			sessionWeight += i.getWeight();
		}
		sessionItems = new ArrayList<Item>();
	}
	public void empty(){
		weight = 0;
	}

	public void addCoupon(int coupon){
		couponPaper += coupon;;
	}

	public double getSessionWeight(){
		return sessionWeight;
	}

	public double getSessionValue(){
		return sessionValue;
	}

	public void setTimeLastEmptied(Calendar emptied){
		timeLastEmptied = emptied;
	}

	public String printCash(){
		cash -= sessionValue;

		int ten, five, one, quarter, dime, nickel, penny;
		ten = (int) (sessionValue/10);
		sessionValue = sessionValue%10;

		five = (int) (sessionValue/5);
		sessionValue = sessionValue%5;

		one = (int) (sessionValue/1);
		sessionValue = sessionValue%1;

		quarter = (int) (sessionValue/.25);
		sessionValue = sessionValue%.25;

		dime = (int) (sessionValue/.10);
		sessionValue = sessionValue%.10;

		nickel = (int) (sessionValue/.05);
		sessionValue = sessionValue%.05;

		penny = (int) (sessionValue/.01);
		sessionValue = sessionValue%.01;

		return "<html>" + ten + " tens<br>" + five + " fives<br>"+ one + " ones<br>" + quarter + " quarters<br>" + dime + " dimes<br>"+ nickel + " nickels<br>" + penny + " pennys</html>";
	}

	public String printCoupon(){
		couponPaper --;
		return "<html><center>This $" + sessionValue + " coupon is redeemable at common grocery outlets.<br>Visit ecore.org to see a complete list.</center<</html>";
	}

}