/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode head2 = dummy;
        for (int i = 0; i < n; i++) {
        	head = head.next;
        }
        while( head != null) {
        	head = head.next;
        	head2 = head2.next;
        }
        head2.next = head2.next.next;
        return dummy.next;
    }
}