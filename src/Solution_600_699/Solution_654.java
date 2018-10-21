package Solution_600_699;

import javax.swing.tree.TreeNode;

public class Solution_654 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int l, int r) {
        if (l > r) return null;
        if (l == r) return new TreeNode(nums[l]);
        int i = l;
        int max = l;
        for (; i <= r; i++) {
            if (nums[i] > nums[max]) max = i;
        }
        TreeNode root = new TreeNode(nums[max]);
        root.left  = build(nums, l, max - 1);
        root.right = build(nums, max + 1, r);
        return root;
    }
}
