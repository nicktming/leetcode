package Solution_900_999;

public class Solution_926 {
    public static void main(String[] args) {
        Solution_926 test = new Solution_926();
        String S = "00000000000000000000000000000000000000000000000000000000000000000010100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001";
        System.out.println(test.minFlipsMonoIncr(S));
    }

    public int minFlipsMonoIncr(String S) {
        int cntEndWithZero = 0;
        int cntEndWithOne  = 0;

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);

            cntEndWithOne  = Math.min(cntEndWithOne, cntEndWithZero) + '1' - ch;
            cntEndWithZero += ch - '0';
        }

        return Math.min(cntEndWithOne, cntEndWithZero);
    }

    /*
    public int minFlipsMonoIncr(String S) {
        int lenth = S.length();
        int[] rightZeros = new int[lenth];
        int[] leftOnes   = new int[lenth];
        leftOnes[0] = S.charAt(0) - '0';
        rightZeros[lenth - 1] = '1' -  S.charAt(lenth - 1);
        for (int i = 1; i < lenth; i++) {
            leftOnes[i] = leftOnes[i - 1] + (S.charAt(i) - '0');
        }
        for (int i = lenth - 2; i >= 0; i--) {
            rightZeros[i] = rightZeros[i + 1] + ('1' - S.charAt(i));
        }
        int ans = Math.min(leftOnes[lenth - 1], rightZeros[0]);
        for (int i = 0; i < lenth; i++) {
            int tmp = (i < lenth - 1 ? rightZeros[i + 1] : 0) + (i > 0 ? leftOnes[i - 1] : 0) + ('1' - S.charAt(i));
            ans = Math.min(ans, tmp);
        }
        return ans;
    }
    */
}
