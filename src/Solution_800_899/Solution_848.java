package Solution_800_899;

public class Solution_848 {

    public static void main(String[] args) {
        Solution_848 test = new Solution_848();
        String S = "abc";
        int[] shifts = {3,5,9};
        System.out.println(test.shiftingLetters(S, shifts));
    }

    public String shiftingLetters(String S, int[] shifts) {
        int len = shifts.length;
        int[] presum = new int[len];
        presum[len - 1] = shifts[len - 1] % 26;
        for (int i = len - 2; i >= 0; i--) {
            presum[i] = presum[i + 1] + shifts[i];
            presum[i] %= 26;
        }
        char[] chs = S.toCharArray();
        for (int i = 0; i < len; i++) {
            int tmp = chs[i] + presum[i];
            tmp = tmp > 'z' ? 'a' + tmp - 'z' - 1 : tmp;
            chs[i] = (char)tmp;
        }
        return new String(chs);
    }
}
