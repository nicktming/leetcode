package Solution_900_999;

public class Solution_921 {

    public static void main(String[] args) {
        String S = "())";
        Solution_921 test = new Solution_921();
        System.out.println(test.minAddToMakeValid(S));
    }

    public int minAddToMakeValid(String S) {
        int ans = 0;
        int count = 0;
        for (char ch : S.toCharArray()) {
            count = ch == '(' ? count + 1 : count - 1;
            if (count < 0) {
                ans -= count;
                count = 0;
            }
        }
        return ans + count;
    }
}
