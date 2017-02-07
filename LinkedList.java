/*
	A Generic Single Linked List Implementation
	Using a Dummy Head Node
*/
public class LinkedList<E> {
	
	private Node<E> head = null;
	public LinkedList() {
		this.head = new Node<>();
	}
	public void add(E data) {
		Node<E> last = new Node<>(data);
		Node<E> ptr = this.head;
		while (ptr.next != null) {
			ptr = ptr.next;		
		}
		ptr.next = last;
	}
	public void delete(E data) {
		Node<E> ptr = this.head;
		while (ptr.next != null) {
			if (ptr.next.data == data) {
				ptr.next = ptr.next.next;
				return;
			}
			ptr = ptr.next;
		}
	}
	public void print() {
		Node<E> ptr = this.head;
		while (ptr.next != null) {
			System.out.print(ptr.next.data + " ");
			ptr = ptr.next;
		}
		System.out.println();
	}
	
	private class Node<E> {
	public Node<E> next = null;
	public E data = null;
	public Node() {}
	public Node(E data) {
		this.data = data;
	}
}
}


