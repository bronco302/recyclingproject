package rcm;

public interface ItemForRecycle {

	public boolean addItem();
	public String getTypeOfItem();
	public double getPaymentAmount();
	public void addAcceptableItems(String newType, double value);
}
