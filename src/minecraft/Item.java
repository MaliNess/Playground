package minecraft;

public class Item {

	private String type;
	private String mode;
	private String[] craft;
	private String tool;
	private int price;
	private boolean isChangable=false;
	
	Item(String t) {
		this.type = t;
		if(this.type=="base") isChangable=true;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int p) {
		if(isChangable) this.price = p;
		else System.out.println("ERROR");
	}
	
	public void increasePrice(int i) {
		this.price+=i;
	}
	
	//reset price
	
	private int countPrice() {
		
	}
	
	

}
