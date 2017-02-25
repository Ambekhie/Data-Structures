public abstract class HashTable<K, V> {
	protected Object[] table = null;
	protected int size = 5;						//  Initial size (1 << 5)
	protected final int MAX_SIZE = 30;			//	MAX SIZE (1 << 30) 1GB
	protected int elements = 0;
	protected int paramA = 0;						//  random paramA for universal hashing
	protected int paramB = 0;						//  random paramB for universal hashing
	protected double loadFactor = 0.0;			//	Load Factor (average)
	protected final double MAX_LOAD_FACTOR = 0.7;
	protected final int PRIME_NUMBER = 1073741827; // next prime greater to max size
	protected enum State {
		DELETED,
		EXIST
	}
/**
 * Class constructor intializing table 
 * generating random params
*/
	public HashTable() {
		this.table = new Object[(1 << this.size)];
		this.paramA = (int)(Math.random() * PRIME_NUMBER);
		this.paramB = (int)(Math.random() * PRIME_NUMBER);
	}
/**
 *	puts a key and value to the table 
 *	@param Key to be hashed and inserted
 *  @param value to be inserted for the specified key
 *	@return false if key already exist false otherwise
*/
	public abstract boolean put(K key, V value);
/**
 *	lookup a key in the table 
 *	@param Key to be hashed and looked for
 *  @return true if key exists false otherwise
*/
	public abstract boolean containsKey(K key);	
/**
 *	deletes a key from a table if exist 
 *	@param key to delete
 *  @return true if key exist, false otherwise
*/
	public abstract boolean delete(K key);
/**
 *	gets a value from table coressponding to key 
 *	@param key to get its value
 *  @return value if key exist, null otherwise
*/
	public abstract V get(K key);
/**
 *	doubles table size and rehashes all elements  
 *	@param no params
 *  @return no return
*/
	protected abstract void rehashTable();
 /**
 *	updates current load factor of table 
 *	@param no params
 *  @return no return
*/
	protected void updateLoadFactor() {
		this.loadFactor = ((double)this.elements/(1 << this.size));
		if (this.loadFactor >= MAX_LOAD_FACTOR && this.size < MAX_SIZE) {
			this.rehashTable();
		}	
	}
/**
 *	hash key by universal hash family
 *	@param Key to be hashed
 *  @return int hash code compressed to current table size
*/
	protected int hashByUniversalHashing(K key) {
		int size = (1 << this.size);
		return ((Math.abs(this.paramA * key.hashCode() + this.paramB) % (PRIME_NUMBER)) % size);
	}
/**
 *	hash key by multiplication
 *	@param Key to be hashed
 *  @return int hash code compressed to current table size
*/
	protected int hashByMultiplication(K key) {
		int r = size;
		int w = MAX_SIZE;
		return ((Math.abs(key.hashCode() * this.paramA) % (1 << w)) >> w - r);
	}
/**
 *	hash key by division
 *	@param Key to be hashed
 *  @return int hash code compressed to current table size
*/	
	protected int hashByDivision(K key) {
		return (key.hashCode() % (1 << this.size));
	}
/**
 *	checks if table is full 
 *	@param no params
 *  @return true if table is full, false otherwise
*/
	public boolean isFull() {
		return (this.elements == (1 << this.size));
	}	
/**
 *	checks if table is Empty 
 *	@param no params
 *  @return true if table is Empty, false otherwise
*/
	public boolean isEmpty() {
		return (this.elements == 0);
	}	
/**
 *	checks if table if full 
 *	@param no params
 *  @return true if table is full, false otherwise
*/
	protected class Pair {
		public K key = null;
		public V value = null;
		public State state = null;
		public Pair() {
			state = State.DELETED;
		}
		public Pair(K key, V value) {
			this.key = key;
			this.value = value;
			this.state = State.EXIST;
		}
	}		
}