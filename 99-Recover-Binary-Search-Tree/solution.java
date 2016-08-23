public class Solution {
    TreeNode firstNode = null;
    TreeNode secondNode = null;
    TreeNode prevNode = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        //traverse and find two nodes;
        traverse(root);
        //swap nodes;
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        //In order traversal
        traverse(root.left);
        //check if 1st node is found.
        if (firstNode == null && root.val < prevNode.val) {
            firstNode = prevNode;
        }
        if (firstNode != null && root.val < prevNode.val) {
            secondNode = root;
        }
        prevNode = root;
        traverse(root.right);
    }
}