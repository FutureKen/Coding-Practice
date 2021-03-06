// Compare two version numbers version1 and version2.
// If version1 &gt; version2 return 1, if version1 &lt; version2 return -1, otherwise return 0.
//
// You may assume that the version strings are non-empty and contain only digits and the . character.
// The . character does not represent a decimal point and is used to separate number sequences.
// For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
//
// Here is an example of version numbers ordering:
// 0.1 &lt; 1.1 &lt; 1.2 &lt; 13.37
//
// Credits:Special thanks to @ts for adding this problem and creating all test cases.


public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        for (; i < v1.length && i < v2.length; i++) {
            int val1 = Integer.parseInt(v1[i]);
            int val2 = Integer.parseInt(v2[i]);
            if (val1 > val2) {
                return 1;
            }
            if (val1 < val2) {
                return -1;
            }
        }
        if (v1.length > v2.length) {
            for (; i < v1.length; i++) {
                int val = Integer.parseInt(v1[i]);
                if (val != 0) {
                    return 1;
                }
            }
        } else if (v1.length < v2.length) {
            for (; i < v2.length; i++) {
                int val = Integer.parseInt(v2[i]);
                if (val != 0) {
                    return -1;
                }
            }
        }
        return 0;
    }
}
