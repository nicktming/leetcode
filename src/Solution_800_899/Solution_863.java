package Solution_800_899;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_863 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }


    // dfs
    Map<TreeNode, Integer> dist = new HashMap<>();
    List<Integer> ans = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        find(root, target);
        dfs(root, dist.get(root), K);
        return ans;
    }

    public int find(TreeNode root, TreeNode target) {
        if (root == null) return -1;
        if (root == target) {
            dist.put(root, 0);
            return 0;
        }
        int l = find(root.left, target);
        if (l >= 0) {
            dist.put(root, l + 1);
            return l + 1;
        }
        int r = find(root.right, target);
        if (r >= 0) {
            dist.put(root, r + 1);
            return r + 1;
        }
        return -1;
    }

    public void dfs (TreeNode root, int len, int K) {
        if (root == null) return;
        if (dist.containsKey(root)) len = dist.get(root);
        if (len == K) ans.add(root.val);
        dfs(root.left, len + 1, K);
        dfs(root.right, len + 1, K);
    }

}
