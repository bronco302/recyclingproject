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
	public ArrayList<RecyclableItem> listOfItems = new ArrayList<RecyclableItem>(); 
	
	
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
	
	public void addItem()
	{    
		if(validator.validateItem(acceptableItems,typeOfRecyclableItem)){
	 		setQuantity(getQuantity() + 1);
		}
		else{
			System.out.println("Item is not the correct type, please insert only "+typeOfRecyclableItem+" cans.");
		}
			
	}
	public double getPaymentAmount(){
		currentAmount.addAmount((acceptableItemsWeight.get(typeOfRecyclableItem)*quantity)*(acceptableItems.get(typeOfRecyclableItem)));
			
		
		return currentAmount.getAmount();

	}
	
	public ArrayList<RecyclableItem> showRecyclableItemList(){
		return listOfItems;
	}	
	
	public void setWeight(Double w) {
		this.weight = w;
	}

	 public void addRecyclableItem(RecyclableItem item){
		//checks if the itemType don't already exist 
		 if(this.listOfItems.indexOf(item)==-1) {
			 this.listOfItems.add(item);
			   System.out.print("= Adding item type: "+item.typeOfRecyclableItem+"\n");
		 }
	 }
	 
	


	


}
