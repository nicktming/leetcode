package Solution_900_999;

import java.util.PriorityQueue;

public class Solution_915 {


    public static void main(String[] args) {
        Solution_915 test = new Solution_915();
        int[] A = {1,1,1,0,6,12};
        System.out.println(test.partitionDisjoint(A));
    }

    /**
     *  version : 1
     *  time    : 321ms for 56 cases
     *  time    : O(nlogn)
     *  space   : O(n)
     */
    public int partitionDisjoint(int[] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int max = -1;
        for (int a : A) pq.add(a);
        int i = 0;
        for (; i < A.length; i++) {
            if (A[i] > max) max = A[i];
            pq.remove(A[i]);
            if (max <= pq.peek()) break;
        }
        return i + 1;
    }
}
