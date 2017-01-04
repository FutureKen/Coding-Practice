// Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
//
// Example:
//
// Input: "babad"
//
// Output: "bab"
//
// Note: "aba" is also a valid answer.
//
//
//
// Example:
//
// Input: "cbbd"
//
// Output: "bb"


public class Solution {
    int start, max;
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            findPalindrome(s, i, i); //Odd length
            findPalindrome(s, i, i + 1); //Even length
        }
        return s.substring(start, start + max);
    }
    private void findPalindrome(String s, int l, int r) {
        while (l >= 0 && r <= s.length() - 1 && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        if (max < r - l - 1) {
            max = r - l - 1;
            start = l + 1;
        }
    }
}
