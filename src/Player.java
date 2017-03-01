
public class Player {
	public String name;
	public String symValue;
	
	public Player(String name, String symValue) {
		this.name = name;
		this.symValue = symValue;
	}
	
	public boolean placeSymbol(Board b, int row, int col) {
		return b.placeSymbol(new Symbol(symValue), row, col);
	}
}
