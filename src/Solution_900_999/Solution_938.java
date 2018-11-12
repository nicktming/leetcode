package Solution_900_999;

public class Solution_938 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        int val = root.val;
        if (val < L) return rangeSumBST(root.right, L, R);
        if (val > R) return rangeSumBST(root.left, L, R);
        return val + rangeSumBST(root.right, val, R) + rangeSumBST(root.left, L, val);
    }
}
