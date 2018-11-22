package Solution_800_899;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_889 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(new TreeNode(pre[0]));
        int lenth = pre.length;
        for (int i = 1, j = 0; i < lenth; i++) {
            TreeNode cur = new TreeNode(pre[i]);
            while (deque.getLast().val == post[j]) {
                deque.pollLast(); j++;
            }
            if (deque.getLast().left == null) {
                deque.getLast().left = cur;
            } else {
                deque.getLast().right = cur;
            }
            deque.addLast(cur);
        }
        return deque.getFirst();
    }
}
