package minecraft;

public class Mechanizm extends CraftableBlock {

	private int fuelPrice;
	
	public Mechanizm(int id) {
		super(id);
		setType(BlockType.MECHANISM);
	}

	public int getFuelPrice() {
		return fuelPrice;
	}

	public void setFuelPrice(int fuelPrice) {
		this.fuelPrice = fuelPrice;
	}
	
}
