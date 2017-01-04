// Given inorder and postorder traversal of a tree, construct the binary tree.
//
// Note:
// You may assume that duplicates do not exist in the tree.


public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            hash.put(inorder[i], i);
        }
        TreeNode root = Helper(0, inorder.length - 1, inorder, inorder.length - 1, 0, postorder, hash);
        return root;
    }
    private TreeNode Helper(int inSt, int inEnd, int[] inorder, int poSt, int poEnd, int[] postorder, Map hash) {
        if (inSt > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[poSt]);
        int inRoot = (Integer) hash.get(root.val);
        int treeRange = inRoot - inSt;
        root.left = Helper(inSt, inRoot - 1, inorder, poEnd + treeRange - 1, poEnd, postorder, hash);
        root.right = Helper(inRoot + 1, inEnd, inorder,  poSt - 1, poEnd + treeRange, postorder, hash);
        return root;
    }
}
