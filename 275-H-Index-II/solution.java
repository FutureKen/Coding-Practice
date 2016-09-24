public class Solution {
    public int hIndex(int[] citations) {
        int start = 0, len = citations.length, end = len - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (citations[mid] >= len - mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return len - start;
    }
}