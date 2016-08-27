public class Solution {
    private int countHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return 1 + countHeight(root.left);
    }
    public int countNodes(TreeNode root) {
        int nodes = 0;
        int h = countHeight(root);
        while (root != null) {
            if (countHeight(root.right) == h - 1) {
                nodes += 1 << h;
                root = root.right;
            } else {
                nodes += 1 << h - 1;
                root = root.left;
            }
            h--;
        }
        return nodes;
    }
}