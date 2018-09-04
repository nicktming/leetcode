package Solution_800_899;

import java.util.*;

public class Solution_851 {

    public static void main(String[] args) {
        Solution_851 test = new Solution_851();
        int[][] richer = {{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}};
        int[] quiet = {3,2,5,4,6,1,7,0};
        for (int i : test.loudAndRich(richer, quiet)) {
            System.out.println("i : " + i);
        }
    }


    // version 1
    // time : 25ms
    // beats: 43%
    Map<Integer, List<Integer>> map = new HashMap<>();
    int[] ans;
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        for (int[] rich : richer) {
            if (!map.containsKey(rich[1])) map.put(rich[1], new ArrayList<>());
            map.get(rich[1]).add(rich[0]);
        }
        ans = new int[quiet.length];
        Arrays.fill(ans, -1);

        for (int i = 0; i < quiet.length; i++) {
            if (ans[i] != -1) continue;
            ans[i] = getRicher(i, quiet);
        }
        return ans;
    }

    public int getRicher(int index, int[] quiet) {
        //System.out.println("index:" + index);
        if (!map.containsKey(index)) return ans[index] = index;
        if (ans[index] != -1) return ans[index];
        int tmp = quiet[index];
        ans[index] = index;
        for (int i : map.get(index)) {
            int res = getRicher(i, quiet);
            if (quiet[res] < tmp) {
                tmp = quiet[res];
                ans[index] = ans[i];
            }
        }
        return ans[index];
    }
}
