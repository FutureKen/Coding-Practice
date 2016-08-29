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
    public int sumNumbers(TreeNode root) {
        int sum = sumAdder(root, 0);
        return sum;
    }
    private int sumAdder(TreeNode root, int s) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return s*10 + root.val;
        }
        return sumAdder(root.left, s*10 + root.val) + sumAdder(root.right, s*10 + root.val);
    }
}