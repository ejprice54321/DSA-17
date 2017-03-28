public class ReviewProblem {



    public static int minimumLengthSubArray(int[] A, int desiredSum) {
        int temp = 100000000;
        int smallest = temp;
        int currentSum;
        for (int start = 0; start<A.length; start++){
            currentSum = A[start];
            if (currentSum >= desiredSum){
                temp = 1;
                if (temp<smallest) smallest = temp;
            }
            int end=start +1;
            while (currentSum <= desiredSum && end < A.length){
                currentSum += A[end];
                if (currentSum >= desiredSum){
                    temp = end-start+1;
                    if (temp<smallest) smallest = temp;
                }
                end++;
            }

        }
        if (smallest == 100000000){
            return 0;
        }
        return smallest;
    }

}
