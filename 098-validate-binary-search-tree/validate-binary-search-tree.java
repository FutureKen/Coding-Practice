// Given a binary tree, determine if it is a valid binary search tree (BST).
//
//
//
// Assume a BST is defined as follows:
//
// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.
//
//
//
// Example 1:
//
//     2
//    / \
//   1   3
//
// Binary tree [2,1,3], return true.
//
//
// Example 2:
//
//     1
//    / \
//   2   3
//
// Binary tree [1,2,3], return false.


public class Solution {
    public boolean isValidBST(TreeNode root) {
        Integer minval = Integer.MIN_VALUE;
        Integer maxval = Integer.MAX_VALUE;
        return isValid(root, null, null);
    }
    private boolean isValid(TreeNode root, Integer minval, Integer maxval) {
         if (root == null) {
            return true;
         }
         return (minval == null || root.val > minval) && (maxval == null || root.val < maxval) && isValid(root.left, minval, root.val) && isValid(root.right, root.val, maxval);
    }
}
