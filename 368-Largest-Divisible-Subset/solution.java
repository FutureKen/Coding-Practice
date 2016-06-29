public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
    	List<Integer> result = new ArrayList<Integer>();
        if (nums.length == 0 || nums == null) {
        	return result;
        } else {
        	Arrays.sort(nums);
        	int[] parent = new int[nums.length];
        	int[] count = new int[nums.length];
        	int max = 0;
        	int start = -1;
        	for (int i = nums.length - 1; i >= 0; i--) {
        		for (int j = i; j < nums.length; j++) {
        			if (nums[j] % nums[i] == 0 && count[i] < count[j] + 1) {
        				count[i] = count[j] + 1;
        				parent[i] = j;
        				if (count[i] > max) {
        					max = count[i];
        					start = i;
        				}
        			}
        		}
        	}
        	for (int i = 0; i < max; i++) {
        		result.add(nums[start]);
        		start = parent[start];
        	}
        	return result;
        }
    }
}
