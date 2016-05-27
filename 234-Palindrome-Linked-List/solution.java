/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode mid = slow.next;
        ListNode prev = null;
        //Find the middle node, at the same time reverse the list from head to mid
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = mid;
            mid = mid.next;
            slow.next = prev;
        }
        //If there are odd number of nodes, the slow node should start from 1 step left of mid node.
        if (fast.next == null) {
            slow = slow.next;
        }
        while (slow != null && mid != null && slow.val == mid.val) {
            slow = slow.next;
            mid = mid.next;
        }
        return mid == null;
    }
}