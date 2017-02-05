/*
	A Single Linked List Implementation
*/
public class LinkedList<E> {
	
	private Node<E> head = null;
	public LinkedList() {
		head = new Node<>();
	}
	public void add(E data) {
		head.append(data);
	}
	public void delete(E data) {
		head.delete(data);
	}
	public void print() {
		head.print();
	}
}


