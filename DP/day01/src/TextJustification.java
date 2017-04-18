import java.util.*;

public class TextJustification {
    static List<Integer> starts = new ArrayList<>();

    public static List<Integer> justifyText(String[] w, int m) {
        int[] textMemo = new int[w.length+1];

        for (int i=0; i < textMemo.length; i++){
            textMemo[i] = -1;
        }
        int test = justifyRecursion(w, m, 0, textMemo);
        return starts;
    }

    private static int justifyRecursion(String[] w, int m, int i, int[] textMemo){
        int minCost = (int)Double.POSITIVE_INFINITY;
        int totCost = 0;
        if (i == w.length) return 0;
        for (int j = i+1; j < w.length; j++){
            if(textMemo[j] == -1) justifyRecursion(w, m, j, textMemo);
            else{
                totCost = cost(Arrays.copyOfRange(w, i, j), m) + textMemo[j];
                minCost = totCost;
            }
            textMemo[i] = minCost;
        }
        return minCost;
    }

    private static int cost(String[] l, int m){
        int totalLength = l.length-2;
        for (String w: l){
            totalLength += w.length();
        }
        if (totalLength > m){
            return 2147483647;
        } else {
            return (int)Math.pow((m - totalLength), 3);
        }
    }

}

//    public static List<Integer> justifyText(String[] w, int m) {
//        int[] textMemo = new int[w.length+1];
//
//        for (int i=0; i < textMemo.length; i++){
//            textMemo[i] = -1;
//        }
//        int test = justifyRecursion(w, m, 0, 0, textMemo);
//        return starts;
//    }
//
//    private static int justifyRecursion(String[] w, int m, int beginning, int end, int[] textMemo){
//        // base case, you've reached the end of the string of words
//        if (end == w.length) return 0;
//
//        //update memo
//
//        // for every value j from i+1 until w, try to find the min cost from i until j
//        // ********** then build back up once you find it
//        // move the window to the next line
//        int min = -1;
//        int index = beginning;
//
//        for (int i = beginning+1; i < w.length; i++) {
//            String[] l = Arrays.copyOfRange(w, beginning, i);
//            if (cost(l, m) != 2147483647) {
//                if (min == -1 || cost(l, m) < min) {
//                    min = cost(l, m);
//                    index = i;
//                }
//            }
//            System.out.println(i);
//            starts.add(i-1);
//            break;
//        }
//
//        return  min + justifyRecursion(w,m, index, index+1, textMemo);
//    }

//public class DPTemplate {

    /** MEMO */


    //CONSTANTS


    //PUBLIC FUNCTION
//    public long publicFunction(/* User inputs */){

        /** INITIALIZE THE MEMO */


        // SET GLOBAL CONSTANTS


        // CALL RECURSIVE FUNCTION ON PROBLEM THAT YOU WANT TO SOLVE

//        return 0;


//    }

//    private long recursiveFunction(/* Only arguments that are part of subproblem */){

        // BASE CASES


        /** HAS THIS BEEN MEMOIZED? */


        // RECURRENCE RELATION


        /** UPDATE THE MEMO */


        // RETURN THE ANSWER

//        return 0;

//    }

//}