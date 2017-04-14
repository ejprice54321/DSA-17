import java.util.stream.IntStream;

public class SplitCoins {
    public int splitCoins(int[] coins) {
        int[][] memo = new int[coins.length+1][IntStream.of(coins).sum()+1];

        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                memo[i][j] = -1;
            }
        }
        return minDifference(coins, 0, 0, memo);
    }

    private int minDifference(int[] coins, int pointer, int difference, int[][] memo){
        if (pointer == coins.length) return difference;

        if (memo[pointer][Math.abs(difference)] != -1) return memo[pointer][Math.abs(difference)];

        memo[pointer][Math.abs(difference)] = Math.min(Math.abs(minDifference(coins, pointer+1, difference-coins[pointer], memo)),
                Math.abs(minDifference(coins, pointer+1, difference+coins[pointer], memo)));

        return memo[pointer][Math.abs(difference)];

    }
}
