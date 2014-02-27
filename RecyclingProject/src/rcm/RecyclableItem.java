package rcm;

public class RecyclableItem {
	private String typeOfRecyclableItem;
	private double weight;
	private Payment
	
	public RecyclableItem(){
		typeOfRecyclableItem = new String("Not Specified");
		weight = 0 ;
	}
	public RecyclableItem(String typeOfItem, double weight){
		typeOfRecyclableItem = typeOfItem; 
		this.weight = weight; 
		
	}
	
	
	public String getTypeOfItem(){
		return typeOfRecyclableItem; 
	}
	public double getWeight(){
		return weight;
	}
}
