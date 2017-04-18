import java.util.Arrays;
import java.util.Collections;

public class EditDistance {

    public static int minEditDist(String a, String b) {
        char[] newA = a.toCharArray();
        char[] newB = b.toCharArray();
        int[][] memo = new int[newA.length+1][newB.length+1];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                memo[i][j] = -1;
            }
        }
        return editRecursion(newA, newB, memo);
    }

    private static int editRecursion(char[] a, char[] b, int[][] memo){
        for (int i = 0; i <= a.length; i++) {
            for (int j = 0; j <= b.length; j++) {
                if (i == 0) memo[i][j] = j;
                else if (j == 0) memo[i][j] = i;
                else if (a[i-1] == b[j-1]){
                    memo[i][j] = memo[i-1][j-1];
                }else{
                    memo[i][j] = 1 + Math.min(Math.min(memo[i][j-1], memo[i-1][j]), memo[i-1][j-1]);
                }
            }
        }
        return memo[a.length][b.length];
    }
}
