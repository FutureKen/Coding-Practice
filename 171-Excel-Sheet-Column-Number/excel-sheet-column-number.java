// Related to question Excel Sheet Column Title
// Given a column title as appear in an Excel sheet, return its corresponding column number.
//
// For example:
//     A -&gt; 1
//     B -&gt; 2
//     C -&gt; 3
//     ...
//     Z -&gt; 26
//     AA -&gt; 27
//     AB -&gt; 28 
//
// Credits:Special thanks to @ts for adding this problem and creating all test cases.


public class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int temp = s.charAt(i) - 'A' + 1;
            result = result * 26 + temp;
        }
        return result;
    }
}
