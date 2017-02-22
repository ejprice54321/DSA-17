
public class InsertionSort extends SortAlgorithm {
    /**
     * Use the insertion sort algorithm to sort the array
     *
     * Best-case runtime: n
     * Worst-case runtime: n^2
     * Average-case runtime: n^2
     *
     * Space-complexity: 1
     */
    @Override
    public int[] sort(int[] array) {
        for (int i = 0; i<array.length; i++){
            if (i == 0){

            }
            while (array[i] < array[i-1]){
                int temp = array[i-1];
                array[i-1] = array[i];
                array[i] = temp;
            }
        }
        return array;
    }
}
