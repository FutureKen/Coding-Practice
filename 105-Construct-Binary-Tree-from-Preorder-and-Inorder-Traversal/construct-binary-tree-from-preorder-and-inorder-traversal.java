// Given preorder and inorder traversal of a tree, construct the binary tree.
//
// Note:
// You may assume that duplicates do not exist in the tree.


public class Solution {
    Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        for (int i = 0; i < len; i++) {
            hash.put(inorder[i], i);
        }
        TreeNode root = Helper(0, len - 1, preorder, 0, len - 1, inorder, hash);
        return root;
    }
    private TreeNode Helper(int preSt, int preEnd, int[] preorder, int inSt, int inEnd, int[] inorder, Map hash) {
        if (inSt > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preSt]);
        int inRoot = (Integer) hash.get(root.val);
        int treeRange = inRoot - inSt;
        root.left = Helper(preSt + 1, preSt + treeRange, preorder, inSt, inRoot - 1, inorder, hash);
        root.right = Helper(preSt + treeRange + 1, preEnd, preorder, inRoot + 1, inEnd, inorder, hash);
        return root;
    }
}
