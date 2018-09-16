package Review;

import java.util.Arrays;

public class Solution_846 {

    public static void main(String[] args) {
        Solution_846 test = new Solution_846();
        //int[] hand = {1,2,3,6,2,3,4,7,8};
        //int W = 3;
        //int[] hand = {1,2,3,4,5,6};
        int[] hand = {2,1};
        int W = 2;
        System.out.println(test.isNStraightHand(hand, W));
    }

    public boolean isNStraightHand(int[] hand, int W) {
        int lenth = hand.length;
        if (lenth % W != 0) return false;
        int H = lenth / W;
        int[][] bucket = new int[W][H];
        int[] index = new int[W];
        for (int h : hand) {
            int row = h % W;
            //System.out.format("row=%d,index[%d]=%d, h=%d\n", row, row, index[row], h);
            if (index[row] == H) return false;
            bucket[row][index[row]++] = h;
        }
        for (int[] b : bucket) Arrays.sort(b);
        for (int j = 0; j < H; j++) {
            for (int i = 1; i < W; i++) {
                int diff = bucket[i][j] - bucket[i - 1][j];
                //System.out.format("i=%d,j=%d,diff=%d\n", i, j, diff);
                if (diff != 1 && diff != 1 - W) return false;
            }
        }
        return true;
    }
}
