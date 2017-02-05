public class DNode<E> {
	public DNode<E> next = null;
	public DNode<E> prev = null;
	public E data = null;
	
	public DNode() {}
	public DNode(E data) {
		this.data = data;
	}
}
