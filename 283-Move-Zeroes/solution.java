public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return;
        }
        int index = 0;
        for (int element : nums) {
        	if (element != 0) {
        		nums[index] = element;
        		index++;
        	}
        }
        while (index < nums.length) {
        	nums[index] = 0;
        	index++;
        }
    }
}