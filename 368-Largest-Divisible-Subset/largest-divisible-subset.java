// Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
//
//
// If there are multiple solutions, return any subset is fine.
//
//
// Example 1:
//
// nums: [1,2,3]
//
// Result: [1,2] (of course, [1,3] will also be ok)
//
//
//
// Example 2:
//
// nums: [1,2,4,8]
//
// Result: [1,2,4,8]
//
//
//
// Credits:Special thanks to @Stomach_ache for adding this problem and creating all test cases.


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

