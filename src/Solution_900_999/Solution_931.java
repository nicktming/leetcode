package Solution_900_999;

public class Solution_931 {

    public static void main(String[] args) {
        int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
        Solution_931 test = new Solution_931();
        System.out.println(test.minFallingPathSum(A));
    }

    public int minFallingPathSum(int[][] A) {
        int lenth = A.length;
        int[][] dp = new int[2][lenth];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < lenth; i++) {
            for (int j = 0; j < lenth; j++) {
                if (i == 0) dp[i%2][j] = A[i][j];
                else {
                    dp[i%2][j] = dp[(i - 1)%2][j];
                    if (j > 0) dp[i%2][j] = Math.min(dp[i%2][j], dp[(i-1)%2][j-1]);
                    if (j < lenth - 1) dp[i%2][j] = Math.min(dp[i%2][j], dp[(i-1)%2][j+1]);
                    dp[i%2][j] += A[i][j];
                }
                if (i == lenth - 1) ans = Math.min(ans, dp[i%2][j]);
            }
        }
        return ans;
    }
}
