import static sun.swing.MenuItemLayoutHelper.max;

public class CountingSort {

    /**
     * Use counting sort to sort positive integer array A.
     * Runtime: TODO
     */
    static void countingSort(int[] A) {
        int k = max(A);
        int[] counts = new int[k+1];
        for (int e: A) {
            counts[e]++;
        }
        int i = 0;
        for (int j = 0; j <= k; j++) {
            while(counts[j]-- > 0){
                A[i++] = j;
            }
        }

    }

}
