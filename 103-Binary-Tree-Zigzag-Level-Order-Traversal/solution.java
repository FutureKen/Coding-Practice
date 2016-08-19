public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int currentlv = 0;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            Integer size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (currentlv % 2 == 0) {
                    level.add(node.val);
                } else {
                    level.add(0, node.val);
                }
            }
            currentlv++;
            result.add(level);
        }
        return result;
    }
}