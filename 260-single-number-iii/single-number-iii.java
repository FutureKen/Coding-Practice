// Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
//
//
// For example:
//
//
// Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
//
//
// Note:
//
// The order of the result is not important. So in the above example, [5, 3] is also correct.
// Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
//
//
//
// Credits:Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.


public class Solution {
    public int[] singleNumber(int[] nums) {
        int allxor = 0;
        int result1 = 0;
        int result2 = 0;
        for (int i = 0; i < nums.length; i++) {
            allxor ^= nums[i];
        }
        //find lowbit of allxor, which means the two single numbers are different on that bit;
        int lowbit = allxor & ~(allxor - 1);
        for (int j = 0; j < nums.length; j++) {
            if ((lowbit & nums[j]) == 0) {
                result1 ^= nums[j];
            } else {
                result2 ^= nums[j];
            }
        }
        int[] result = new int[2];
        result[0] = result1;
        result[1] = result2;
        return result;
    }
}
