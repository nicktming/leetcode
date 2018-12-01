package Solution_600_699;

import java.util.*;

public class Solution_655 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> printTree(TreeNode root) {
        int depth = depth(root);
        int col = (int)Math.pow(2, depth) - 1;
        for (int i = 0; i < depth; i++) {
            ArrayList<String> row = new ArrayList<>(col);
            for (int j = 0;  j <= col; j++) {row.add("" );}
            ans.add(row);
        }
        dfs(root, 0, col, 0);
        return ans;
    }

    public void dfs(TreeNode root, int l, int r, int depth) {
        if (root == null) return;
        int index = l + (r - l) / 2;
        ans.get(depth).set(index, root.val+"");
        dfs(root.left, l, index - 1, depth + 1);
        dfs(root.right, index + 1, r, depth + 1);
    }


    public int depth(TreeNode root) {
        if (root == null) return 0;
        int l = depth(root.left);
        int r = depth(root.right);
        return Math.max(l, r) + 1;
    }
}
