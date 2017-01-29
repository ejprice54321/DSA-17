public class MyLinkedList {

	private Node head;
	private Node tail;
	private int size;

	private class Node {
		Chicken val;
		Node prev;
		Node next;

		private Node(Chicken d, Node prev, Node next) {
			this.val = d;
			this.prev = prev;
			this.next = next;
		}
	}

	public MyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void add(Chicken c) {
		addLast(c);
	}

	public Chicken pop() {
		return removeLast();
	}

	public void addLast(Chicken c) {
		if (isEmpty()){
			head = new Node(c, null, null);
		} else {
			Node newNode = new Node(c, tail, null);
		}
		size++
	}

	public void addFirst(Chicken c) {
		if (isEmpty()){
			head = new Node(c, null, null);
		} else {
			Node newNode = new Node(c, null, head);
		}
		size++;
	}

	public Chicken get(int index) {
		if (index < 0 || index >= size){
			throw new IndexOutOfBoundsException();
		}
		Node node = head;
		for (int i=0; i<index; i++){
			node = node.next;
		}
		return node;
	}

	public Chicken remove(int index) {
		Chicken c = get(index);
		if (index == 0){
			head = head.next;
		} else{
			Node node = node.prev;

		}
		return null;
	}

	public Chicken removeFirst() {
		// TODO
		size --;
		return null;
	}

	public Chicken removeLast() {
		// TODO
		size--;
		return null;
	}
}