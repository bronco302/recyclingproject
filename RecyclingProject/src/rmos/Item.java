package rmos;

public class Item {
		public String itemType;
		public Double weight;
		public Double price;
		public int id;
		private TypeofItem type;
		private String name;


		Item (String itemType, Double weight, Double  price) {
			this.itemType = itemType;
			this.weight = weight;
			this.price = price;
		}

		public Item (String itemType, Double price, int i) {
			this.itemType = itemType;
			this.price = price;
			this.id = i;

		}
		public void setWeight(Double w) {
			this.weight = w;
		}
		public int getId(){
			return this.id;
		}
		
		public double getWeight() {
			return weight; 
		}
		
		public String getName(){
			return name;
		}
		
		public double getValue(){
			return Math.round((weight/16) * type.getPrice() * 100.0) / 100.0;
		}

}
