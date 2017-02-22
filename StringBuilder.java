public class StringBuilder {
	
	private ArrayList<String> builder = null;
	private int size = 0;
	public StringBuilder() {
		this.builder = new ArrayList<>();
	}
	public StringBuilder(int capacity) {
		this.builder = new ArrayList<>(capacity);
	}
	public StringBuilder(String string) {
		this.builder = new ArrayList<>();
		this.builder.add(string);
		this.size = string.length();
	}
	public void append(Object object) {
		String string = String.valueOf(object);
		this.builder.add(string);
		this.size += string.length();
	}
	
	public String toString() {
		char[] sequence = new char[this.size];
		int start = 0;
		for (int index = 0; index < this.builder.length(); index++) {
			String string = this.builder.get(index);
			concat(string, sequence, start);
			start += string.length();
		}
		return new String(sequence);
	}
	private void concat(String string, char[] sequence, int start) {
		for (int offset = 0; offset < string.length(); offset++) {
			sequence[start + offset] = string.charAt(offset);
		}
	}
	public void remove(int index) {
		String removed = this.builder.get(index);
		this.builder.remove(index);
		this.size -= removed.length();
	}
}