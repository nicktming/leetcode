package Solution_800_899;

public class Solution_865 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {val = x;}
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return depth(root).ance;
    }

    public Model depth(TreeNode root) {
        if (root == null) return new Model(null, 0);
        Model l = depth(root.left);
        Model r = depth(root.right);

        Model ans = new Model();
        ans.depth = Math.max(l.depth, r.depth) + 1;

        if (l.depth == r.depth) {
            ans.ance = root;
        } else if(l.depth > r.depth) {
            ans.ance = l.ance;
        } else {
            ans.ance = r.ance;
        }
        return ans;
    }


    class Model {
        TreeNode ance;
        int depth;
        public Model(TreeNode ance, int depth) {
            this.ance = ance;
            this.depth = depth;
        }
        public Model() {}
    }
}
