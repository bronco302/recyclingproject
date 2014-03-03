package rcm;
import java.util.*;



public class RecyclableItem implements ItemForRecycle {
	private String typeOfRecyclableItem;
	private double weight = 0;
	private int quantity = 0; 
	private Payment currentAmount;
	private Map<String, Double> acceptableItems = new HashMap<String, Double>();
	
	
	public RecyclableItem(){
		acceptableItems.put("Aluminum" , .05);
		typeOfRecyclableItem = new String("Not Specified");
		currentAmount = new Payment();	
	}
	public RecyclableItem(String typeOfItem, double weight){
		acceptableItems.put("Aluminum" , .05);
		typeOfRecyclableItem = typeOfItem; 
		currentAmount = new Payment();
		this.weight = weight; 

	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getTypeOfItem(){
		return typeOfRecyclableItem; 
	}
	public void setTypeOfItem(String type){
		typeOfRecyclableItem = type;
	}
	public double getWeight(){
		return weight;
	}
	
	public void addItem(){
		setQuantity(getQuantity() + 1);
		currentAmount.addAmount(acceptableItems.get(typeOfRecyclableItem));	
	}	
	
	public double getPaymentAmount(){
		return currentAmount.getAmount();
	}
}
