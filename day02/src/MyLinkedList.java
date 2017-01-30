public class MyLinkedList<T> {

	private Node head;
	private Node tail;
	private int size;

	private class Node {
		T val;
		Node prev;
		Node next;

		private Node(T d, Node prev, Node next) {
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

	public void add(T e) {
		addLast(e);
	}

	public T pop() {
		return removeLast();
	}

	public void addLast(T e) {
		if (isEmpty()){
			head = new Node(e, null, null);
			tail = head;
		} else {
			Node newNode = new Node(e, tail, null);
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}

	public void addFirst(T e) {
		if (isEmpty()){
			head = new Node(e, null, null);
		} else {
			Node newNode = new Node(e, null, head);
			head.prev = newNode;
			head = newNode;
		}
		size++;
	}

	public T get(int index) {
		Node node = getNode(index);
		return node.val;
	}

	public Node getNode(int index){
			if (index < 0 || index >= size){
				throw new IndexOutOfBoundsException();
			}
			Node node = head;
			for (int i=0; i<index; i++){
				node = node.next;
			}
			return node;
	}

	public T remove(int index) {
		T c = get(index);
		if (index == 0){
			return removeFirst(); // ask NINJA if return statement is necessary
		} else if (index == (size-1)){
			return removeLast();
		} else {
			Node n = getNode(index);
			n.prev.next = n.next;
			n.next.prev = n.prev;
			size--;
			return n.val;
		}
	}

	public T removeFirst() {
		if (isEmpty()){
			throw new IndexOutOfBoundsException();
		}
		T problem = head.val;
		if (size == 1){
			head = null;
			tail = null;
		}else {
			head.prev = null;
			head = head.next;
		}
		size --;
		return problem;
	}

	public T removeLast() {
		if (isEmpty()){
			throw new IndexOutOfBoundsException();
		}
		T problem = tail.val;
		if (size == 1){
			head = null;
			tail = null;
		} else {
			tail = tail.prev;
			tail.next = null;
		}
		size--;
		return problem;
	}
}