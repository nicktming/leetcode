package Solution_800_899;

public class Solution_807 {

    public static void main(String[] args) {
        int[][] grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        Solution_807 test = new Solution_807();
        System.out.println(test.maxIncreaseKeepingSkyline(grid));
    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] rows = new int[row];
        int[] cols = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                rows[i] = Math.max(rows[i], grid[i][j]);
                cols[j] = Math.max(cols[j], grid[i][j]);
            }
        }
        /*
        for (int j = 0; j < col; j++) {
            for (int i = 0; i < row; i++) {
                cols[j] = Math.max(cols[j], grid[i][j]);
            }
        }
        */
        int sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sum += Math.min(rows[i], cols[j]) - grid[i][j];
            }
        }
        return sum;
    }
}
