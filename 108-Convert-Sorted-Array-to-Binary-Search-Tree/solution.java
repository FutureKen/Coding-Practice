public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int s = nums.length;
        if (s == 0 || nums == null) {
            return null;
        } 
        TreeNode root = helper(0, s - 1, nums);
        return root;
    }
    private TreeNode helper(int start, int end, int[] nums) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(start, mid - 1, nums);
        node.right = helper(mid + 1, end, nums);
        return node;
    }
}