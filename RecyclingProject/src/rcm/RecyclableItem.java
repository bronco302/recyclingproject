package rcm;

/**
 * Know what kind of item is, weight, and price.
 * @author Jonathan
 *
 */

public class RecyclableItem {
	private String typeOfRecyclableItem;
	private int weight;
	
	public RecyclableItem(){
		typeOfRecyclableItem = new String("Not Specified");
		weight = 0 ;
	}
	public RecyclableItem(String typeOfItem, int weight){
		typeOfRecyclableItem = typeOfItem; 
		this.weight = weight; 
		
	}
	
	
	public String getTypeOfItem(){
		return typeOfRecyclableItem; 
	}
	public int getWeight(){
		return weight;
	}
}
