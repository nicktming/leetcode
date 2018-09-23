package Review;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution_870 {
    public int[] advantageCount(int[] A, int[] B) {
        int len = A.length;
        int[] res = new int[len];
        Arrays.sort(A);

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < len; i++) pq.add(new int[]{B[i], i});

        int lo = 0;
        int hi = len - 1;

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int idx = node[1];
            int val = node[0];
            if (A[hi] > val) res[idx] = A[hi--];
            else res[idx] = A[lo++];
        }

        return res;
    }
}
