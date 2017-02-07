public class Queue<E> {
	
	private Node<E> head = null;
	private Node<E> tail = null;
	
	public void enqueue(E data) {
		  if (data == null) 
		  	throw new NullPointerException(); //Assumption
		  Node<E> node = new Node<>(data);
		  if (tail == null) {	//Check for empty queue
		  	tail = node;
		  	head = node;
		  	return;
		  }
		  tail.next = node;
		  tail = node;
	}
	
	public E dequeue() {
			if (head == null)
				return null; //Assumption
			Node<E> top = head;
			head = head.next;
			if (head == null) //Check for empty queue
				tail = null;
			return top.data;	
	}
	
	public boolean isEmpty() {
		  return head == null && tail == null; //tail & head are always consistent
	}

	private class Node<E>{
		public E data = null;
		public Node<E> next = null;
		public Node(E data) {
			this.data = data;
		}
	}
}
