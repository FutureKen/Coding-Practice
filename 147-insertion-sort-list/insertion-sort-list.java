// Sort a linked list using insertion sort.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = head;
        ListNode temp;
        ListNode current;
        while (tail.next != null){
            current = tail.next;
            temp = dummy;
            while (temp != tail && temp.next.val < current.val){
                temp = temp.next;
            }
            if (temp == tail) {
                tail = current;
            }
            else {
            tail.next = current.next;
            current.next = temp.next; 
            temp.next = current;
            }     
        }
        return dummy.next;
    }
}
