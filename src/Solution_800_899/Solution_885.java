package Solution_800_899;

public class Solution_885 {
    public static void main(String[] args) {
        Solution_885 test = new Solution_885();
        int R = 1;
        int C = 4;
        int r0 = 0;
        int c0 = 0;
        int[][] ans = test.spiralMatrixIII(R, C, r0, c0);
        for (int[] item : ans) {
            System.out.println("item:" + item);
        }
    }

    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int lenth = R * C;
        int j = 0;
        int direction = 0;
        int[][] ans = new int[lenth][2];
        ans[j++] = new int[]{r0, c0};
        if (lenth == 1) return ans;
        for (int loop = 1; true; loop += 1) {
            for (int i = 0; i < 2; i++) {
                for (int k = 0; k < loop; k++) {
                    r0 += dir[direction][0];
                    c0 += dir[direction][1];
                    if (r0 >= 0 && r0 < R && c0 >= 0 && c0 < C) {
                        ans[j++] = new int[]{r0, c0};
                        if (j == lenth) return ans;
                    }
                    System.out.format("{r0:%d,c0:%d}\n", r0, c0);
                }
                direction = (direction + 1) % 4;
            }
        }
    }

}
