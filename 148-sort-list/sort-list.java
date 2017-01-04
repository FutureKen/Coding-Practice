// Sort a linked list in O(n log n) time using constant space complexity.


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    private ListNode findmid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode merge(ListNode first, ListNode second){
        ListNode temp = new ListNode(0);
        ListNode tail = temp;
        while (first != null && second != null){
            if (first.val <  second.val){
                tail.next = first;
                first = first.next;
            }
            else {
                tail.next = second;
                second = second.next;
            }
            tail = tail.next;
        }
        if (first != null){
            tail.next = first;
        }
        else {
            tail.next = second;
        }
        return temp.next;
    }
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode mid = findmid(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        return merge(left, right);
    }
}
