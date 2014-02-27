package rmos;
import rcm.*; 

public class RecyclableSystem {
	public static void main (String [] args){
		RecyclableItem r1 = new RecyclableItem();
		RecyclableItem r2 = new RecyclableItem("Glass",.5);
		System.out.println(r1.getTypeOfItem());
		System.out.println(r1.getWeight());
		System.out.println(r2.getTypeOfItem());
		System.out.println(r2.getWeight());
		
		
		
	}
}
