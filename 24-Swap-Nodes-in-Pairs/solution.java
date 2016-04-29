/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //Make first node as dummy head;
        head = dummy;
        while (head.next != null && head.next.next != null) {
        	//head->n1->n2->n3 to head->n2->n1->n3
        	ListNode n1 = head.next;
        	ListNode n2 = head.next.next;
        	//head->n2
        	head.next = n2;
        	//n1->n3
        	n1.next = n2.next;
        	//n2->n1
        	n2.next = n1;

        	//Move to next pair
        	head = n1;
        }
        return dummy.next;
    }
}
