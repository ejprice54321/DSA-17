package your_code;

import ADTs.QueueADT;

/**
 * An implementation of the Queue interface.
 */
public class MyQueue implements QueueADT<Integer> {

    private Node head;
    private Node tail;
    private int size;

    private class Node{
        Integer val;
        Node prev;
        Node next;

        private Node(Integer e, Node prev, Node next){
            this.val = e;
            this.prev = prev;
            this.next = next;
        }
    }

    public MyQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(Integer item) {
        if (isEmpty()){
            head = new Node(item, null, null);
            tail = head;
        } else{
            Node newNode = new Node(item, null, head);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public Integer dequeue() {
        if (isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        Integer removed = tail.val;
        if (size == 1){
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return removed;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public Integer front() {
        return head.val;
    }
}