package Review;

public class Solution_901 {

    public static void main(String[] args) {
        StockSpanner ss = new StockSpanner();
        int[] test = {100, 80, 60, 70, 60, 75, 85};
        for (int t : test) {
            System.out.println(ss.next(t));
            //ss.printStack();
        }
    }

    static class StockSpanner {

        int[][] stack;
        int index;
        int count;

        public StockSpanner() {
            this.stack = new int[10000][2];
            this.index = -1;
            this.count = -1;
        }

        public int next(int price) {
            while (this.index >= 0 && this.stack[index][0] <= price) {
                this.index--;
            }
            int before = this.index == -1 ? 0 : this.stack[this.index][1] + 1;
            this.stack[++this.index][0] = price;
            this.stack[this.index][1] = ++count;
            return count - before + 1;
        }
/*
        public void printStack() {
            System.out.println("======================");
            for (int i = 0; i <= index; i++) {
                System.out.format("stack[%d]={%d,%d}\n", i, stack[i][0], stack[i][1]);
            }
            System.out.println("======================");
        }
        */
    }
}
