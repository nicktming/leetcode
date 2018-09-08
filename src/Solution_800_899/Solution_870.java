package Solution_800_899;

import java.util.*;

public class Solution_870 {

    public static void main(String[] args) {
        int[] A = {8,12,13,24,32};
        int[] B = {13,25,32,12,7};
        Solution_870 test = new Solution_870();
        int[] ans = test.advantageCount(A, B);
        for (int i : ans) {
            System.out.println("i:" + i);
        }
    }

    // solution from the discussion
    // time: 111ms
    // beats: 26.44%
    public int[] advantageCount(int[] A, int[] B) {

        // the tree map stores <value, count> pairs of array A
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num: A) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // for each value in B, get the A entry with smallest higher key or the smallest key if not exist
        int[] res = new int[A.length];

        for (int i = 0; i < B.length; i++) {
            Map.Entry<Integer, Integer> matchingEntry = map.higherEntry(B[i]);
            if (matchingEntry == null) {
                matchingEntry = map.firstEntry();
            }

            res[i] = matchingEntry.getKey();
            if (matchingEntry.getValue() == 1) {
                map.remove(matchingEntry.getKey());
            } else {
                map.put(matchingEntry.getKey(), matchingEntry.getValue() - 1);
            }
        }

        return res;
    }

    // solution from the discussion
    // time : 102ms
    // beats: 36.50%
    public int[] advantageCount2(int[] A, int[] B) {
        int len = A.length;
        Arrays.sort(A);

        Integer[] bIdxArr = new Integer[len];
        for (int i = 0; i < bIdxArr.length; i++) {
            bIdxArr[i] = i;
        }
        Arrays.sort(bIdxArr, (a,b) ->(B[a] -B[b]));

        int[] ans = new int[len];

        int l = 0, r = len - 1;

        for (int idxA = 0, idxB = 0; idxA < len; idxA++) {
            if (A[idxA] > B[bIdxArr[idxB]]) {
                ans[bIdxArr[l++]] = A[idxA];
                idxB++;
            } else {
                ans[bIdxArr[r--]] = A[idxA];
            }
        }
        return ans;
    }

    // version 1
    // time : 699ms
    // beats: 2.03%
    public int[] advantageCount1(int[] A, int[] B) {
        Arrays.sort(A);
        int len = A.length;
        int[] ans = new int[len];
        Arrays.fill(ans,-1);
        boolean[] visited = new boolean[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (!visited[j] && B[i] < A[j]) {
                    visited[j] = true;
                    ans[i] = A[j];
                    break;
                }
            }
        }
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < len; i++) {
            if (!visited[i]) stack.add(A[i]);
        }
        for(int i = 0; i < len; i++) {
            if (ans[i] == -1) ans[i] = stack.pop();
        }
        return ans;
    }

}
