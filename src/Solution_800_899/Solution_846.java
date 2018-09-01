package Solution_800_899;

import java.util.Arrays;
import java.util.TreeMap;

public class Solution_846 {
    public static void main(String[] args) {
        //int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int[] hand = {1, 1, 2, 2, 3, 3};
        int W = 3;
        Solution_846 test = new Solution_846();
        System.out.println(test.isNStraightHand(hand, W));
    }

    // best solution from disscussion
    // time: 13ms
    // beats: 98.97%
    public boolean isNStraightHand(int[] hand, int W) {
        int len = hand.length;
        if (len % W != 0) return false;
        int numOfBuckets = len/W;
        int[][] buckets = new int[W][numOfBuckets];
        int[] bucketIndex = new int[W];
        for (int h : hand) {
            int index = h % W;
            int col = bucketIndex[index]++;
            if (col >= numOfBuckets) return false;
            buckets[index][col] = h;
        }
        for (int[] bucket : buckets) Arrays.sort(bucket);
        for (int j = 0; j < numOfBuckets; j++) {
            for (int i = 1; i < W; i++) {
                if (buckets[i][j] - buckets[i - 1][j] != 1 && buckets[i - 1][j] - buckets[i][j] != W - 1) return false;
            }
        }
        return true;
    }

    // version2
    // time: 63ms -> 65cases
    // beats: 51.15%
    public boolean isNStraightHand2(int[] hand, int W) {
        int len = hand.length;
        if (len % W != 0) return false;
        TreeMap<Integer, Integer> stm = new TreeMap<>();
        for (int h : hand) {
            stm.put(h, stm.getOrDefault(h, 0) + 1);
        }
        while (stm.size() > 0) {
            int start = stm.firstKey();
            int delcnt = stm.get(start);
            for (int j = 0; j < W; j++) {
                int cur = start + j;
                if (!stm.containsKey(cur) || stm.get(cur) < delcnt) return false;
                int newcnt = stm.get(cur) - delcnt;
                if (newcnt == 0) stm.remove(cur);
                else stm.put(cur, newcnt);
            }
        }
        return true;
    }

    // version1
    // time: 82ms -> 65cases
    // beats: 19.43%
    public boolean isNStraightHand1(int[] hand, int W) {
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
