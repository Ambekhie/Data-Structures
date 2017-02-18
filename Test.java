import java.util.ArrayList;
public class Test {
	public static void main(String[] arg0) {
		System.out.println("/* Single linked List of Integers --------------- */");
		LinkedList<Integer> list = new LinkedList<>();
		// test add node
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.print();
		// test delete node
		list.delete(1);
		list.print();
		list.delete(4);
		list.print();
		System.out.println("/* Double linked List of Integers ---------------- */");
		DLinkedList<Integer> Dlist = new DLinkedList<>();
		// test add node
		Dlist.add(1);
		Dlist.add(2);
		Dlist.add(3);
		Dlist.add(4);
		Dlist.print();
		// test delete node
		Dlist.delete(1);
		Dlist.print();
		Dlist.delete(4);
		Dlist.print();
		System.out.println("/* Queue of Integers ---------------------------- */");
		Queue<Integer> queue = new Queue<>();
		// test enqueue
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		// test isEmpty & dequeue
		while (!queue.isEmpty())
			System.out.println(queue.dequeue());
		
		System.out.println("/* Stack of Integers ---------------------------- */");
		Stack<Integer> stack = new Stack<>(3);
		// test push
		System.out.println("push 1 " + stack.push(1));
		System.out.println("push 2 " + stack.push(2));
		System.out.println("push 3 " + stack.push(3));
		System.out.println("push 4 " + stack.push(4));
		// test isEmpty & pop
		while (!stack.isEmpty())
			System.out.println("pop " + stack.pop());
		
		System.out.println("/* Deque of Integers ---------------------------- */");
		Deque<Integer> deque = new Deque<>(3);
		// test push
		System.out.println("push 1 " + deque.push(1));
		System.out.println("push 2 " + deque.push(2));
		System.out.println("push 3 " + deque.push(3));
		System.out.println("push 4 " + deque.push(4));
		// test isEmpty & pop
		System.out.println("pop " + deque.pop());
		System.out.println("poll " + deque.poll());
		System.out.println("pop " + deque.pop());
		
		System.out.println("/* Trie of Characters ---------------------------- */");
		Trie trie = new Trie();
		// test insert word
		System.out.println("insert potato " + trie.insert("potato"));
		System.out.println("insert btatsaya " + trie.insert("btatsaya"));
		System.out.println("insert poo " + trie.insert("poo"));
		System.out.println("insert null " + trie.insert(null));
		System.out.println("insert '' " + trie.insert(""));
		// test find word
		System.out.println("find pOtaTo " + trie.find("potato"));
		System.out.println("find null " + trie.find(null));
		System.out.println("find PoO " + trie.find("PoO"));
		// test delete word
		System.out.println("delete PoO " + trie.delete("PoO"));
		System.out.println("find PoO " + trie.find("PoO"));
		System.out.println("delete foo " + trie.find("foo"));

		System.out.println("/* MAXHEAP of Strings ---------------------------- */");
		MaxHeap<String> heap = new MaxHeap<>(4);
		// test insert word
		System.out.println("insert potato " + heap.insert("potato"));
		System.out.println("insert btatsaya " + heap.insert("btatsaya"));
		System.out.println("insert poo " + heap.insert("poo"));
		System.out.println("insert null " + heap.insert(null));
		// test max extract word
		System.out.println("extract max " + heap.extractMax());
		// test sort
		System.out.println("Sorted List :");
		for (String x : heap.sort()) {
			System.out.println(x);
		}
		//test build
		System.out.println("Build {a, d, s, b} :");
		ArrayList<String> temp = new ArrayList<>();
		temp.add("a");
		temp.add("d");
		temp.add("s");
		temp.add("b");
		heap = new MaxHeap<String>(temp, 4);
		System.out.println("extract max " + heap.extractMax());
		System.out.println("extract max " + heap.extractMax());
		System.out.println("extract max " + heap.extractMax());
		System.out.println("extract max " + heap.extractMax());
		System.out.println("extract max 'EMPTY' " + heap.extractMax());
		return;
	}

}
