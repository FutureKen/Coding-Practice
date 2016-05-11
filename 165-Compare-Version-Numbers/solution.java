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