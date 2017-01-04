// Given a complete binary tree, count the number of nodes.
//
// Definition of a complete binary tree from Wikipedia:
// In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.


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
