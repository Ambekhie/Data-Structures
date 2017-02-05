public class Node<E> {
	public Node<E> next = null;
	public E data = null;
	public Node() {}
	public Node(E data) {
		this.data = data;
	}
}
