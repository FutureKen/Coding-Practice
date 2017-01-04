// Given a list, rotate the list to the right by k places, where k is non-negative.
//
// For example:
// Given 1->2->3->4->5->NULL and k = 2,
// return 4->5->1->2->3->NULL.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        int size = 1;

        //Find the size of list
        while (fast.next != null) {
            size++;
            fast = fast.next;
        }
        //Find the rotation point
        for (int i = size - k % size; i > 1; i--) {
            slow = slow.next;
        }
        //Rotate list
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}
