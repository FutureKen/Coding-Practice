/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> level = new LinkedList<>();
        if (root == null) {
            return;
        }
        level.offer(root);
        while (!level.isEmpty()) {
            int size = level.size();
            for (int i = 0; i < size; i++) {
                TreeLinkNode node = level.poll();
                if (node.left != null) {
                    level.offer(node.left);
                }
                if (node.right != null) {
                    level.offer(node.right);
                }
                if (i == size - 1) {
                    continue;
                }
                TreeLinkNode nextNode = level.peek();
                node.next = nextNode;
                
            }
        }
    }
}