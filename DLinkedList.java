/*
	A Generic Doubly Linked List Implementation
	Using two Dummy Nodes Head & Tail
*/
public class DLinkedList<E> {
	
	private DNode<E> head = null;
	private DNode<E> tail = null;
	
	public DLinkedList() {
		this.head = new DNode<>();
		this.tail = new DNode<>();
		this.head.next = this.tail;
		this.tail.prev = this.head;
	}
	public void add(E data) {
		DNode<E> node = new DNode(data);
		this.tail.prev.next = node;
		node.prev = this.tail.prev;
		node.next = this.tail;
		this.tail.prev = node;
	}
	public void delete(E data) {
		DNode<E> ptr = this.head;
		while (ptr.next != this.tail) {
			if (ptr.next.data == data) {
				ptr.next.next.prev = ptr;
				ptr.next = ptr.next.next;
				return;
			}
			ptr = ptr.next;
		}
	}	
	public void print() {
		DNode<E> ptr = this.head;
		while (ptr.next != this.tail) {
			System.out.print(ptr.next.data + " ");
			ptr = ptr.next;
		}
		System.out.println();
	}
}


