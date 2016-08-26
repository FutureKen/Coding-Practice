public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null;
        TreeNode cur = root;
        if (root == null) {
            return result;
        }
        stack.push(cur);
        while (!stack.empty()) {
            cur = stack.peek();
            if (prev == null || prev.left == cur || prev.right == cur) {
                if (cur.left != null) {
                    stack.push(cur.left);
                } else if (cur.right != null) {
                    stack.push(cur.right);
                }
            } else if (cur.left == prev) {
                if (cur.right != null) {
                    stack.push(cur.right);
                }
            } else {
                result.add(cur.val);
                stack.pop();
            }
            prev = cur;
        }
        return result;
    }
}