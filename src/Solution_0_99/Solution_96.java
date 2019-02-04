package Solution_0_99;

import java.util.HashMap;
import java.util.Map;

public class Solution_96 {

    public static void main(String[] args) {
        Solution_96 test = new Solution_96();
        int n = 3;
        System.out.println(test.numTrees(3));
    }

    Map<Integer, Integer> map = new HashMap<>();
    public int numTrees(int n) {
        if (n <= 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (map.containsKey(n)) return map.get(n);
        int total = 0;
        for (int l = 0; l < n; l++) {
            total += numTrees(l) * numTrees(n - l - 1);
        }
        map.put(n, total);
        return total;
    }
}
