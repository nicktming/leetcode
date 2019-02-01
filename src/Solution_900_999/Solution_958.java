package Solution_900_999;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_958 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x;}
    }

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        boolean flag = false;
        queue.add(root);
        while (!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                if (flag) {
                    if (cur.left != null || cur.right != null) return false;
                } else {
                    if (cur.left == null && cur.right != null) return false;
                    if (cur.left != null && cur.right == null) {
                        // System.out.println("-----");
                        //if (!queue.isEmpty()) return false;
                        flag = true;
                    }
                    if (cur.left == null && cur.right == null) flag = true;
                    if (cur.left != null) next.add(cur.left);
                    if (cur.right != null) next.add(cur.right);
                }
            }
            Queue<TreeNode> tmp = queue;
            queue = next;
            next = tmp;
        }
        return true;
    }
}
