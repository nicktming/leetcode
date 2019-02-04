package Solution_600_699;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_652 {


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {this.val = val;}
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, List<TreeNode>> map = new HashMap<>();
        List<TreeNode> dups = new ArrayList<>();
        serialize(root, map);
        for (List<TreeNode> group : map.values()) {
            if (group.size() > 1) dups.add(group.get(0));
        }
        return dups;
    }

    private String serialize(TreeNode root, Map<String, List<TreeNode>> map) {
        if (root == null) return "";
        String s = "(" + serialize(root.left, map) + root.val + serialize(root.right, map) + ")";
        if (!map.containsKey(s)) map.put(s, new ArrayList<TreeNode>());
        map.get(s).add(root);
        return s;
    }
}
