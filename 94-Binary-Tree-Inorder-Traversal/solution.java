public class Solution {
    List<Integer> result = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        helper(root);
        return result;
    }
    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        result.add(root.val);
        helper(root.right);
    }
}