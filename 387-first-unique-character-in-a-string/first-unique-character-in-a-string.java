// Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
//
// Examples:
//
// s = "leetcode"
// return 0.
//
// s = "loveleetcode",
// return 2.
//
//
//
//
// Note: You may assume the string contain only lowercase letters.


public class Solution {
    public int firstUniqChar(String s) {
        int[] rpt = new int[26]; // A map to store appearing times of each char.
        for (int i = 0; i < s.length(); i++) {
            rpt[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (rpt[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
