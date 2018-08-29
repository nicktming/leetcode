package Solution_800_899;

public class Solution_877 {

    public static void main(String[] args) {
        Solution_877 test = new Solution_877();
        int[] piles = {5, 3, 4, 5};
        System.out.println(test.stoneGame(piles));
    }

    int[] piles;
    public boolean stoneGame(int[] piles) {
        this.piles = piles;
        int sum = 0;
        for (int pile : piles) sum += pile;
        int[][] dp = new int[piles.length][piles.length];
        int maxiumGet = stone(dp, 0, piles.length - 1);
        return maxiumGet > sum - maxiumGet;
    }

    public int stone(int[][] dp, int i, int j) {
        if (dp[i][j] != 0) return dp[i][j];
        if (j - i == 1) return dp[i][j] = Math.max(piles[i], piles[j]);
        dp[i][j] = Math.max(piles[i] + Math.min(stone(dp, i + 1, j - 1), stone(dp, i + 2, j)),
                piles[j] + Math.min(stone(dp, i, j -2), stone(dp, i + 1, j - 1)));
        return dp[i][j];
    }


}
