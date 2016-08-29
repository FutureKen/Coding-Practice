public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> level = new LinkedList<>();
        if (root == null) {
            return result;
        }
        level.add(root);
        while (!level.isEmpty()) {
            int size = level.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = level.poll();
                if (i == size - 1) {
                    result.add(node.val);
                }
                if (node.left != null) {
                    level.add(node.left);
                }
                if (node.right != null) {
                    level.add(node.right);
                }
            }
        }
        return result;
    }
}