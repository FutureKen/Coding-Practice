// Given a binary tree, return the preorder traversal of its nodes' values.
//
//
// For example:
// Given binary tree {1,#,2,3},
//
//    1
//     \
//      2
//     /
//    3
//
//
//
// return [1,2,3].
//
//
// Note: Recursive solution is trivial, could you do it iteratively?


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
