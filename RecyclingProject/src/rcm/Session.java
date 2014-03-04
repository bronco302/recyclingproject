package rcm;

public class Session {
	private Payment totalAmount;
	private int objectCounter = 0;
	private ItemForRecycle[] recyclableItemList;
	
	public Session(){
		recyclableItemList = new ItemForRecycle[10];
		totalAmount = new Payment();
	}
	
	public void addRecyclableItem(String itemType){
		if(objectCounter>0){
			recyclableItemList[objectCounter] = new RecyclableItem(itemType);
			objectCounter++;
		}
		else{
			recyclableItemList[objectCounter] = new RecyclableItem(itemType);
			objectCounter++;
		}
	}
	
	public double updateTotalAmount(){
		for (int i=0;i<objectCounter;i++){
			totalAmount.addAmount(recyclableItemList[i].getPaymentAmount());
			
		}
		return totalAmount.getAmount();
	}
	public void addItem(String nameOfItem){
		for (int i=0;i<objectCounter;i++){
			if(((recyclableItemList[i].getTypeOfItem()).toLowerCase()).equals((nameOfItem.toLowerCase()))){
				recyclableItemList[i].addItem();
				
			}
		}
	}
}
