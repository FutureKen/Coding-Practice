public class Solution {
    private int countHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return 1 + countHeight(root.left);
    }
    public int countNodes(TreeNode root) {
        int h = countHeight(root);
        if (h < 0) {
            return 0;
        } else {
            if (countHeight(root.right) == h - 1) {
                return (1 << h) + countNodes(root.right);
            } else {
                return (1 << h - 1) + countNodes(root.left);
            }
        }
    }
}