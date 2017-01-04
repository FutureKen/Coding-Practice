// Given a sorted linked list, delete all duplicates such that each element appear only once.
//
//
// For example,
// Given 1->1->2, return 1->2.
// Given 1->1->2->3->3, return 1->2->3.


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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode i = head;
        ListNode j;
        if(i == null || i.next == null){
            return i;
        }
        j = i.next;
        while (j != null){
            if (i.val != j.val){
                i = i.next;
                j = j.next;
            }
            else {
                j = j.next;
                i.next = j;
            }
            
        }
        return head;
    }
}
