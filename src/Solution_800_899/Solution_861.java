package Solution_800_899;

public class Solution_861 {

    public static void main(String[] args) {
        Solution_861 test = new Solution_861();
        int[][] A = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        System.out.println(test.matrixScore(A));
    }

    // best solution
    public int matrixScore(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int total = 0;
        for (int j = 0; j < col; j++) {
            int count = 0;
            for (int i = 0; i < row; i++) {
                if (A[i][0] == A[i][j]) count++;
            }
            total += (1 << (col - j - 1)) * Math.max(count, row - count);
        }
        return total;
    }
    // solution 2
    public int matrixScore1(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int total = 0;
        for (int i = 0; i < row; i++) {
            if (A[i][0] == 0) changeRow(A, i, col);
        }
        for (int j = 0; j < col; j++) {
            int count = 0;
            for (int i = 0; i < row; i++) {
                if (A[i][j] == 1) count++;
            }
            total += (1 << (col - j - 1)) * Math.max(count, row - count);
        }
        return total;
    }
    // solution 3
    public int matrixScore2(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        for (int i = 0; i < row; i++) {
            if (A[i][0] == 0) changeRow(A, i, col);
        }
        for (int i = 1; i < col; i++) {
            if (shouldChange(A, i, row)) changeCol(A, i, row);
        }
        int total = 0;
        for (int i = 0; i < row; i++) {
            String str = "";
            for (int j = 0; j < col; j++) {
                str += A[i][j];
            }
            total += Integer.parseInt(str, 2);
        }
        return total;
    }

    public boolean shouldChange(int[][] A, int index, int row) {
        int count = 0;
        for (int i = 0; i < row; i++) {
            if(A[i][index] == 0) count++;
        }
        return count > (row - count);
    }

    public void changeRow(int[][] A, int index, int col) {
        for (int i = 0; i < col; i++) {
            A[index][i] = 1 - A[index][i];
        }
    }

    public void changeCol(int[][] A, int index, int row) {
        for (int i = 0; i < row; i++) {
            A[i][index] = 1 - A[i][index];
        }
    }

}
