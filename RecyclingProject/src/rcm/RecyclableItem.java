package rcm;

/**
 * Know what kind of item is, weight, and price.
 * @author Jonathan
 *
 */

public class RecyclableItem {
	private String typeOfRecyclableItem;
	private int weight;
	private double price; 
	
	public RecyclableItem(){
		typeOfRecyclableItem = new String("Not Specified");
		weight = 0 ;
	}
	public RecyclableItem(String typeOfItem, int weight, double price){
		typeOfRecyclableItem = typeOfItem; 
		this.weight = weight; 
		this.price = price; 
	
		
	}
	
	
/**
 * Given Constructors
 */	
	public String getTypeOfItem(){
		return typeOfRecyclableItem; 
	}
	public int getWeight(){
		return weight;
	}
}
