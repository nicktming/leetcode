package Solution_900_999;

public class Solution_944 {
    public static void main(String[] args) {
        Solution_944 test = new Solution_944();
        String[] A = {"rrjk","furt","guzm"};
        System.out.println(test.minDeletionSize(A));
    }


    // ABCD EFGH IJKL MNOP QRST UVWX YZ
    public int minDeletionSize(String[] A) {
        int lenth = A[0].length();
        int ans = 0;
        for (int i = 0; i < lenth; i++) {
            for (int j = 1; j < A.length; j++) {
                if (A[j].charAt(i) <= A[j - 1].charAt(i)) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
