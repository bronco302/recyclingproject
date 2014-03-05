package rcm;

import java.util.Map;

public class ItemValidator extends RecyclableItem{
  
	
	
	private double weight;

	public ItemValidator(){
		
	}

	public double getWeight(){
		return weight;
	}

	public double getWeightInKg(){
		return weight * 28.3495;
	}

	public boolean validateItem(Map<String, Double> acceptableItems,String type){
		System.out.println(acceptableItems.get(type));
		if (acceptableItems.get(type)==0){
			return false;
		}
		else return true;	
	}

	

}



