// Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.
//
//
//     Example 1:
//
//
// Given points = [[1,1],[-1,1]], return true.
//
//
//
//     Example 2:
//
//
// Given points = [[1,1],[-1,-1]], return false.
//
//
// Follow up:
// Could you do better than O(n2)?
//
//
//
//   Find the smallest and largest x-value for all points.
//   If there is a line then it should be at y = (minX + maxX) / 2.
//   For each point, make sure that it has a reflected point in the opposite side.
//
//
// Credits:Special thanks to @memoryless for adding this problem and creating all test cases.


public class Solution {
    public boolean isReflected(int[][] points) {
        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] point : points) {
            min = Math.min(min, point[0]);
            max = Math.max(max, point[0]);
            set.add(Arrays.hashCode(point));
        }
        int sum = min + max;
        for (int[] point : points) {
            if (!set.contains(Arrays.hashCode(new int[]{sum - point[0], point[1]}))) {
                return false;
            }
        } 
        return true;
    }
}
