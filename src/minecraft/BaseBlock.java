package minecraft;

public class BaseBlock extends Block {

	private int often;
	
	public BaseBlock(int id) {
		super(id);
		super.setType(BlockType.BASEBLOCK);
		//поиск often
		this.often = this.getOften();
	}

	public int getOften() {
		if(often != 0)
		return often;
		else {
			//поиск
			often = -1;
			return often;
		}
	}

	public void setOften(int often) {
		this.often = often;
	}
	
	@Override
	public void setPrice(int price) {
		super.setPrice(price);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		if(often == 0) sb.append("\n\tOften is undefined!");
		else sb.append("\n\tOften: " + often);
		
		return sb.toString();
	}
}
