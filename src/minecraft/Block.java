package minecraft;

public class Block {
	
	private String name;
	private Modes mode;
	Modes[] FriendModes;
	private BlockType type;
	private int price;
	private int id;
	
	public Block(int id) {
		this.setId(id);
		this.name = getName(id);
		this.mode = getMode(id);
	}

	public String getName(int id) {
		if(name != null)
			return name;
		else {
			setName();
			return name;
		}
	}

	public void setName() {
		// поиск по базе id тега name
		this.name = "example";
	}

	public Modes getMode() {
		return mode;
	}

	public Modes getMode(int id) {
		if (mode != null)
			return getMode();
		// поиск
		else {
			mode = Modes.FORESTRY;
			return mode;
		}
	}

	public void setMode(Modes mode) {
		this.mode = mode;
	}

	public BlockType getType(int id) {
		return type;
	}

	public void setType(BlockType type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public int getId(String name, Modes mode) {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	protected void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if(name==null) sb.append("\tName is undefined!");
		else sb.append("\tName: " + name);
		if(mode==null) sb.append("\n\tMode is undefined!");
		else sb.append("\n\tMode: " + mode);
		if(type==null) sb.append("\n\tType is undefined!");
		else sb.append("\n\tType: " + type);
		if(price==0) sb.append("\n\tPrice is undefined!");
		else sb.append("\n\tPrice: " + price);
		if(id==0) sb.append("\n\tId is undefined!");
		else sb.append("\n\tId: " + id);
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		//Block b = new Block(10);
		//System.out.println(b.toString());
		//System.out.println("================================");
		BaseBlock bb = new BaseBlock(10);
		System.out.println(bb.toString());
	}
}
