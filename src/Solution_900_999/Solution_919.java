package Solution_900_999;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_919 {
    // beats: 95.89%

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        CBTInserter test = new CBTInserter(root);
        test.insert(2);
        test.insert(3);
        test.insert(4);
    }

    static class CBTInserter {

        TreeNode root;
        Queue<TreeNode> next;

        public CBTInserter(TreeNode root) {
            this.root = root;
            next = new LinkedList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Queue<TreeNode> tmp = new LinkedList<>();
                while(!queue.isEmpty()) {
                    TreeNode cur = queue.poll();
                    if (cur.left == null || cur.right == null) next.add(cur);
                    if (cur.left != null) tmp.add(cur.left);
                    if (cur.right != null) tmp.add(cur.right);
                }
                queue = tmp;
            }
        }

        public int insert(int v) {
            TreeNode node = new TreeNode(v);
            TreeNode par = next.peek();
            if (par.left == null) {
                par.left = node;
            } else {
                par.right = node;
                next.poll();
            }
            return par.val;
        }

        public TreeNode get_root() {
            return root;
        }


    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }
}
