package Solution_300_399;

public class Solution_337 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    public int rob(TreeNode root) {
        return dfs(root, true);
    }

    public int dfs(TreeNode root, boolean choosen) {
        if (root == null) return 0;
        if (!choosen) {
            return dfs(root.right, true) + dfs(root.left, true);
        }
        int choose = root.val + dfs(root.left, false) + dfs(root.right, false);
        int unchoose = dfs(root.left, true) + dfs(root.right, true);
        return Math.max(choose, unchoose);
    }
}
