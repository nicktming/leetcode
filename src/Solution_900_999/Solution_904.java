package Solution_900_999;

import java.util.HashMap;
import java.util.Map;

public class Solution_904 {

    public static void main(String[] args) {
        Solution_904 test = new Solution_904();
        //int[] tree = {3,3,3,1,2,1,1,2,3,3,4};
        int[] tree = {1,2,3,2,2};
        System.out.println(test.totalFruit(tree));
    }

    public int totalFruit(int[] tree) {
        Map<Integer, Integer> map = new HashMap<>();
        int r = 0;
        int ans = 0;
        for (int l = 0; l < tree.length; l++) {
            while (r < tree.length && (map.size() == 2 && map.containsKey(tree[r]) || map.size() <= 1)) {
                map.put(tree[r], map.getOrDefault(tree[r++], 0) + 1);
            }
            ans = Math.max(ans, r - l);
            if (map.containsKey(tree[l])) {
                map.put(tree[l], map.get(tree[l]) - 1);
                if (map.get(tree[l]) == 0) map.remove(tree[l]);
            }
        }
        return ans;
    }
}
