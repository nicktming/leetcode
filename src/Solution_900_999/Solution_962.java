package Solution_900_999;

import java.util.TreeSet;

public class Solution_962 {

    public static void main(String[] args) {
        Solution_962 test = new Solution_962();
        int[] A = {6,0,8,2,1,5};
        System.out.println(test.maxWidthRamp(A));
    }

    public int maxWidthRamp(int[] A) {
        int ans = 0;
        TreeSet<Node> treeSet = new TreeSet<>();
        for (int i = 0; i < A.length; i++) {
            Node cur = new Node(i, A[i]);
            Node ceil = treeSet.lower(cur);
            if (ceil != null && i - ceil.index > ans) {
                System.out.println("i:" + i + ", ceil.index:" + ceil.index);
                ans = i - ceil.index;
            }
            treeSet.add(cur);
        }
        return ans;
    }

    class Node implements Comparable<Node>{
        int index;
        int val;
        public Node(int index, int val) {
            this.index = index;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            if (o.val == this.val) return this.index - o.index;
            return this.val - o.val;
        }
    }
}
