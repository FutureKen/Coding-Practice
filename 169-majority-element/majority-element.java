// Given an array of size n, find the majority element. The majority element is the element that appears more than &lfloor; n/2 &rfloor; times.
//
// You may assume that the array is non-empty and the majority element always exist in the array.
//
// Credits:Special thanks to @ts for adding this problem and creating all test cases.


public class Solution {
    public int majorityElement(int[] nums) {
      int majority=0;
      int counter=0;
      for(int i=0; i<nums.length; i++) {
        if(counter == 0){
          majority = nums[i];
          counter++;
        } else {
          if(nums[i] == majority) {
            counter++;
          } else {
            counter--;
          }
        }
      }
      return majority;  
    }
}
