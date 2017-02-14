public class Trie {

	private Character data = null;
	private Trie[] children = null;
	private int prefix = 0;
	private boolean word = false;
	//Assume extended ASCII encoding
	private final int size = 256;

	public Trie() {
		this.children = new Trie[size];
	}

	public Trie(Character data) {
		this.data = data;
		this.children = new Trie[size];
	}

	public boolean insert(String word) {
		if (word == null || word.isEmpty())
			return false;
		//Assume dictionary is case insensitive
		return this.insert(word.toLowerCase(), 0);
	}

	private boolean insert(String word, int index) {
		if (index == word.length()) {
			this.prefix++;
			this.word = true;
			return true;
		}
		//get next child index
		int child = (int) word.charAt(index); 
		if (this.children[child] == null) {
			this.children[child] = new Trie(word.charAt(index));
		}
		//update current node prefix counter
		this.prefix++;
		return this.children[child].insert(word, index + 1); 
	}

	public boolean find(String word) {
		if (word == null || word.isEmpty())
			return false;
		return this.find(word.toLowerCase(), 0);
	}

	private boolean find(String word, int index) {
		if (index == word.length()) {
			return this.word;
		}
		int child = (int) word.charAt(index);
		return (this.children[child] != null)? 
						// lookup child
						this.children[child].find(word, index + 1) 
					    // child does not exist
					  : false; 
	}

	public boolean delete(String word) {
		if (word == null || word.isEmpty() || !this.find(word))
			return false;
		this.delete(word.toLowerCase(), 0);
		return true;
	}

	private void delete(String word, int index) {
		if (index == word.length()) {
			this.prefix--;
			this.word = false;
			return;
		}	
		int child = (int) word.charAt(index);
		this.children[child].delete(word, index + 1);
		//remove unused Trie child
		if (this.children[child].prefix == 0)
			this.children[child] = null; 
	}
}