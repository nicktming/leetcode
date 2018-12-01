package Solution_100_199;

import java.util.ArrayList;
import java.util.List;

public class Solution_144 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}

    }

    List<Integer> ans = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            ans.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }

        return ans;

    }
}
