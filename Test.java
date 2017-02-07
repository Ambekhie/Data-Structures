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
		// test empty & dequeue
		while (!queue.isEmpty())
			System.out.println(queue.dequeue());
		System.out.println("/* Stack of Integers ---------------------------- */");
	}

}
