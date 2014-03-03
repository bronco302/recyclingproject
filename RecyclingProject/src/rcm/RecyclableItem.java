package rcm;
import java.util.*;

<<<<<<< HEAD


public class RecyclableItem implements ItemForRecycle {
	private String typeOfRecyclableItem;
	private double weight = 0;
	private int quantity = 0; 
	private Payment currentAmount;
	private Map<String, Double> acceptableItems = new HashMap<String, Double>();
	
=======
/**
 * Know what kind of item is, weight, and price.
 * @author Jonathan
 *
 */

public class RecyclableItem {
	private String typeOfRecyclableItem;
	private int weight;
	private double price; 
>>>>>>> FETCH_HEAD
	
	public RecyclableItem(){
		acceptableItems.put("Aluminum" , .05);
		typeOfRecyclableItem = new String("Not Specified");
		currentAmount = new Payment();	
	}
<<<<<<< HEAD
	public RecyclableItem(String typeOfItem, double weight){
		acceptableItems.put("Aluminum" , .05);
=======
	public RecyclableItem(String typeOfItem, int weight, double price){
>>>>>>> FETCH_HEAD
		typeOfRecyclableItem = typeOfItem; 
		currentAmount = new Payment();
		this.weight = weight; 
<<<<<<< HEAD

	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
=======
		this.price = price; 
	
		
	}
	
	
/**
 * Given Constructors
 */	
>>>>>>> FETCH_HEAD
	public String getTypeOfItem(){
		return typeOfRecyclableItem; 
	}
	public void setTypeOfItem(String type){
		typeOfRecyclableItem = type;
	}
	public double getWeight(){
		return weight;
	}
<<<<<<< HEAD
	
	public void addItem(){
		setQuantity(getQuantity() + 1);
		currentAmount.addAmount(acceptableItems.get(typeOfRecyclableItem));	
	}	
	
	public double getPaymentAmount(){
		return currentAmount.getAmount();
=======
	public double getPrice(){
		return price; 
	}
	public void setName (String name); 
		this.name = name; 
	}
	public void setPrice (double price); 
		this.price = price; 
>>>>>>> FETCH_HEAD
	}
}
