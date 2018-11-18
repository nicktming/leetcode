package Solution_900_999;

public class Solution_941 {

    public static void main(String[] args) {
        Solution_941 test = new Solution_941();
        int[] A = {9,8,7,6,5,4,3,2,1,0};
        System.out.println(test.validMountainArray(A));
    }

    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3) return false;
        int i = 1;
        for (; i < A.length; i++) {
            if (A[i] < A[i - 1]) break;
            if (A[i] == A[i - 1]) return false;
        }
        if (i == A.length || i == 1) return false;
        for (; i < A.length; i++) {
            if (A[i] >= A[i - 1]) return false;
        }
        return true;
    }
}
