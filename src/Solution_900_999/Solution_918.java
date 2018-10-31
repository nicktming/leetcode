package Solution_900_999;

public class Solution_918 {
    public static void main(String[] args) {
        int[] A = {5, -1,5};
        Solution_918 test = new Solution_918();
        System.out.println(test.maxSubarraySumCircular(A));
    }

    /**
     *  总结: 遇到循环情况
     *  1. presum提前计算好
     *
     */

    public int maxSubarraySumCircular(int[] A) {
        int ans = Integer.MIN_VALUE;
        int lenth = A.length;
        int presum = 0;
        for (int i = 0; i < lenth; i++) {
            presum = A[i] + Math.max(0, presum);
            ans = Math.max(ans, presum);
        }

        int[] maxRight = new int[lenth];
        maxRight[lenth - 1] = A[lenth - 1];
        presum = A[lenth - 1];
        int preMax = presum;
        for (int i = lenth - 2; i >= 0; i--) {
            maxRight[i] = Math.max(preMax, presum += A[i]);
            preMax = maxRight[i];
        }
        /*
        for (int n : maxRight) {
            System.out.print(n + " ");
        }
        */
        int leftsum = 0;
        for (int i = 0; i < lenth; i++) {
            ans = Math.max(ans, leftsum + maxRight[i]);
            leftsum += A[i];
        }
        return ans;
    }
}
