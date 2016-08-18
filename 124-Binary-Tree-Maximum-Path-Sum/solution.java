/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int maxval = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxPath(root);
        return maxval;
    }
    private int maxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, maxPath(root.left));
        int right = Math.max(0, maxPath(root.right));
        maxval = Math.max(maxval, left + right + root.val);
        return Math.max(left, right) + root.val; 
    }
}