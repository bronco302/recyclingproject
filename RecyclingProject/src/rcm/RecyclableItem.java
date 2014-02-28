package rcm;

public class RecyclableItem {
	private String typeOfRecyclableItem;
	private double weight = 0;
	private Payment currentAmount; 
	
	
	public RecyclableItem(){
		typeOfRecyclableItem = new String("Not Specified");
	//	currentAmount = new Payment(typeOfRecyclableItem);
	}
	public RecyclableItem(String typeOfItem, double weight){
		typeOfRecyclableItem = typeOfItem; 
		this.weight = weight; 
	//	currentAmount = new Payment(typeOfRecyclableItem);
		
	}
	
	
	public String getTypeOfItem(){
		return typeOfRecyclableItem; 
	}
	public double getWeight(){
		return weight;
	}
	
	
}
