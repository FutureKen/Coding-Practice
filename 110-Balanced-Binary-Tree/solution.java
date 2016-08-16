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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = Depth(root.left);
        int right = Depth(root.right);
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right); 
    }
    private int Depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Depth(root.left);
        int right = Depth(root.right);
        return Math.max(left, right) + 1;
    }
}