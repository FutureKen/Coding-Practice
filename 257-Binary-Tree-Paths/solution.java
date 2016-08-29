public class Solution {
    List<String> result = new ArrayList<String>();
    StringBuilder sb = new StringBuilder();
    public List<String> binaryTreePaths(TreeNode root) {
        helper(root);
        return result;
    }
    private void helper(TreeNode root) {
        if (root == null) { 
            return;
        }
        int len = sb.length();
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            result.add(sb.toString());
        } else {
            sb.append("->");
            helper(root.left);
            helper(root.right);
        }
        sb.setLength(len);
    }
}