// Given a positive integer, return its corresponding column title as appear in an Excel sheet.
//
// For example:
//
//     1 -> A
//     2 -> B
//     3 -> C
//     ...
//     26 -> Z
//     27 -> AA
//     28 -> AB 
//
// Credits:Special thanks to @ifanchu for adding this problem and creating all test cases.


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
