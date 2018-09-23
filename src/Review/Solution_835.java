package Review;

import java.util.HashMap;
import java.util.Map;

public class Solution_835 {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int largestOverlap(int[][] A, int[][] B) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                int indexA = i * 100 + j;
                for (int m = 0; m < B.length; m++) {
                    for (int n = 0; n < B[0].length; n++) {
                        int indexB = m * 100 + n;
                        if (A[i][j] == B[m][n] && A[i][j] == 1) {
                            int diff = indexA - indexB;
                            map.put(diff, map.getOrDefault(diff, 0) + 1);
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans = Math.max(ans, entry.getValue());
        }
        return ans;
    }
}
