package Solution_900_999;

public class Solution_942 {
    public static void main(String[] args) {
        Solution_942 test = new Solution_942();
        String S = "IDID";
        int[] ans = test.diStringMatch(S);
        for (int i : ans) {
            System.out.println(i);
        }
    }

    public int[] diStringMatch(String S) {
        int lenth = S.length();
        int[] ans = new int[lenth + 1];
        int lo = 0;
        int hi = lenth;
        for (int i = 0; i < lenth; i++) {
            if (S.charAt(i) == 'I') {
                ans[i] = lo++;
            } else {
                ans[i] = hi--;
            }
        }
        ans[lenth] = lo;
        return ans;
    }
}
