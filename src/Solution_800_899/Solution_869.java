package Solution_800_899;

import java.util.Arrays;

public class Solution_869 {
    public static void main(String[] args) {
        Solution_869 test = new Solution_869();
        int N = 1;
        System.out.println(test.reorderedPowerOf2(N));
    }

    public boolean reorderedPowerOf2(int N) {
        int[] origin = count(N);
        for (int i = 0; i < 30; i++) {
            if (Arrays.equals(origin, count(1 << i))) return true;
        }
        return false;
    }

    public int[] count(int N) {
        int[] c = new int[10];
        for (; N > 0; N /= 10) c[N%10]++;
        return c;
    }
}
