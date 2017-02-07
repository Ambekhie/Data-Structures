import java.util.EmptyStackException;

public class Stack<E> {
	
	private Node<E> head = null;
	private int size = 0;
	private int threshold = Integer.MAX_VALUE;
	public Stack() {}
	public Stack(int threshold) {
		  this.threshold = threshold;
	}
	
	public boolean push(E data) {
		 if (size == this.threshold)	//check threshold is reached or not
		 	return false;
		 Node<E> top = new Node<>(data);
		 top.next = head;
		 head = top;
		 this.size++;
		 return true;
	}
	
	public E pop() {
		 if (this.isEmpty())
		 	throw new EmptyStackException(); // Assumption
		 this.size--;
		 E top = head.data;
		 head = head.next;
		 return top;
	}
	
	public E peek() {
		 if (this.isEmpty())
		 	throw new EmptyStackException(); // Assumption
		 return head.data;
	}
	
	public boolean isEmpty() {
		  return (head == null);
	}
	
	private class Node<E> {
		public E data = null;
		public Node<E> next = null;
		public Node(E data) {
			this.data = data;
		}
	}
}
