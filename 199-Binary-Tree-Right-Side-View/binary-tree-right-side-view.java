// Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
//
//
// For example:
// Given the following binary tree,
//
//    1            <---
//  /   \
// 2     3         <---
//  \     \
//   5     4       <---
//
//
//
// You should return [1, 3, 4].
//
//
// Credits:Special thanks to @amrsaqr for adding this problem and creating all test cases.


public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        helper(result, root, 0);
        return result;
    }
    private void helper(List<Integer> result, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (result.size() == level) {
            result.add(root.val);
        }
        helper(result, root.right, level + 1);
        helper(result, root.left, level + 1);
    }
}
