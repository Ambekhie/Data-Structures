/** 
 * HASHING by PROBING Implementation
 * @author Btatsaya
*/
public class OpenAddressing<K, V> extends HashTable<K, V> {
/**
 *  Class constructor delegating to super class 
 */	
	public OpenAddressing() {
		super();
	}

/**
 *	hash key by linear probing technique
 *	@param Key to be hashed
 *	@param i to be used in hashing
 *  @return int hash code compressed to current table size
*/
	private int hashByLinearProbing(K key, int i) {
		if (key == null) {
			return -1; // NOT REACHED
		}
		int hash = hashByUniversalHashing(key);
		return (hash + i) % (1 << this.size);
	}
/**
 *	hash key by quadratic probing technique
 *	@param Key to be hashed
 *	@param i to be used in hashing
 *  @return int hash code compressed to current table size
*/
	private int hashByQuadraticProbing(K key, int i) {
		if (key == null) {
			return -1; // NOT REACHED
		}
		int hash = hashByUniversalHashing(key);
		return Math.abs(hash + this.paramA * i + this.paramB * i * i) % (1 << this.size);
	}
/**
 *	hash key by quadratic probing technique
 *	@param Key to be hashed
 *	@param i to be used in hashing
 *  @return int hash code compressed to current table size
*/
	private int hashByDoubleHashing(K key, int i) {
		if (key == null) {
			return -1; // NOT REACHED
		}
		int hash1 = hashByMultiplication(key);
	    int hash2 = hashByUniversalHashing(key); 
	   /**
		*	NOT guranteed to be relatively prime with (1 << size)
		*	NOT guranteed to be odd
		*	uniform hashing analysis is not guranteed
	   */
		return Math.abs(hash1 + hash2 * i) % (1 << this.size);
	}

	@Override
	public boolean put(K key, V value) {
		if (key == null || this.isFull() || this.containsKey(key)) {
			return false;
		}
		int i = 0;
		int index = 0;
		while (i < (1 << this.size)) {
			index = hashByLinearProbing(key, i++);
			Pair pair = (Pair)this.table[index];
			if (pair == null || pair.state == State.DELETED) {
				this.table[index] = new Pair(key, value);
				break;
			}
		}
		this.elements++;
		updateLoadFactor();
		return true;
	}

	@Override
	public boolean containsKey(K key) {
		if (key == null) {
			return false;
		}
		int i = 0;
		int index = 0;
		while (i < (1 << this.size)) {
			index = hashByLinearProbing(key, i++);
			Pair pair = (Pair)this.table[index];
			if (pair == null) {
				return false;
			}else if (pair.state != State.DELETED && pair.key.equals(key)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delete(K key) {
		if (key == null || !this.containsKey(key)) {
			return false;
		}
		int i = 0;
		int index = 0;
		while (i < (1 << this.size)) {
			index = hashByLinearProbing(key, i++);
			Pair pair = (Pair)this.table[index];
			if (pair.state != State.DELETED && pair.key.equals(key)) {
				this.table[index] = new Pair();
				this.elements--;
				updateLoadFactor();
				return true;
			}
		}
		return false; // NOT REACHED
	}

	@Override
	public V get(K key) {
		if (key == null || !this.containsKey(key)) {
			return null;
		}
		int i = 0;
		int index = 0;
		while (i < (1 << this.size)) {
			index = hashByLinearProbing(key, i++);
			Pair pair = (Pair)this.table[index];
			if (pair.state != State.DELETED && pair.key.equals(key)) {
				return pair.value;
			}
		}
		return null; // NOT REACHED
	}

	@Override
	public void rehashTable() {
		Object[] temp = this.table;
		this.size++; // double table size
		this.elements = 0;
		this.table = new Object[(1 << this.size)];
		for (Object element : temp) {
			Pair pair = (Pair)element;
			if (pair == null || pair.state == State.DELETED)
				continue;
			this.put(pair.key, pair.value);
		}
	}
}	