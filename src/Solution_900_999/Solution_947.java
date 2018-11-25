package Solution_900_999;

import java.util.*;

public class Solution_947 {
    public static void main(String[] args) {
        Solution_947 test = new Solution_947();
        //int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        //int[][] stones = {{0,0}, {0,2}, {1,1}, {2, 0}, {2, 2}};
        int[][] stones = {{5,9},{9,0},{0,0},{7,0},{4,3},{8,5},{5,8},{1,1},{0,6},{7,5},{1,6},{1,9},{9,4},{2,8},{1,3},{4,2},{2,5},{4,1},{0,2},{6,5}};
        System.out.println(test.removeStones(stones));
    }

    Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
    public int removeStones(int[][] stones) {
        int lenth = stones.length;
        for (int i = 0; i < lenth; i++) {
            map.put(i, new HashSet<>());
            for (int j = 0; j < lenth; j++) {
                if (i != j) {
                    if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                        map.get(i).add(j);
                    }
                }
            }
        }
        int ans = 0;
        int index = getMin();

        while (index != -1) {
            for (int k : map.get(index)) {
                map.get(k).remove(index);
            }
            ans++;
            map.remove(index);
            index = getMin();
        }
        return ans;
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int key : map.keySet()) {
            int cnt = map.get(key).size();
            if (cnt > 0 && cnt < min) {
                min = cnt;
                index = key;
            }
        }
        return index;
    }
}
