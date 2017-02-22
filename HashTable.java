import java.util.LinkedList;
/* 
	HASHING by CHAINING 
*/
public class HashTable <K, V> {
	private Object[] table = null;
	private int sizePower = 5;				// Initial SIZE (1 << 5)
	private int elements = 0;
	private int paramA = 0;					// Random Parameter A
	private int paramB = 0;					// Random parameter B  for Universal Hashing 
	private final int MAX_SIZE_POWER = 30;	// table max size (1 << 30)
	private final int PRIME_NUMBER = 1073741827; // next prime greater to max size
	public HashTable() {
		this.table = new Object[(1 << this.sizePower)];
		this.paramA = (int)(Math.random() * PRIME_NUMBER);
		this.paramB = (int)(Math.random() * PRIME_NUMBER);
	}
/* 
	purpose : 
	Various Techniques for hashing key 
	@param key 
	@return int
*/
	public int hashByUniversalHashing(K key) {
		int size = (1 << this.sizePower);
		return ((Math.abs(this.paramA * key.hashCode() + this.paramB) % (PRIME_NUMBER)) % size);
	}
	public int hashByMultiplication(K key) {
		int r = sizePower;
		int w = MAX_SIZE_POWER;
		return ((Math.abs(key.hashCode() * this.paramA) % (1 << w)) >> w - r);
	}
	public int hashByDivision(K key) {
		int size = (1 << this.sizePower);
		return (key.hashCode() % size);
	}
/*
	purpose : 
	Rehash function for a better load factor
	optimization for better worst case complexity
	@param no args
	@return void
*/
	private void updateLoadFactor() {
		double loadFactor = ((double)this.elements/(1 << this.sizePower));
		if (loadFactor > 0.7 && this.sizePower < MAX_SIZE_POWER) 
			rehashTable();
	}
	
	private void rehashTable() {
		Object[] temp = this.table;
		this.sizePower++; // double current size
		int size = (1 << this.sizePower);
		this.table = new Object[size];
		for (Object object : temp) {
			if (object == null)
				continue;
			LinkedList<Pair> pairs = (LinkedList<Pair>) object;
			for (Pair pair : pairs) {
				this.put(pair.key, pair.value);
			}
		}
	}
/*
	purpose : 
	Remove key from hashtable if exist 
	@param key 
	@return true if key exist 
*/
	public boolean remove(K key) {
		if (!this.containsKey(key))
			return false;
		int hashCode = hashByUniversalHashing(key);
		LinkedList<Pair> pairs = (LinkedList<Pair>)this.table[hashCode];
		Pair required = null;
		for (Pair pair : pairs) {
			if (pair.key.equals(key)) {
				required = pair;
				break;
			}
		}	
		if (required != null) {
			pairs.remove(required);
			this.elements--;
			updateLoadFactor();
			return true;
		}
		return false;
	}
/*
	purpose : 
	put key if not exist 
	@param key, value 
	@return false if key already exist else true 
*/
	public boolean put(K key, V value) {
		if (this.containsKey(key))
			return false;
		Pair pair = new Pair(key, value);
		int hashCode = hashByUniversalHashing(key);
		if (this.table[hashCode] == null)
			this.table[hashCode] = new LinkedList<Pair>();
		LinkedList<Pair> pairs = (LinkedList<Pair>)this.table[hashCode];
		pairs.add(pair);
		this.elements++;
		updateLoadFactor();
		return true;
	}
/*
	purpose : 
	return value from hashtable if exist 
	@param key 
	@return value if key exist 
*/
	public V get(K key) {
		if (!this.containsKey(key))
			return null;
		int hashCode = hashByUniversalHashing(key);
		LinkedList<Pair> pairs = (LinkedList<Pair>)this.table[hashCode];
		for (Pair pair : pairs) {
			if (pair.key.equals(key)) {
				return pair.value;
			}
		}
		return null;
	}
/*
	purpose : 
	check key if exist 
	@param key 
	@return true if key exist 
*/
	public boolean containsKey(K key) {
		int hashCode = hashByUniversalHashing(key);
		LinkedList<Pair> pairs = (LinkedList<Pair>)this.table[hashCode];
		if (pairs == null)
			return false;
		for (Pair pair : pairs) {
			if (pair.key.equals(key)) {
				return true;
			}
		}	
		return false;
	}

	private class Pair {
		public K key = null;
		public V value = null;
		public Pair(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
}