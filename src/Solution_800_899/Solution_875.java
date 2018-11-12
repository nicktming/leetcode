package Solution_800_899;

import java.util.Arrays;

public class Solution_875 {
    public int minEatingSpeed(int[] piles, int H) {
        int lenth = piles.length;
        int ans = 0;
        boolean flag = false;
        Arrays.sort(piles);
        int i = 1;
        int j = piles[lenth - 1];
        while (i + 1 < j) {
            int mid = i + (j - i) / 2;
            //System.out.println("mid:" + mid);
            int h = hours(piles, mid);
            if (h <= H) {
                j = mid;
            } else i = mid + 1;
        }
        System.out.println("i:" + i + ", j:" + j);
        return hours(piles, i) <= H ? i : j;
    }

    public int hours(int[] piles, int k) {
        int sum = 0;
        for (int pile : piles) {
            sum += pile % k == 0 ? pile/k : pile/k + 1;
        }
        return sum;
    }
}
