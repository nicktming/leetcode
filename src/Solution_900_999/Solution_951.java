package Solution_900_999;

public class Solution_951 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val) {this.val = val;}
    }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) return false;
        if (root1.val != root2.val) return false;
        return (flipEquiv(root1.left, root2.right) || flipEquiv(root1.left, root2.left)) && (flipEquiv(root1.right, root2.left) || flipEquiv(root1.right, root2.right));
    }
}
