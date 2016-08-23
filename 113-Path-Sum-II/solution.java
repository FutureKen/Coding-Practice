public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        Curpath(root, sum, result, current);
        return result;
    }
    private void Curpath(TreeNode root, Integer sum, List<List<Integer>> result, List<Integer> current) {
        if (root == null) {
            return;
        }
        current.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            result.add(new ArrayList(current));
        } else {
            Curpath(root.left, sum - root.val, result, current);
            Curpath(root.right, sum - root.val, result, current);
        }
        current.remove(current.size() - 1);
    }
}