
public class Board {
	public int SIZE;
	public Square[][] table;
	
	public Board(int size) {
		SIZE = size;
		table = new Square[SIZE][SIZE];
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				table[i][j] = new Square();
			}
		}
	}
	
	public boolean placeSymbol(Symbol s, int row, int col) {
		row--;
		col--;
		if(table[row][col].getSymbol() == null) {
			table[row][col].setSymbol(s);
			return true;
		}
		return false;
	}
	
	public void printBoard() {
		for(int i=0; i<=SIZE; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		for(int i=0; i<SIZE; i++) {
			System.out.print((i+1) + " ");
			for(int j=0; j<SIZE; j++) {
				System.out.print(table[i][j].toString() + " ");
			}
			System.out.println();
		}
		System.out.println("\n");
		
	}
	
	
}
