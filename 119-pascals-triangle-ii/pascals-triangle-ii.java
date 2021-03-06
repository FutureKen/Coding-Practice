// Given an index k, return the kth row of the Pascal's triangle.
//
//
// For example, given k = 3,
// Return [1,3,3,1].
//
//
//
// Note:
// Could you optimize your algorithm to use only O(k) extra space?


public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        rowIndex++;
        if (rowIndex == 0) {
            return result;
        }
        result.add(0, 1);
        for (int i = 1; i < rowIndex; i++) {
            List<Integer> temp = new ArrayList<Integer>(i + 1);
            temp.add(0, 1);
            for (int j = 1; j < i; j++) {
                temp.add(result.get(j - 1) + result.get(j));
            }
            temp.add(i, 1);
            result = temp;
        }
        return result;
    }
}
