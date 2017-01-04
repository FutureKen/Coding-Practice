// Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
//
//
//
// For example,
// S = "ADOBECODEBANC"
// T = "ABC"
//
//
// Minimum window is "BANC".
//
//
//
// Note:
// If there is no such window in S that covers all characters in T, return the empty string "".
//
//
// If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.


public class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[256];
        int count = 0; //Count how many chars in t;
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
            count++;
        }

        int start = 0, end = 0, minStart = 0, minW = Integer.MAX_VALUE;
        while (end < s.length()) {
            
            if (map[s.charAt(end)] > 0) {
                count--; //if this char is in t;
            }
            map[s.charAt(end)]--; //Some chars not in t will become negative;
            end++;
            //when count is 0, means all chars in t have appeared in s, then move start pointer to shrink window.
            while (count == 0) {
                if (minW > end - start) {
                    minStart = start;
                    minW = end - minStart;
                }
                
                map[s.charAt(start)]++;
                if (map[s.charAt(start)] > 0) {
                    count++; //If start pointer passed a char which is also in t, stop shrinking.
                }
                start++;
            }
        }
        return minW == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minW);
    }
}
