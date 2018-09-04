package Solution_800_899;

public class Solution_835 {

    public static void main(String[] args) {
        Solution_835 test = new Solution_835();
        //int[][] A = {{1,1,0},{0,1,0},{0,1,0}};
        //int[][] B = {{0,0,0},{0,1,1},{0,0,1}};
        int[][] A = {{0,0,0,0,0},{0,1,0,0,0},{0,0,1,0,0},{0,0,0,0,1},{0,1,0,0,1}};
        int[][] B = {{1,0,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{0,1,1,1,1},{1,0,1,1,1}};
        System.out.println(test.largestOverlap(A, B));
    }

    int[][] A;
    int[][] B;
    int row;
    int col;
    public int largestOverlap(int[][] A, int[][] B) {
        this.A = A;
        this.B = B;
        this.row = A.length;
        this.col = A[0].length;
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (ans < countNum(i, j)) {
                    ans = countNum(i, j);
                    System.out.println("i=" + i + ",j=" + j);
                }
            }
        }
        return ans;
    }

    public int countNum(int r, int c) {
        int cnt1 = 0;
        for (int i = r; i < row; i++) {
            for (int j = c; j < col; j++) {
                if (B[i][j] == A[i - r][j - c] && B[i][j] == 1) cnt1++;
            }
        }
        int cnt2 = 0;
        for (int i = r; i < row; i++) {
            for (int j = c; j < col; j++) {
                if (A[i][j] == B[i - r][j - c] && A[i][j] == 1) cnt2++;
            }
        }
        return Math.max(cnt1, cnt2);
    }

}
