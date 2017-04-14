import java.util.*;
public class BillsNeeded {


    public int billsNeeded(int N, int[] billDenominations) {

        int[] billMemo = new int[N+1];

        for (int i = 0; i < N+1; i++) {
            billMemo[i] = -1;
        }

        return billDP(N, billDenominations, billMemo);
        }

    private int billDP(int amtLeft, int[] billDenominations, int[] billMemo){

        if (amtLeft == 0) return 0; //base case

        if (billMemo[amtLeft] != -1) return billMemo[amtLeft]; //check memo and step up

        int min = -1;

        for (int i: billDenominations) { //test all children states
            int next = amtLeft - i;
            /*If you can actually continue on and if either the min hasn't been set or you are smaller than the min,
            * reset the min to be your size*/
            if ((next >= 0) && (min == -1 || billDP(next, billDenominations, billMemo) < min)){
                min = billDP(next, billDenominations, billMemo);
            }
        }

        billMemo[amtLeft] = min+1; //set the memo

        return min + 1; // return the min steps to your state

    }

}
