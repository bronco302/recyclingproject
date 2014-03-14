package rcm;

public class Session {
	private Payment totalAmount;
	private int objectCounter = 0;
	private ItemForRecycle[] recyclableItemList;
	
	public Session(){
		recyclableItemList = new ItemForRecycle[50];
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
		double temp = 0;
		for (int i=0;i<objectCounter;i++){
			temp += recyclableItemList[i].getPaymentAmount();
		}
		totalAmount.setAmount(temp);
		return totalAmount.getAmount();
	}
	public boolean addItem(String nameOfItem){
		for (int i=0;i<objectCounter;i++){
			if(((recyclableItemList[i].getTypeOfItem()).toLowerCase()).equals((nameOfItem.toLowerCase()))){
				if(recyclableItemList[i].addItem()){
					return true;
				}
			}
		}
		return false;
	}
	
	public int getQuantity(String nameOfItem){
		for (int i=0;i<objectCounter;i++){
			if(((recyclableItemList[i].getTypeOfItem()).toLowerCase()).equals((nameOfItem.toLowerCase()))){
				return recyclableItemList[i].getQuantity();
			}
		}
		return 0;
		
	}
	
	public double getWeight(String nameOfItem){
		for (int i=0;i<objectCounter;i++){
			if(((recyclableItemList[i].getTypeOfItem()).toLowerCase()).equals((nameOfItem.toLowerCase()))){
				return recyclableItemList[i].getWeight();
			}
		}
		return 0;
	}
	
	public double weightByType(String nameOfItem){
		double weight=0;
		for (int i=0;i<objectCounter;i++){
			if(((recyclableItemList[i].getTypeOfItem()).toLowerCase()).equals((nameOfItem.toLowerCase()))){
				return recyclableItemList[i].weightByType();
			}
		}
		return weight;
		
	}
	
	public double getPayingAmountForItem(String nameOfItem){
		for (int i=0;i<objectCounter;i++){
			if(((recyclableItemList[i].getTypeOfItem()).toLowerCase()).equals((nameOfItem.toLowerCase()))){
				System.out.println(recyclableItemList[i].getPayingAmountForItem());
				return recyclableItemList[i].getPayingAmountForItem();
			}
		}
		return 0;
	}
	public void updatePayingAmountForItem(String nameOfItem,double amount){
		for (int i=0;i<objectCounter;i++){
			if(((recyclableItemList[i].getTypeOfItem()).toLowerCase()).equals((nameOfItem.toLowerCase()))){
				recyclableItemList[i].updatePrice(amount);
			}
		}
	}
	
	public void clearData(){
		for (int i=0;i<objectCounter;i++){
			recyclableItemList[i].clear();
		}
		
	}
	
	public double totalWeight(){
		double weight = 0;
		for (int i=0;i<objectCounter;i++){
			weight += recyclableItemList[i].getWeight();
		}
		return weight;
	}
	
	//public boolean itemValid(String item){
	//	return recyclableItemList[0].itemValid(item);
	//}
	
}
