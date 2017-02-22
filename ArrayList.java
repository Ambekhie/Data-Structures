
public class ArrayList<T> {
	private Object[] array = null;
	private int size = 0;
	private int last = -1;
	public ArrayList(){
		this.array = new Object[this.size];
	}
	public ArrayList(int capacity) {
		this.size = capacity;
		this.array = new Object[this.size];
	}	
	
	private void resizeArray(int newSize) {
		Object[] temp = new Object[newSize];
		for (int i = 0; i <= this.last; i++) {
			temp[i] = this.array[i];
		}
		this.array = temp; 
		this.size = newSize;
	}
	
	public void add(T data) {
		if (this.last + 1 == this.size) {
			resizeArray((this.isEmpty())? 1 : 2 * this.size);
		}
		this.array[++this.last] = data;
	}	
	
	public void set(int index, T data) {
		if (index < 0 || index > this.last) {
			throw new IndexOutOfBoundsException();			
		}
		this.array[index] = data;
	}	
	
	public T get(int index) {
		if (index < 0 || index > this.last) {
			throw new IndexOutOfBoundsException();
		}
		return (T) this.array[index];
	}	

	public void remove(int index) {
		if (index < 0 || index > this.last) {
			throw new IndexOutOfBoundsException();	
		}	
		for (int i = index; i < this.last; i++) {
			this.array[i] = this.array[i + 1];
		}
		if (--this.last < this.size/4) {
			resizeArray(this.size/2);
		}
	}

	public int length() {
		return this.last + 1;
	}

	public boolean isEmpty() {
		return this.last == -1;
	}
}
