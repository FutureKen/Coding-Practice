// Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//
//
// For example,
// Given [100, 4, 200, 1, 3, 2],
// The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
//
//
// Your algorithm should run in O(n) complexity.


public class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        int max = 1;
        for (int i : nums){
            hash.put(i, 0);
        }

        for (int i : nums){
            if (hash.get(i) == 1) {
                continue;
            }

            int temp = i;
            int cmax = 1;

            while (hash.containsKey(temp+1)) {
                cmax++;
                hash.put(temp++, 1);
            }

            temp = i;
            while (hash.containsKey(temp-1)) {
                cmax++;
                hash.put(temp--, 1);
            }

            max = Math.max(max, cmax);
        }
        return max;      
    }
}
