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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] res = new List[n + 1];
        res[0] = new ArrayList<TreeNode>();
        if (n  == 0) {
            return res[0];
        }
        res[0].add(null);
        for (int i = 1; i <= n; i++) {
            res[i] = new ArrayList<TreeNode>();
            for (int j = 0; j < i; j++) {
                for (TreeNode leftNode : res[j]) {
                    for (TreeNode rightNode : res[i - j - 1]) {
                        TreeNode node = new TreeNode(j + 1);
                        node.left = leftNode;
                        node.right = increaseTree(rightNode, j + 1);
                        res[i].add(node);
                    }
                }
            }
        }
        return res[n];
    }
    /* If offset = 2, make tree from
     2         4
    / \       / \
   1   3 to  3   5 */
    private TreeNode increaseTree (TreeNode n, int offset) {
        if (n == null) {
            return null;
        }
        TreeNode node = new TreeNode(n.val + offset);
        node.left = increaseTree(n.left, offset);
        node.right = increaseTree(n.right, offset);
        return node;
    }
}