public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymLevel(root.left, root.right);
    }
    private boolean isSymLevel(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSymLevel(p.left, q.right) && isSymLevel(p.right, q.left);
    }
}