public class Stocks {

    public int maxProfit(int[] prices) {
        int max = -1;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                if ((prices[j]-prices[i])>max){
                    max = prices[j] - prices[i];
                }
            }

        }
        return max;
    }

    public int maxProfitWithK(int[] prices, int k) {
        // TODO: Optional
        return -1;
    }

}
