package rcm;

public interface ItemForRecycle {

	public void addItem();
	public String getTypeOfItem();
	public double getPaymentAmount();
	public void addAcceptableItems(String newType, double value);
}
