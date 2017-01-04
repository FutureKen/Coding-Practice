// Given a sorted integer array where the range of elements are in the inclusive range [lower, upper], return its missing ranges.
//
//
// For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].


public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        for (int num : nums) {
            int curhi = num - 1;
            if (num == Integer.MIN_VALUE) {
                lower = num + 1;
                continue;
            }
            if (lower == curhi) {
                res.add(lower + "");
            } else if (lower < curhi) {
                res.add(lower + "->" + curhi);
            }
            lower = num + 1;
        }
        if(lower == Integer.MIN_VALUE) {
            return res;
        }
        if (lower == upper) {
            res.add(lower + "");
        } else if (lower < upper) {
            res.add(lower + "->" + upper);
        }
        return res;
    }
}
