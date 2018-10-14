package Solution_900_999;

import java.util.Arrays;

public class Solution_923 {

    public static void main(String[] args) {
        Solution_923 test = new Solution_923();
        int[] A = {1,1,2,2,3,3,4,4,5,5};
        int target = 8;
        System.out.println(test.threeSumMulti(A, target));
    }

    // start 11:18
    // finish 11:33
    // spent  15mins

    private static final int SIZE = (int)Math.pow(10, 9) + 7;

    public int threeSumMulti(int[] A, int target) {
        int len = A.length;
        Arrays.sort(A);
        int ans = 0;
        for (int k = len - 1; k >= 2; k--) {
            int twoSumTarget = target - A[k];
            if (twoSumTarget < 0) continue;
            ans += twoSum(A, 0, k - 1, twoSumTarget);
            ans %= SIZE;
        }
        return ans;
    }

    public int twoSum(int[] A, int i, int j, int target) {
        int count = 0;
        while (i < j) {
            //System.out.println("i=" + i + ",j="+j);
            if (A[i] + A[j] < target) {
                i++;
            } else if (A[i] + A[j] > target) {
                j--;
            } else {
                if (A[i] == A[j]) {
                    count += (j - i + 1) * (j - i) / 2;
                    break;
                } else {
                    int tmpi = i;
                    while (tmpi < j && A[tmpi] == A[i]) tmpi++;
                    int tmpj = j;
                    while (tmpj > i && A[tmpj] == A[j]) tmpj--;
                    count += (tmpi - i) * (j - tmpj);
                    i = tmpi;
                    j = tmpj;
                }
            }
            count %= SIZE;
        }
        return count;
    }

}
