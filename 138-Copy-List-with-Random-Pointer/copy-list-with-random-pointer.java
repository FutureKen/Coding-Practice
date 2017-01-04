// A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
//
//
//
// Return a deep copy of the list.


/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        //Copy list from 1->2->3 to 1->1'->2->2'->3->3'
        RandomListNode dummyhead = head;
        while (dummyhead != null) {
            RandomListNode copy = new RandomListNode(dummyhead.label);
            copy.next = dummyhead.next;
            dummyhead.next = copy;
            dummyhead = dummyhead.next.next;
        }
        //Copy Random pointer of copied list
        dummyhead = head;
        while (dummyhead != null) {
            if (dummyhead.random != null) {
                dummyhead.next.random = dummyhead.random.next;
            }
            dummyhead = dummyhead.next.next;
        }
        //Separte copied list with original list
        RandomListNode newhead = head.next;
        RandomListNode temp = head;
        
        while (temp != null) {
            dummyhead = temp.next;
            temp.next = dummyhead.next;
            temp = temp.next;
            if (dummyhead.next != null) {
                dummyhead.next = dummyhead.next.next;
            }
        }
        return newhead;
    }
}
