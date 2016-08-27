public class Solution {

    class TreeNodeWithCount {
        int val;
        int count;
        TreeNodeWithCount left;
        TreeNodeWithCount right;
        TreeNodeWithCount(int x) {val = x; count = 1;};
    }
    public int kthSmallest(TreeNode root, int k) {
        TreeNodeWithCount rootWithCount = buildTreeWithCount(root);
        return kthSmHelper(rootWithCount, k);
    }
    private int kthSmHelper(TreeNodeWithCount rootWithCount, int k) {
        if (k <= 0 || k > rootWithCount.count) return -1;
        if (rootWithCount.left != null) {
            if (rootWithCount.left.count >= k) return kthSmHelper(rootWithCount.left, k);
            if (rootWithCount.left.count == k - 1) return rootWithCount.val;
            return kthSmHelper(rootWithCount.right, k - 1 - rootWithCount.left.count);
        } else {
            if (k == 1) return rootWithCount.val;
            return kthSmHelper(rootWithCount.right, k - 1);
        }
    }

    private TreeNodeWithCount buildTreeWithCount (TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNodeWithCount rootWithCount = new TreeNodeWithCount(root.val);
        rootWithCount.left = buildTreeWithCount(root.left);
        rootWithCount.right = buildTreeWithCount(root.right);
        if (rootWithCount.left != null) {
            rootWithCount.count += rootWithCount.left.count;
        }
        if (rootWithCount.right != null) {
            rootWithCount.count += rootWithCount.right.count;
        }
        return rootWithCount;
    }
    
}