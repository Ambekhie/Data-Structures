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
						
	}

}
