package Review;

import java.util.*;

public class Solution_863 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {this.val = val;}
    }

    Map<TreeNode, TreeNode> parent = new HashMap<>();
    List<Integer> ans = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        dfs(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);

        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);

        int distance = 0;
        while (!queue.isEmpty()) {
            if (distance == K) {
                while (!queue.isEmpty()) {
                    ans.add(queue.poll().val);
                }
            }
            distance++;
            Queue<TreeNode> next = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                if (cur.left != null && !visited.contains(cur.left)) {
                    visited.add(cur.left);
                    next.add(cur.left);
                }
                if (cur.right != null && !visited.contains(cur.right)) {
                    visited.add(cur.right);
                    next.add(cur.right);
                }
                TreeNode par = parent.get(cur);
                if (par != null && !visited.contains(par)) {
                    visited.add(par);
                    next.add(par);
                }
            }
            Queue<TreeNode> tmp = next;
            next = queue;
            queue = tmp;
        }
        return ans;
    }

    public void dfs(TreeNode root, TreeNode par) {
        if (root == null) return;
        parent.put(root, par);
        dfs(root.left, root);
        dfs(root.right, root);
    }

}
