public class DungeonGame {

    public static int minInitialHealth(int[][] map) {
        int[][] memo = new int[map.length][map[0].length];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                memo[i][j] = -1;
            }
        }
        return healthDP(map, memo);
    }

    private static int healthDP(int[][] map, int[][] memo){
        for (int i = memo.length-1; i >= 0; i--) {
            for (int j = memo[0].length-1; j >= 0; j--) {
                String Memo = toString(memo);
                String AC = toString(map);
                if (i == map.length-1 && j == map[0].length-1) memo[i][j] = map[map.length-1][map[0].length-1];
                else if (i == memo.length-1) {
                    if (map[i][j] + memo[i][j + 1] >= 0) memo[i][j] = 0;
                    else memo[i][j] = map[i][j] + memo[i][j + 1];
                }
                else if (j == memo[0].length-1) {
                    if (map[i][j] + memo[i+1][j] >= 0) memo[i][j] = 0;
                    else memo[i][j] = map[i][j] + memo[i+1][j];
                }
                else if (map[i][j] + Math.max(memo[i+1][j], memo[i][j+1]) >= 0) memo[i][j] = 0;
                else memo[i][j] = map[i][j] + Math.max(memo[i+1][j], memo[i][j+1]);
            }
        }
        return -memo[0][0] + 1;
    }

    public static String toString(int[][] memo) {
        String s = "";
        for (int[] tile : memo) {
            for (int aTile : tile) s+= aTile + " ";
            s += "\n";
        }
        return s;
    }
}

