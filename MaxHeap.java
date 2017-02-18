import java.util.ArrayList;
import java.util.Collection;
/* build // insert // extract // sort */
public class MaxHeap<E extends Comparable<E>> {
	private ArrayList<Node> heap = null;
	public MaxHeap(int InitialCapacity) {
		this.heap = new ArrayList<Node>(InitialCapacity);
	}
	public MaxHeap(Collection<? extends E> collection, int InitialCapacity) {
		this.heap = new ArrayList<Node>(InitialCapacity);
		int size = collection.size(); 
		Object[] array = collection.toArray();
		for (int i = 0; i < size; i++) {	// Add elements to heap
			this.heap.add(new Node(i, (E)array[i]));
		} 	
		for (int i = size/2; i >= 0; i--) {	// build MAX heap in O(n)
			this.maxHeapify(this.heap.get(i));
		}
	}	
	private void maxHeapify(Node root) {
		if (root == null) 
			return;
		Node left = root.getLeftChild();
		Node right = root.getRightChild();
		Node maxChild = root;
		if (right != null && maxChild.compareTo(right) <= 0) 
			maxChild = right;
		if (left != null && maxChild.compareTo(left) <= 0)
			maxChild = left;
		if (root != maxChild) {	// Contradicts heap property
			root.swap(maxChild);
			maxHeapify(root);
		}
	}
	public boolean insert(E data) {
		if (data == null) 
			return false;
		Node node = new Node(this.heap.size(), data);
		this.heap.add(node);
		Node parent = node.getParent();	// to maintain heap property
		while (parent != null && node.compareTo(parent) > 0) {	// traverse up to the root
			node.swap(parent);
			maxHeapify(parent);
			parent = node.getParent();
		}	
		return true;
	}
	public E getMax() {
		if (this.heap.isEmpty())
			return null;
		return this.heap.get(0).getData();
	}
	public E extractMax() {
		if (this.heap.isEmpty())
			return null;
		if (this.heap.size() == 1) 
			return this.heap.remove(0).getData();
		Node peek = this.heap.get(0);
		peek.swap(this.heap.get(this.heap.size() - 1));
		peek = this.heap.remove(this.heap.size() - 1);
		this.maxHeapify(this.heap.get(0));
		return peek.getData();	
	}
	public ArrayList<E> sort() {
		ArrayList<E> sorted = new ArrayList<>();
		ArrayList<Node> clone = new ArrayList<>();
		for (Node current : this.heap) {
			clone.add((Node)current.clone());
		}
		int index = 0;
		while (!this.heap.isEmpty()) {
			sorted.add(this.extractMax());
		}
		this.heap = clone;
		return sorted;
	}
	private class Node implements Comparable<Node>{
		public E data = null;
		public int index = 0;
		public Node(int index, E data) {
			this.index = index;
			this.data = data;
		}
		public int getIndex() {
			return this.index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		public Node getParent() {
			if (this.index == 0)
				return null;
			return heap.get(this.index/2);
		}
		public Node getLeftChild() {
			if (2 * this.index + 1 >= heap.size())
				return null;
			return heap.get(2 * this.index + 1);
		}
		public Node getRightChild() {
			if (2 * this.index + 2 >= heap.size())
				return null;
			return heap.get(2 * this.index + 2);
		}
		public E getData() {
			return this.data;
		}
		@Override
		public int compareTo(Node node) {
			return this.data.compareTo(node.getData());
		}
		@Override
		public Object clone() {
			return new Node(this.index, this.data);
		}
		public void swap(Node node) {
			int tempIndex = this.index;
			this.setIndex(node.getIndex());
			node.setIndex(tempIndex);
			heap.set(this.getIndex(), this);
			heap.set(node.getIndex(), node);
		}
	}
}
