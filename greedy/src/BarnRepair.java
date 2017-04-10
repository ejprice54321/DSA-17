import java.util.*;

public class BarnRepair {
    public static int solve(int M, int S, int C, int[] occupied) {
        Arrays.sort(occupied);
        int total = S;
        PriorityQueue<Integer> unoccupied = new PriorityQueue<>(S-C, Comparator.reverseOrder());
        for (int i = 1; i < occupied.length; i++) {
            int numEmpty = occupied[i] - occupied[i-1] - 1;
            if (numEmpty != 0) {
                unoccupied.add(numEmpty);
            }
        }

        total -= occupied[0]-1;
        total -= S - occupied[C-1];

        while (!unoccupied.isEmpty() && M>1){
            total -= unoccupied.poll();
            M--;
        }


        return total;
    }
//
//    public static void main(String args[]){
//        int M = 2;
//        int N = 10;
//        int C = 4;
//        int[] occupied = {2,4,6,8};
//        System.out.println(solve(M, N, C, occupied));
//    }
}
