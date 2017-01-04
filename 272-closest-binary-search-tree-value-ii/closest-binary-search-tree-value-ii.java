// Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
//
// Note:
//
// Given target value is a floating point.
// You may assume k is always valid, that is: k &le; total nodes.
// You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
//
// Follow up:
// Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
//
//
//   Consider implement these two helper functions:
// getPredecessor(N), which returns the next smaller node to N.
// getSuccessor(N), which returns the next larger node to N.
//
//   Try to assume that each node has a parent pointer, it makes the problem much easier.
//   Without parent pointer we just need to keep track of the path from the root to the current node using a stack.
//   You would need two stacks to track the path in finding predecessor and successor node separately.


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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> pred = new Stack<>();
        Stack<TreeNode> succ = new Stack<>();
        initPredStack(pred, root, target);
        initSuccStack(succ, root, target);
        if (!pred.isEmpty() && !succ.isEmpty() && pred.peek().val == succ.peek().val) {
            getNextPred(pred);
        }

        while (k-- > 0) {
             if (succ.isEmpty()) {
                res.add(getNextPred(pred));
             } else if (pred.isEmpty()) {
                res.add(getNextSucc(succ));
             } else {
                double pDiff = Math.abs((double)pred.peek().val - target);
                double sDiff = Math.abs((double)succ.peek().val - target);
                if (sDiff < pDiff) {
                    res.add(getNextSucc(succ));
                } else {
                    res.add(getNextPred(pred));
                }
             }
        }
        return res;  
    }

    private void initPredStack(Stack<TreeNode> pred, TreeNode node, double target) {
        while (node != null) {
            if (node.val == target) {
                pred.push(node);
                break;
            } else if (node.val < target) {
                pred.push(node);
                node = node.right;
            } else {
                node = node.left;
            }
        }
    } 

    private void initSuccStack(Stack<TreeNode> succ, TreeNode node, double target) {
        while (node != null) {
            if (node.val == target) {
                succ.push(node);
                break;
            } else if (node.val > target) {
                succ.push(node);
                node = node.left;
            } else {
                node = node.right;
            }
        }
    } 

    private int getNextPred(Stack<TreeNode> pred) {
        TreeNode cur = pred.pop();
        int ret = cur.val;
        cur = cur.left;
        while (cur != null) {
            pred.push(cur);
            cur = cur.right;
        }
        return ret;
    }

    private int getNextSucc(Stack<TreeNode> succ) {
        TreeNode cur = succ.pop();
        int ret = cur.val;
        cur = cur.right;
        while (cur != null) {
            succ.push(cur);
            cur = cur.left;
        }
        return ret;
    }
}



