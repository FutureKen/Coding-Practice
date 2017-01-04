// Implement regular expression matching with support for '.' and '*'.
//
//
// '.' Matches any single character.
// '*' Matches zero or more of the preceding element.
//
// The matching should cover the entire input string (not partial).
//
// The function prototype should be:
// bool isMatch(const char *s, const char *p)
//
// Some examples:
// isMatch("aa","a") → false
// isMatch("aa","aa") → true
// isMatch("aaa","aa") → false
// isMatch("aa", "a*") → true
// isMatch("aa", ".*") → true
// isMatch("ab", ".*") → true
// isMatch("aab", "c*a*b") → true


public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        if (n == 0) {
            return m == 0;
        }
        boolean[][] match = new boolean[m + 1][n + 1]; 
        match[0][0] = true;
        for (int j = 0; j < n; j++) {
            if (p.charAt(j) == '*' && match[0][j - 1])
            match[0][j + 1] = true;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (p.charAt(j) == '.') {
                    match[i + 1][j + 1] = match[i][j];
                } else if (s.charAt(i) == p.charAt(j)){
                    match[i + 1][j + 1] = match[i][j];
                } 
                if (p.charAt(j) == '*') {
                    if (s.charAt(i) != p.charAt(j - 1) && p.charAt(j - 1) != '.') {
                        match[i + 1][j + 1] = match[i + 1][j - 1];
                    } else {
                        match[i + 1][j + 1] = match[i + 1][j - 1] || match[i][j + 1] || match[i + 1][j];
                    }
                }
            }
        }
        return match[m][n];
    }
}
