public class Solution {
    public int numTrees(int n) {
        //Record how many nums of trees from 0 to n;
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                nums[i] += nums[j - 1] *  nums[i - j];
            }
        }
        return nums[n];
    }
}