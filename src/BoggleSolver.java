import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import java.util.Set;
import java.util.HashSet;

public class BoggleSolver {
	private final TrieSET trie;
	private int row, col;
	private boolean[][] marked;
	private Set<String> set;
	private BoggleBoard board;
	
	// Initializes the data structure using the given array of strings as the dictionary.
    // (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
    public BoggleSolver(String[] dictionary) {
    		trie = new TrieSET();
    		for(String word : dictionary) {
    			trie.add(word);
    		}
    }

    // Returns the set of all valid words in the given Boggle board, as an Iterable.
    public Iterable<String> getAllValidWords(BoggleBoard board){
    		set = new HashSet<>();
    		this.board = board;
    		row = board.rows();
    		col = board.cols();
    		marked = new boolean[row][col];
    	
    		for(int i=0;i<row;i++) {
    			for(int j=0;j<col;j++) {
    				dfs(i,j,"");
    			}
    		}
    		return set;
    }
    
    private void dfs(int i, int j, String cur) {
    		if(!trie.hasPrefix(cur)) return;
    		
    		if(cur.length()>2 && trie.contains(cur)) {
    			set.add(cur);
    		}
		
		if( i>=0 && i<row && j>=0 && j<col && !marked[i][j] ) {
			marked[i][j] = true;
			String str = ""+board.getLetter(i,j);
			if(str.equals("Q")) str = "QU";
			
			dfs(i-1,j-1, cur + str);
			dfs(i-1,j, cur + str);
			dfs(i-1,j+1, cur + str);
			dfs(i,j-1, cur + str);  
			dfs(i,j+1, cur + str);
			dfs(i+1,j-1, cur + str);
			dfs(i+1,j, cur + str);
			dfs(i+1,j+1, cur + str);
			marked[i][j] = false;
		}
    }

    // Returns the score of the given word if it is in the dictionary, zero otherwise.
    // (You can assume the word contains only the uppercase letters A through Z.)
    public int scoreOf(String word) {
    		if(!trie.contains(word)) return 0;
    		
    		int len = word.length();
    		if(len<=2) return 0;
    		else if(len<=4) return 1;
    		else if(len==5) return 2;
    		else if(len==6) return 3;
    		else if(len==7) return 5;
    		else return 11;
    }
   
    public static void main(String[] args) {
        In in = new In(args[0]);
        String[] dictionary = in.readAllStrings();
        BoggleSolver solver = new BoggleSolver(dictionary);
        BoggleBoard board = new BoggleBoard(args[1]);
        int score = 0;
        solver.getAllValidWords(board);
        for (String word : solver.getAllValidWords(board)) {
            StdOut.println(word);
            score += solver.scoreOf(word);
        }
        StdOut.println("Score = " + score);
    }
    
    
}
