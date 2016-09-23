public class Solution {
    public int hIndex(int[] citations) {
        if (citations.length < 1) {
            return 0;
        }
        int len = citations.length;
        int[] counter = new int[len + 1];
        for (int i : citations) {
            if (i >= len) {
                counter[len]++;
            } else {
                counter[i]++;
            }
        }
        int res = 0;
        for (int j = len; j >= 0; j--) {
            res += counter[j];
            if (res >= j) {
                return j;
            }
        }
        return 0;
    }
}