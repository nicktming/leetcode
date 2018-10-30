package Solution_500_599;

public class Solution_513 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    //int depth = 0;
    //int ans;
    public int findBottomLeftValue(TreeNode root) {
        int[] res = new int[2];
        dfs(root, 1, res);
        return res[1];
    }

    public void dfs(TreeNode root, int curDepth, int[] res) {
        if (root == null) return;
        if (res[0] < curDepth) {
            res[1] = root.val;
            res[0] = curDepth;
        }
        dfs(root.left, curDepth + 1, res);
        dfs(root.right, curDepth + 1, res);
    }



}
