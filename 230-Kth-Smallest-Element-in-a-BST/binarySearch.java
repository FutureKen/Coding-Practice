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