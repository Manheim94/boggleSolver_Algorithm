
public class TrieSET {
	private final Node root = new Node();
	
	private class Node{
		private boolean isWord = false;
		private Node[] next = new Node[26];
	}
	
	
	public void add(String word) {
		put(root,word,0);
	}
	
	private Node put(Node cur, String word, int d) {
		if(cur==null) cur = new Node();
		if(d==word.length()) {
			cur.isWord = true;
			return cur;
		}
		
		char c = word.charAt(d);
		cur.next[c-'A'] = put(cur.next[c-'A'] ,word,d+1);
		return cur;
	}
	
	public boolean contains(String word) {
		Node t = get(root,word,0);
		if(t!=null && t.isWord==true) return true;
		return false;
	}
	
	private Node get(Node cur, String word,int d) {
		if(cur==null) return null;
		if(d==word.length()) return cur;
		
		char c = word.charAt(d);
		return get(cur.next[c-'A'],word,d+1);
	}
	
	public boolean hasPrefix(String prefix) {
		Node t = get(root,prefix,0);
		if(t==null) return false;
		else return true;
	}
	
	
}
