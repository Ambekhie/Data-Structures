public class Test {

	public static void main(String[] arg0) {
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
	}

}
