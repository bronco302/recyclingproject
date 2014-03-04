package rcm;

public class ItemValidator extends RecyclableItem{
  
 

	private String name;
	private RecyclableItem type;
	/**
	 * Calculates the weight of item in ounce. 
	 */
	private double weight;

	public ItemValidator(RecyclableItem type){
		this.type = type;
	}


	public ItemValidator(){
		name = "Needs to be determined";

	}

	public String getName(){
		return name;
	}

	public RecyclableItem getType(){
		return type;
	}

	public double getWeight(){
		return weight;
	}

	public double getWeightInKg(){
		return weight * 28.3495;
	}

	/**
	 * Calculates cash equivalent value of an item with the weight of the item and price per lb. 
	 * Weight is converted to lb from oz
	 */
	public double getValue(){
		return Math.round((weight/16) * type.getPrice() * 100.0) / 100.0;
	}

}



