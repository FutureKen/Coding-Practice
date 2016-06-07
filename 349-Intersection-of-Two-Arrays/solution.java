public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        ArrayList<Integer> inter = new ArrayList<Integer>();
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])) {
                inter.add(nums2[i]);
                set1.remove(nums2[i]);
            }
        }
        int[] result = new int[inter.size()];
        for (int i = 0; i < inter.size(); i++) {
            result[i] = inter.get(i);
        }
        return result;
    }
}