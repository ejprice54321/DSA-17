import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Problems {

    private static PriorityQueue<Integer> minPQ() {
        return new PriorityQueue<>(11);
    }

    private static PriorityQueue<Integer> maxPQ() {
        return new PriorityQueue<>(11, Collections.reverseOrder());
    }

    private static double getMedian(List<Integer> A) {
        double median = (double) A.get(A.size()/2);
        if (A.size() % 2 == 0)
            median = (median + A.get(A.size()/2-1))/2.0;
        return median;
    }

    // Runtime of this algorithm is O(N^2). Sad! We provide it here for testing purposes
    public static double[] runningMedianReallySlow(int[] A) {
        double[] out = new double[A.length];
        List<Integer> seen = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            int j = 0;
            while (j < seen.size() && seen.get(j) < A[i])
                j++;
            seen.add(j, A[i]);
            out[i] = getMedian(seen);
        }
        return out;
    }


    /**
     *
     * @param inputStream an input stream of integers
     * @return the median of the stream, after each element has been added
     */
    public static double[] runningMedian(int[] inputStream) {
        double[] runningMedian = new double[inputStream.length];
        PriorityQueue<Integer> minPQ = minPQ();
        PriorityQueue<Integer> maxPQ = maxPQ();
        int index = 0;
        for (int i: inputStream){
            if (maxPQ.isEmpty() || i < maxPQ.peek()) {
                maxPQ.offer(i);
            } else {
                minPQ.offer(i);
            }
            if (maxPQ.size() < minPQ.size()) {
                maxPQ.offer(minPQ.poll());
            } else if (minPQ.size() + 1 < maxPQ.size()) {
                minPQ.offer(maxPQ.poll());
            }
            if (maxPQ.size() == minPQ.size()){
                runningMedian[index] = (minPQ.peek()+ maxPQ.peek())/2.0;
                index ++;
            } else if (maxPQ.size() > minPQ.size()) {
                runningMedian[index] = maxPQ.peek();
                index++;
            } else {
                System.out.println("OOPSIES");
            }
        }
        return runningMedian;
    }

}
