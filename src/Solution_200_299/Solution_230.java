package Solution_200_299;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_230 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {this.val = val;}
    }

    List<Integer> order = new ArrayList<>();
    Map<TreeNode, Integer> map = new HashMap<>();

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        int count = count(root.left);
        if (count == k - 1) return root.val;
        else if (count > k - 1) {
            return kthSmallest(root.left, k);
        } else {
            return kthSmallest(root.right, k - count - 1);
        }
    }


    public int count(TreeNode root) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int l = count(root.left);
        int r = count(root.right);
        int count = 1 + l + r;
        map.put(root, count);
        return count;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        order.add(root.val);
        dfs(root.right);
    }
}
