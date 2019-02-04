package Solution_900_999;

import java.util.ArrayList;
import java.util.List;

public class Solution_988 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {this.val = val;}
    }

    String ans = "";
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, ans);
        return ans;
    }

    public void dfs(TreeNode root, String str) {
        if (root == null) return;
        str = (char)(root.val + 'a') + str;
        if (root.left == null && root.right == null) {
            if (ans.equals("")) ans = str;
            else if (ans.compareTo(str) < 0) ans = str;
        }
        dfs(root.left, str);
        dfs(root.right, str);
    }

    public int compare(String str1, String str2) {
        int lim = Math.min(str1.length(), str2.length());
        int k = 0;
        while (k < lim) {
            if (str1.charAt(k) != str2.charAt(k)) {
                return str1.charAt(k) - str2.charAt(k);
            }
            k++;
        }
        return str1.length() - str2.length();
    }


}
