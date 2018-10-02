package Solution_900_999;

import sun.tools.jconsole.MaximizableInternalFrame;

import java.util.PriorityQueue;

public class Solution_915 {


    public static void main(String[] args) {
        Solution_915 test = new Solution_915();
        int[] A = {1,1,1,0,6,12};
        System.out.println(test.partitionDisjoint(A));
    }

    /**
     *  version : 2
     *  time    : 5ms for 56 cases
     *  time    : O(n)
     *  space   : O(n)
     *  Reason  : pre compute for the min value of the rest of array without using a priority queue.
     */
    public int partitionDisjoint(int[] A) {
        int[] preRight = new int[A.length];
        preRight[A.length - 1] = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--) {
            preRight[i] = Math.min(A[i], preRight[i + 1]);
        }
        int i = 0;
        int max = -1;
        for (; i < A.length; i++) {
            if (A[i] > max) max = A[i];
            if (max <= preRight[i + 1]) break;
        }
        return i + 1;
    }

    /**
     *  version : 1
     *  time    : 321ms for 56 cases
     *  time    : O(nlogn)
     *  space   : O(n)

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
     */
}
