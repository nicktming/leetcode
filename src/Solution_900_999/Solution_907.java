package Solution_900_999;

import java.util.Stack;

public class Solution_907 {

    public static void main(String[] args) {
        Solution_907 test = new Solution_907();
        int[] A = {3, 1, 2, 4};
        System.out.println(test.sumSubarrayMins(A));
    }


    /**
     *
     * 总结:
     *     i 可以延续到前面几个比自己小的数
     *
     *
     */
    public int sumSubarrayMins(int[] A) {
        int SIZE = (int)Math.pow(10, 9) + 7;
        Stack<Integer> stack = new Stack();
        int lenth = A.length;
        int[] dp = new int[lenth];
        int ans = 0;
        for (int i = 0; i < lenth; i++) {
            dp[i] = A[i];
            while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
               stack.pop();
            }
            int index = stack.isEmpty() ? -1 : stack.peek();
            dp[i] += A[i] * (i - index - 1) + (stack.isEmpty() ? 0 : dp[stack.peek()]);
            ans += dp[i];
            ans %= SIZE;
            stack.add(i);
        }
        return ans;
    }

}
