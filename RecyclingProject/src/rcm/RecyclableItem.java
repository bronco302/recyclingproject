package rcm;
import java.util.*;


public class RecyclableItem implements ItemForRecycle {
	private String typeOfRecyclableItem;
	private double weight = 0;
	private int quantity = 0; 
	private Payment currentAmount;
	private ItemValidator validator; 
	protected Map<String, Double> acceptableItemsWeight; 
	protected Map<String, Double> acceptableItems ;
	
	
	public RecyclableItem(){
		
	}

	public RecyclableItem(String typeOfItem){
		acceptableItems = new HashMap<String, Double>();
		acceptableItems.put("Aluminum" , 2.0);
		acceptableItems.put("Plastic" , 1.50);
		acceptableItems.put("Glass" , 1.0);
		acceptableItemsWeight = new HashMap<String, Double>();
		acceptableItemsWeight.put("Aluminum", 0.0364865);
		acceptableItemsWeight.put("Plastic", 0.0279987);
		acceptableItemsWeight.put("Glass", 0.440925);
		validator = new ItemValidator();
		typeOfRecyclableItem = typeOfItem;
		currentAmount = new Payment();
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

	public void addAcceptableItems(String newType, double value){
		acceptableItems.put(newType, value);
	}
	
	public boolean addItem()
	{    
		if(validator.validateItem(acceptableItems,typeOfRecyclableItem)){
	 		setQuantity(getQuantity() + 1);
	 		return true;
		}
		else{
			System.out.println("Item is not the correct type, please insert only "+typeOfRecyclableItem+" cans.");
			return false;
		}
			
	}
	public double getPaymentAmount(){
		currentAmount.setAmount((acceptableItemsWeight.get(typeOfRecyclableItem)*quantity)*(acceptableItems.get(typeOfRecyclableItem)));
		//System.out.println(currentAmount.getAmount());	
		
		return currentAmount.getAmount();

	}
	


}
