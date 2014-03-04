package rcm;
import java.util.*;


public class RecyclableItem implements ItemForRecycle {
	private String typeOfRecyclableItem;
	private double weight = 0;
	private int quantity = 0; 
	private Payment currentAmount;
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
	
	public boolean addItem(){
	    Iterator<Map.Entry<String, Double>> it = acceptableItems.entrySet().iterator();
	    while (it.hasNext()) {
	    	Map.Entry<String, Double> pairs = it.next();
	    	if(typeOfRecyclableItem.equals(pairs.getKey())){
	    		if(pairs.getValue() != 0){
	    			setQuantity(getQuantity() + 1);
	    			return true;
	    		}
	    		else
	    		{
	    			return false;
	    		}
	    	}
	    	
	    }
	    return false;
	}
	public double getPaymentAmount(){
		currentAmount.addAmount((acceptableItemsWeight.get(typeOfRecyclableItem)*quantity)*(acceptableItems.get(typeOfRecyclableItem)));
			
		
		return currentAmount.getAmount();

	}
	


}
