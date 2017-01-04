// Given a string, find the length of the longest substring without repeating characters.
//
// Examples:
//
// Given "abcabcbb", the answer is "abc", which the length is 3.
//
// Given "bbbbb", the answer is "b", with the length of 1.
//
// Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int asc[] = new int[256];
        Arrays.fill(asc, 1);
        int max = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            while (asc[ch] != 1 && j < i) {
                char temp = s.charAt(j);
                asc[temp] = 1;
                j++;
            }
            asc[ch] = 0;
            max = Math.max(max, i - j + 1);
        }
        return max;       
    }
}
