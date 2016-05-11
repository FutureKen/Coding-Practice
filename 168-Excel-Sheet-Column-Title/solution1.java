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
    public String convertToTitle(int n) {
        String result = "";
        while ( n != 0) {
            n--;
            result = (char)(n % 26 + 'A') + result;;
            n = n / 26;
        }
        return result;   
    }
}