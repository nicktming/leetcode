package Solution_900_999;

import java.util.Arrays;

public class Solution_923 {

    public static void main(String[] args) {
        Solution_923 test = new Solution_923();
        int[] A = new int[3000];
        for (int i = 0; i < 3000; i++) {
            A[i] = (int)(Math.random() * 101);
            //if (A[i] > 100) System.out.println("-----bigger than 1000");
            //System.out.format("A[%d] = %d\n", i, A[i]);
        }
        int target = 100;
        long start = System.currentTimeMillis();
        test.threeSumMulti(A, target);
        long end   = System.currentTimeMillis();
        System.out.println("10000 times spent:" + (end - start));
        start = System.currentTimeMillis();
        test.threeSumMulti1(A, target);
        end = System.currentTimeMillis();
        System.out.println("9000000 times spent:" + (end - start));
        test();
    }

    public static void test() {
        int a = 10;
        int b = 15;
        int times = 100000000;
        long start = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        long end = System.currentTimeMillis();
        System.out.println(times + " times spent:" + (end - start));
    }

    // start 11:18
    // finish 11:33
    // spent  15mins

    private static final int SIZE = (int)Math.pow(10, 9) + 7;

    public int threeSumMulti(int[] A, int target) {
        long[] count = new long[101]; // beacuese of count[i] * count[j] * count[k] (sometimes oversize)
        long ans = 0;
        for (int a : A) count[a]++;
        for (int i = 0; i <= 100; i++) {
            for (int j = i; j <= 100; j++) {
                int k = target - i - j;
                if (k > 100 || k < 0) continue;
                if (i == j && j == k) {
                    ans += count[i] * (count[i] - 1) * (count[i] - 2) / 6;
                } else if (i == j && j != k) {
                    ans += count[i] * (count[i] - 1) / 2 * count[k] ;
                } else if (i < j && j < k) {
                    ans += count[i] * count[j] * count[k];
                }
                //ans %= SIZE;
            }
        }
        return (int)(ans%SIZE);
    }



    public int threeSumMulti1(int[] A, int target) {
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
