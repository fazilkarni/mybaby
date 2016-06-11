
public class Trie_Demo {
	Trie root = new Trie();
	public void insert(String s){
		if(s==null){
			return;
		}
		int letter = s.charAt(0);
		int index = letter-'a';
		
		if(root.children[index]==null){
			
		}
	}
}

class Trie{
	int c;
	Trie[] children = new Trie[26];
}
