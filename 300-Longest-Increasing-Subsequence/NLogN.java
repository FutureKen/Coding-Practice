public class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int num : nums) {
            if (res.size() == 0 || res.get(res.size() - 1) < num) {
                res.add(num);
            } else {
                int index = Collections.binarySearch(res, num);
                index = index < 0 ? - index - 1 : index;
                res.set(index, num);
            }  
        }
        return res.size();
    }
}