package Solution_900_999;

import java.util.Stack;

public class Solution_901 {


    public static void main(String[] args) {
        StockSpanner ss = new StockSpanner();
        int[] stocks = {100, 80, 60, 70, 60, 75, 85, 101};
        for (int stock : stocks) {
            System.out.println(ss.next(stock));
        }
    }

    static class StockSpanner {
        Stack<int[]> stack = new Stack<int[]>();
        public StockSpanner() {
        }

        public int next(int price) {
            int res = 1;
            while (!stack.isEmpty() && price >= stack.peek()[0]) {
                res += stack.pop()[1];
            }
            stack.push(new int[]{price, res});
            return res;
        }
    }

    /*
    version 2
    Stack
    static class StockSpanner {

        Stack<int[]> stack = new Stack<int[]>();
        int index;

        public StockSpanner() {

        }

        public int next(int price) {
            while (!stack.isEmpty() && price >= stack.peek()[0]) {
                stack.pop();
            }
            int lastIndex = stack.isEmpty() ? -1 : stack.peek()[1];
            stack.push(new int[]{price, index});
            //System.out.format("index=%d,lastIndex=%d\n", index, lastIndex);
            return (index++) - lastIndex;
        }
    }
    */

    // version 1
    // time : 152ms
    // beats: 61.64%
    /*
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
    */
}
