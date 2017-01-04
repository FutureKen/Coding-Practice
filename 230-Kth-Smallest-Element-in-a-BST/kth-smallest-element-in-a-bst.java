// Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
//
// Note: 
// You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
//
// Follow up:
// What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
//
//
//   Try to utilize the property of a BST.
//   What if you could modify the BST node's structure?
//   The optimal runtime complexity is O(height of BST).
//
//
// Credits:Special thanks to @ts for adding this problem and creating all test cases.


public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int count = nodeCounter(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k - count - 1);
        }
        return root.val;
    }
    private int nodeCounter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + nodeCounter(root.left) + nodeCounter(root.right);
    }
}
