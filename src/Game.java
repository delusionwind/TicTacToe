import java.util.Scanner;
//Softspec-Hw1-6684-6064
//Atid Srisukhantapuek
//Kee@glazziq.com
public class Game {
	private static Scanner scanner;
	private static Board board;
	private static Player p1,p2;
	
	public static void main(String[] args) {
		start();
	}
	
	public static void start() {
		scanner = new Scanner(System.in);
		board = new Board(9);
		int row,col;
		p1 = new Player("1","O");
		p2 = new Player("2","X");
		Player player = p1;
		board.printBoard();
		
		while(playing()) {
			
			System.out.printf("Player %s's turn\n",player.name);
			System.out.print("Please select row: ");
			row = Integer.parseInt(scanner.nextLine());
			System.out.print("Please select col: ");
			col = Integer.parseInt(scanner.nextLine());
			System.out.println();
			if(player.placeSymbol(board, row, col)) {
				System.out.printf("You placed %s on (%d,%d)\n",player.symValue,row,col);
				board.printBoard();
				if(player.equals(p1)) {
					player = p2;
				}else {
					player = p1;
				}
			}else {
				System.out.println("You can't place on that cell");
			}
		}
		
	}
	
	private static boolean playing() {
		String p1win = "";
		String p2win = "";
		String rCat, cCat, dCat;
		for(int i=0; i<5; i++) {
			p1win += p1.symValue;
			p2win += p2.symValue;
		}
		for(int r=0; r<board.SIZE; r++) {
			rCat = "";
			cCat = "";
			for(int i=0; i<board.SIZE; i++) {
				rCat += board.table[r][i].toString();
				cCat += board.table[i][r].toString();
			}
			rCat += "_";
			cCat += "_";
			for(int x=0,y=5; y<=board.SIZE; x++, y++) {
				String fiveR = rCat.substring(x,y);
				String fiveC = cCat.substring(x,y);
				if(fiveR.equals(p1win) || fiveC.equals(p1win)) {
					System.out.println("Player " + p1.name + " Win");
					return false;
				}else if(fiveR.equals(p2win) || fiveC.equals(p2win)) {
					System.out.println("Player " + p2.name + " Win");
					return false;
				}
			}
		}
		for(int i=4, j=4; i<board.SIZE; i++, j++) {
			dCat = "";
			for(int a=i, b=0; a>=0 && b<=j; a--, b++) {
				dCat += board.table[a][b].toString();
			}
			dCat += "_";
			for(int x=0,y=5; y<=dCat.length(); x++, y++) {
				String fiveD = dCat.substring(x,y);
				if(fiveD.equals(p1win)) {
					System.out.println("Player " + p1.name + " Win");
					return false;
				}else if(fiveD.equals(p2win)) {
					System.out.println("Player " + p2.name + " Win");
					return false;
				}
			}	
		}
		for(int i=1; i<5; i++) {
			dCat = "";
			for(int a=8, b=i; a>=1 && b<=8; a--, b++) {
				dCat += board.table[a][b].toString();
			}
			dCat += "_";
			for(int x=0,y=5; y<=dCat.length(); x++, y++) {
				String fiveD = dCat.substring(x,y);
				if(fiveD.equals(p1win)) {
					System.out.println("Player " + p1.name + " Win");
					return false;
				}else if(fiveD.equals(p2win)) {
					System.out.println("Player " + p2.name + " Win");
					return false;
				}
			}	
		}
		for(int i=0; i<5; i++) {
			dCat = "";
			for(int a=i, b=0; a<=8; a++, b++) {
				dCat += board.table[a][b].toString();
			}
			dCat += "_";
			for(int x=0,y=5; y<=dCat.length(); x++, y++) {
				String fiveD = dCat.substring(x,y);
				if(fiveD.equals(p1win)) {
					System.out.println("Player " + p1.name + " Win");
					return false;
				}else if(fiveD.equals(p2win)) {
					System.out.println("Player " + p2.name + " Win");
					return false;
				}
			}	
		}
		for(int i=0; i<5; i++) {
			dCat = "";
			for(int a=0, b=i; b<=8; a++, b++) {
				dCat += board.table[a][b].toString();
			}
			dCat += "_";
			for(int x=0,y=5; y<=dCat.length(); x++, y++) {
				String fiveD = dCat.substring(x,y);
				if(fiveD.equals(p1win)) {
					System.out.println("Player " + p1.name + " Win");
					return false;
				}else if(fiveD.equals(p2win)) {
					System.out.println("Player " + p2.name + " Win");
					return false;
				}
			}	
		}
		
		
		return true;
	}

}
