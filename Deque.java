public class Deque<E> {

	 private Node<E> head = null;
	 private Node<E> tail = null;
	 private int size = 0;
	 private int threshold = 0;
	 public Deque(int threshold) {
	 		this.threshold = threshold;
	 }
	 /* add element to the end */
	 public boolean push(E data) {
		if (data == null)
			throw new NullPointerException();
		if (this.size >= this.threshold)
			return false;
		this.size++;
		Node<E> current = new Node<>(data);
		if (this.isEmpty()) {
			this.tail = current;
			this.head = current;
			return true;
		}
		this.tail.next = current;
		current.prev = this.tail;
		this.tail = current;
		return true;
	 }
	 /* remove element from front */
	 public E poll() {
	 	if (this.isEmpty()) {
	 		return null; // assumption for empty deque
	 	}
	 	this.size--;
	 	E data = this.head.data;
	 	this.head = this.head.next;
	 	if (this.head == null)
	 		this.tail = null;
	 	else	
	 		this.head.prev = null;
	 	return data;
	 }
	 /* remove element from end */
	 public E pop() {
		if (this.isEmpty()) {
	 		return null; // assumption for empty deque
	 	}
	 	this.size--;
	 	E data = this.tail.data;
	 	this.tail = this.tail.prev;
	 	if (this.tail == null)
	 		this.head = null;
	 	else	
	 		this.tail.next = null;
	 	return data;
	 }
	 
	 public boolean isEmpty() {
			return (head == null && tail == null);	 
	 }
	 
	 private class Node<E> {
		   public E data = null;
		   public Node<E> next = null;
		   public Node<E> prev = null;
		   public Node(E data) {
		   		this.data = data;
		   }	 
	 }
}
