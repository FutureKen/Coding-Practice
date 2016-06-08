public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> inter = new ArrayList<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 1);
            }        
        }
        for (int j = 0; j < nums2.length; j++) {
            if (map.containsKey(nums2[j]) && map.get(nums2[j]) > 0) {
                inter.add(nums2[j]);
                map.put(nums2[j], map.get(nums2[j]) - 1);
            }
        }
        int[] result = new int[inter.size()];
        for (int i = 0; i < inter.size(); i++) {
            result[i] = inter.get(i);
        }
        return result;
    }
}