package Solution_800_899;

import java.util.HashMap;
import java.util.Map;

public class Solution_873 {
    public static void main(String[] args) {
        Solution_873 test = new Solution_873();
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(test.lenLongestFibSubseq(A));
    }

    public int lenLongestFibSubseq(int[] A) {
        Map<Integer, Integer> index = new HashMap<>();
        int lenth = A.length;
        int ans = 0;
        for (int i = 0; i < lenth; i++) {
            index.put(A[i], i);
        }
        Map<String, Integer> map = new HashMap<>();
        for (int k = 0; k < lenth; k++) {
            for (int j = 0; j < k; j++) {
                int i = index.getOrDefault(A[k] - A[j], -1);
                if (i >= 0 && i < j) {
                    int cnt = map.getOrDefault(i + ":" + j, 2) + 1;
                    map.put(j + ":" + k, cnt);
                    ans = Math.max(ans, cnt);
                }
            }
        }
        return ans > 2 ? ans : 0;
    }
}
