package your_code;
import java.util.*;

/**
 * An implementation of a priority Queue
 */
public class MyPriorityQueue {

    ArrayList<Integer> MyPriorityQueue = new ArrayList<Integer>();

    public void enqueue(int item) {
        this.MyPriorityQueue.add(item);
    }

    /**
     * Return and remove the largest item on the queue.
     */
    public int dequeueMax() {
        Integer biggest = 0;
        for (Integer item: MyPriorityQueue){
            if(item > biggest){
                biggest = item;
            }
        }
        MyPriorityQueue.remove(biggest);
        return biggest;
    }

}