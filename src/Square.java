
public class Square {
	private Symbol symbol;
	
	public Square() {
		symbol = null;
	}
	public Symbol getSymbol() {
		return symbol;
	}
	
	public void setSymbol(Symbol newSymbol) {
		symbol = newSymbol;
	}
	
	public String toString() {
		if(symbol != null) {
			return symbol.toString();
		}
		return "_";
	}

}
