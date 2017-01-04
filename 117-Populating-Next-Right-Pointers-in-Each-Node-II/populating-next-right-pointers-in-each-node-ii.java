// Follow up for problem "Populating Next Right Pointers in Each Node".
// What if the given tree could be any binary tree? Would your previous solution still work?
//
// Note:
// You may only use constant extra space.
//
//
// For example,
// Given the following binary tree,
//
//          1
//        /  \
//       2    3
//      / \    \
//     4   5    7
//
//
//
// After calling your function, the tree should look like:
//
//          1 -> NULL
//        /  \
//       2 -> 3 -> NULL
//      / \    \
//     4-> 5 -> 7 -> NULL


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
        TreeLinkNode nextHead = new TreeLinkNode(0);
        nextHead.next = root;
        while (nextHead.next != null) {
            TreeLinkNode tail = nextHead;
            TreeLinkNode cur = nextHead.next;
            nextHead.next = null;
            while (cur != null) {
                if (cur.left != null) {
                    tail.next = cur.left;
                    tail = tail.next;
                }
                if (cur.right != null) {
                    tail.next = cur.right;
                    tail = tail.next;
                }
                cur = cur.next;
            }
        } 
    }
}
