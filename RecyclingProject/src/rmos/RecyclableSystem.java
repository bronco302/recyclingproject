package rmos;
import rcm.*; 

public class RecyclableSystem {
	public static void main (String [] args){
		//RecyclableItem r1 = new RecyclableItem();
		//RecyclableItem r2 = new RecyclableItem("Aluminum",.5);
		//r2.addItem();
		Session s1 = new Session();
		s1.addRecyclableItem("Aluminum");
		s1.addItem("Aluminum");
		s1.addItem("Aluminum");
		s1.addItem("Aluminum");
		s1.addItem("Aluminum");
		s1.addRecyclableItem("Plastic");
		s1.addItem("Plastic");
		s1.addItem("Plastic");
		s1.addItem("Plastic");
		s1.addRecyclableItem("Glass");
		s1.addItem("Glass");
		s1.addItem("Glass");
		s1.addItem("Glass");
		s1.addItem("Glass");
		s1.addItem("Aluminum");
		System.out.println(s1.updateTotalAmount());
		
	 //	RecyclingMachine r1 = new RecyclingMachine();
	//	System.out.println(r1.getMachineID());
	//	System.out.println(r2.getWeight());
		
		
		
	}
}
