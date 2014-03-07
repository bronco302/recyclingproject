package rcm;

public class Payment {
	//Data members
		
		private double amount;
		
		
		/**
		 * Default constructor.
		 */
		public Payment(){
			amount = 0 ;
		}
		
		/**
		 * Constructor Money initializes amount using startAmount.
		 * @param startAmount
		 */
		public Payment(double startAmount){
			amount = startAmount; 
		}
		
		/**
		 * Method getAmount returns current amount.
		 * @return amount
		 */
		public double getAmount(){
		
			return amount;
		 
		}
		
		/**
		 * Method setAmount updates the current amount using parameter newAmount.
		 * @param newAmount
		 */
		public void setAmount(double newAmount){
			
			this.amount = newAmount; 
			
		}	
		public void addAmount(double newAmount){
			this.amount += newAmount;
		}
		public void subAmount (double newAmount){
			this.amount -= newAmount;
		}

}
