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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        if (root == null) {
            return result;
        }
        st.push(root);
        while (!st.empty()) {
            TreeNode current = st.pop();
            result.add(current.val);
            if (current.right != null) {
                st.push(current.right);
            }
            if (current.left != null) {
                st.push(current.left);
            }
        }
        return result;
    }
}