import edu.princeton.cs.algs4.In;

public class BoggleBoard {
	private char[][] board;
	
    // Initializes a random 4-by-4 Boggle board.
    // (by rolling the Hasbro dice)
    public BoggleBoard() {
    	
    }

    // Initializes a random m-by-n Boggle board.
    // (using the frequency of letters in the English language)
    public BoggleBoard(int m, int n) {
    	
    }

    // Initializes a Boggle board from the specified filename.
    public BoggleBoard(String filename) {
    		In input = new In(filename);
    		int m = input.readInt();
    		int n = input.readInt();
    		board = new char[m][n];
    		for(int i=0;i<m;i++) {
    			for(int j=0;j<n;j++) {
    				board[i][j] = input.readString().charAt(0);
    			}
    		}
    		
    }
    		
    // Initializes a Boggle board from the 2d char array.
    // (with 'Q' representing the two-letter sequence "Qu")
    public BoggleBoard(char[][] a) {
    	
    }

    // Returns the number of rows.
    public int rows() {
    		return board.length;
    }

    // Returns the number of columns.
    public int cols() {
    		return board[0].length;
    }

    // Returns the letter in row i and column j.
    // (with 'Q' representing the two-letter sequence "Qu")
    public char getLetter(int i, int j) {
    		return board[i][j];
    }

    // Returns a string representation of the board.
    public String toString() {
    		return "";
    }
}
