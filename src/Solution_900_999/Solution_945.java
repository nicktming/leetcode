package Solution_900_999;

import java.util.Arrays;

public class Solution_945 {
    public static void main(String[] args) {
        Solution_945 test = new Solution_945();
        int[] A = {3, 2, 1, 2, 1, 7};
        System.out.println(test.minIncrementForUnique(A));
    }


    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int ans = 0;
        int[] hash = new int[80001];
        for (int t : A) {
            int tmp = t;
            while (hash[tmp] == 1) {
                tmp++;
            }
            hash[tmp] = 1;
            ans += tmp - t;
        }
        return ans;
    }
}
