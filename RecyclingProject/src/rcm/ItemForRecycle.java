package rcm;

public interface ItemForRecycle {

	public boolean addItem();
	public String getTypeOfItem();
	public double getPaymentAmount();
	public void addAcceptableItems(String newType, double value);
	public int getQuantity();
	public double getWeight();
	public double weightByType();
	public double getPayingAmountForItem();
	public void clear();
	
//	public double totalWeight();
}
