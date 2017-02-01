package your_code;

import ADTs.StackADT;

/**
 * An implementation of the Stack interface.
 */
public class MyStack<T> implements StackADT<Integer> {
    private T[] stack;
    private int size;
    private int top;

    public MyStack(){
        stack = new T[10];
        top = -1;
    }

    @Override
    public void push(Integer e) {
        stack
    }

    @Override
    public Integer pop() {
        // TODO
        return null;
    }

    @Override
    public boolean isEmpty() {
        // TODO
        return false;
    }

    @Override
    public Integer peek() {
        // TODO
        return null;
    }

    public Integer maxElement() {
        // TODO
        return null;
    }
}
