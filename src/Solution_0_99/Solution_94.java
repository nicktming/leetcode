package Solution_0_99;

import java.util.ArrayList;
import java.util.List;

public class Solution_94 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    public void dfs(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        dfs(root.left, ans);
        ans.add(root.val);
        dfs(root.right, ans);
    }
}
