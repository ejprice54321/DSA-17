package your_code;

import ADTs.StackADT;

/**
 * An implementation of the Stack interface.
 */
public class MyStack implements StackADT<Integer> {
    private Integer[] stackList;
    private int size;
    private int maxSize;
    private Integer[] stackBiggest;
    private int max;

    public MyStack(){
        stackList = new Integer[10];
        size = 0;
        stackBiggest = new Integer[10];
        maxSize = 0;
    }

    @Override
    public void push(Integer e) {
        if (size >= stackList.length){
            Integer[] bigger = new Integer[stackList.length * 2];
            System.arraycopy(stackList, 0, bigger, 0, stackList.length);
            stackList = bigger;
        }
        if (e > max){
            maxSize++;
            max = e;
            stackBiggest[maxSize] = e;
        }
        size++;
        stackList[size] = e;
    }

    @Override
    public Integer pop() {
        Integer lastElement = stackList[size];
        stackList[size] = stackList[size+1];
        size--;
        return lastElement;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Integer peek() {
        return stackList[size];
    }

    public Integer maxElement() {
        Integer biggestElement = stackBiggest[maxSize];
        stackBiggest[maxSize] = stackBiggest[maxSize+1];
        maxSize--;
        return biggestElement;
    }
}
