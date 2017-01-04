// Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
//
//
//
//
// Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
//
//
//
//
// The largest rectangle is shown in the shaded area, which has area = 10 unit.
//
//
//
// For example,
// Given heights = [2,1,5,6,2,3],
// return 10.


public class Solution {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int maxArea = 0;
        // Add a dummy node at the end
        int[] h = new int[height.length + 1];
        h = Arrays.copyOf(height, height.length + 1);
        while (i < h.length) {
        	if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
        		stack.push(i);
        		i++;
        	} else {
        		int top = stack.pop();
        		int width = stack.isEmpty()? i : i - stack.peek() - 1;
        		maxArea = Math.max(maxArea, h[top] * width);
        	}
        }
        return maxArea;
    }
}
