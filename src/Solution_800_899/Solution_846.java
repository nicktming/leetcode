package Solution_800_899;

import java.util.TreeMap;

public class Solution_846 {
    public static void main(String[] args) {
        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int W = 3;
        Solution_846 test = new Solution_846();
        System.out.println(test.isNStraightHand(hand, W));
    }

    public boolean isNStraightHand(int[] hand, int W) {
        int len = hand.length;
        if (len % W != 0) return false;
        TreeMap<Integer, Integer> stm = new TreeMap<>();
        for (int h : hand) {
            stm.put(h, stm.getOrDefault(h, 0) + 1);
        }
        for (int i = 0; i < len/W; i++) {
            int start = stm.firstKey();
            for (int j = 0; j < W; j++) {
                int cur = start + j;
                if (!stm.containsKey(cur)) return false;
                int cnt = stm.get(cur);
                if (cnt == 1) stm.remove(cur);
                else stm.put(cur, cnt - 1);
            }
        }
        return true;
    }
}
