// Given an integer array of size n, find all elements that appear more than &lfloor; n/3 &rfloor; times. The algorithm should run in linear time and in O(1) space.
//
//
//   How many majority elements could it possibly have?
//   Do you have a better hint? Suggest it!


public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int counter1 = 0;
        int counter2 = 0;
        int major1 = 0;
        int major2 = 0;
        

        for (int i = 0; i < nums.length; i++){
          if (counter1 == 0){
            major1 = nums[i];
          } else if (counter2 == 0){
            major2 = nums[i];
          } 
          if (major1 == nums[i]){
            counter1++;
          } else if (major2 == nums[i]){
            counter2++;
          } else {
            counter1--;
            counter2--;
          }
        }
        counter1 = counter2 = 0;
        for (int i = 0; i < nums.length; i++){
          if (major1 == nums[i]){
            counter1++;
          } else if (major2 == nums[i]) {
            counter2++;
          }
        }
        
        if (counter1 > nums.length / 3) {
          result.add(major1);
        } 
        if (counter2 > nums.length / 3) {
          result.add(major2);
        }
        return result;
    }
}
