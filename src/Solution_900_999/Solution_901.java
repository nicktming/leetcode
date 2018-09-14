package Solution_900_999;

public class Solution_901 {


    public static void main(String[] args) {
        StockSpanner ss = new StockSpanner();
        int[] stocks = {100, 80, 60, 70, 60, 75, 85};
        for (int stock : stocks) {
            System.out.println(ss.next(stock));
        }
    }
    // version 1
    // time : 152ms
    // beats: 61.64%
    static class StockSpanner {

        int[][] A = new int[10000][2];
        int index = 0;

        public StockSpanner() {

        }

        public int next(int price) {
            int i = index - 1;
            A[index][0] = price;
            A[index][1] = 1;
            while (i >= 0 && A[index][0] >= A[i][0]) {
                A[index][1] += A[i][1];
                i -= A[i][1];
            }
            return A[index++][1];
        }
    }
}
