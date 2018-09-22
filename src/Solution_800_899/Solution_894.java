package Solution_800_899;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_894 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {val = x;}
    }

    Map<Integer, List<TreeNode>> map = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int N) {
        if (map.containsKey(N)) return map.get(N);
        List<TreeNode> ans = new ArrayList<>();
        if (N == 1) ans.add(new TreeNode(0));
        else {
            for (int i = 0; i < N; i ++) {
                int j = N - 1 - i;
                for (TreeNode l : allPossibleFBT(i)) {
                    for (TreeNode r : allPossibleFBT(j)) {
                        TreeNode root = new TreeNode(0);
                        root.left = l;
                        root.right = r;
                        ans.add(root);
                    }
                }
            }
        }
        map.put(N, ans);
        return ans;
    }

}
