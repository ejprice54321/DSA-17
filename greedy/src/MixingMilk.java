import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MixingMilk {
    public static int solve(int M, int N, int[] units, int[] price) {
        List<Integer> priceList = new ArrayList<Integer>(price.length);
        for (int i : price) priceList.add(i);
        int minSpend = 0;
        int cheapestMilk = 0;
        while (M>0){
            cheapestMilk = Collections.min(priceList);
            int i = priceList.indexOf(cheapestMilk);
            int maxSpend = Collections.max(priceList);

            if (M < units[i]){
                minSpend += M*cheapestMilk;
                return minSpend;
            } else {
                minSpend += units[i]*cheapestMilk;
                M-=units[i];
                priceList.remove(i);
                priceList.add(i, maxSpend);
            }
        }
        return minSpend;
    }
}
