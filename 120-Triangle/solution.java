public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        if (rows == 0) {
            return 0; 
        }
        int[] min = new int[rows];
        //Add last row to min;
        for (int i = 0; i < triangle.get(rows - 1).size(); i++) {
            min[i] = triangle.get(rows - 1).get(i);
        }

        //Go from bottom to top;
        for (int i = rows - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                min[j] = Math.min(min[j], min[j + 1]) + triangle.get(i).get(j);
            }
        }
        return min[0];
    }
}