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
    public int maxDepth(TreeNode root) {
        if (root == null)
		return 0;
	
	Deque<TreeNode> stack = new LinkedList<TreeNode>();
	
	stack.push(root);
	int count = 0;
	
	while (!stack.isEmpty()) {
		int size = stack.size();
		while (size > 0) {
			TreeNode cur = stack.pop();
			if (cur.left != null)
				stack.addLast(cur.left);
			if (cur.right != null)
				stack.addLast(cur.right);
			size--;
		}
		count++;

	}
	return count;

    }
}