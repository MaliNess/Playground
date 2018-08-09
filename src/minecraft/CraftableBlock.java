package minecraft;

public class CraftableBlock extends Block {

	private String[] craft;
	
	public CraftableBlock(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public String[] getCraft() {
		return craft;
	}

	public void setCraft(String[] craft) {
		this.craft = craft;
	}
	
	
}
