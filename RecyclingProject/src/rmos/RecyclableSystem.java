package rmos;
import rcm.*; 

public class RecyclableSystem {
	public static void main (String [] args){
		//RecyclableItem r1 = new RecyclableItem();
		//RecyclableItem r2 = new RecyclableItem("Aluminum",.5);
		//r2.addItem();
		Session s1 = new Session();
		s1.addRecyclableItem("Aluminum",.5);
		s1.addItem("Aluminum");
		s1.addItem("Aluminum");
		s1.addItem("Aluminum");
		s1.addItem("Aluminum");
		System.out.println(s1.updateTotalAmount());
	//	System.out.println(r2.getWeight());
		
		
		
	}
}
