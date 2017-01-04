// Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
//
//
// You should preserve the original relative order of the nodes in each of the two partitions.
//
//
// For example,
// Given 1->4->3->2->5->2 and x = 3,
// return 1->2->2->4->3->5.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
    	if (head == null) {
            return null;
        }
        ListNode left = new ListNode(0);
        ListNode leftdummy = left;
        ListNode right = new ListNode(0);
        ListNode rightdummy = right;
        while (head != null) {
        	if (head.val < x) {
        		left = left.next = head;
        	} else {
        		right = right.next = head;
        	}
        	head = head.next;
        }
        right.next = null;
        left.next = rightdummy.next;
        return leftdummy.next;
    }
}
