package Solution_500_599;

import java.util.*;

public class Solution_515 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }


    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }

    public void dfs(TreeNode root, int depth, List<Integer> ans) {
        if (root == null) return;
        if (ans.size() <= depth) ans.add(root.val);
        else ans.set(depth, Math.min(ans.get(depth), root.val));
        dfs(root.left, depth + 1, ans);
        dfs(root.right, depth + 1, ans);
    }
}
