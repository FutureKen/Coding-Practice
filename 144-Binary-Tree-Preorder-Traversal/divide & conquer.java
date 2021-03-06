public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (root == null) {
            return result;
        }
        //Divide
        ArrayList<Integer> left = preorderTraversal(root.left);
        ArrayList<Integer> right = preorderTraversal(root.right);

        //Conquer
        result.add(root.val);
        result.addAll(left);
        result.addAll(right);
        return result;
    }
}