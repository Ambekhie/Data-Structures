import java.util.LinkedList;
/** 
 * HASHING by CHAINING Implementation
 * @author Btatsaya
*/
public class ClosedAddressing<K, V> extends HashTable<K, V> {
/**
 *  Class constructor delegating to super class 
 */	
	public ClosedAddressing() {
		super();
	}

	@Override
	protected void rehashTable() {
		Object[] temp = this.table;
		this.size++; // double current size
		this.elements = 0;
		this.table = new Object[(1 << this.size)];
		for (Object object : temp) {
			if (object == null)
				continue;
			LinkedList<Pair> pairs = (LinkedList<Pair>) object;
			for (Pair pair : pairs) {
				this.put(pair.key, pair.value);
			}
		}
	}

	@Override
	public boolean delete(K key) {
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

	@Override
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

	@Override
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

	@Override
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
}