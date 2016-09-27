public class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxA = 0;
        while (left < right) {
            maxA = Math.max(Math.min(height[left], height[right]) * (right - left), maxA);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxA;
    }
}