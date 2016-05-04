public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return result;
        }
        List<Integer> first = new ArrayList<Integer>();
        first.add(0, 1);
        result.add(0, first);
        for (int i = 1; i < numRows; i++ ) {
            List<Integer> prev = result.get(i - 1);
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.add(1);
            for (int j = 1; j < i; j++) {
                tmp.add(prev.get(j - 1) + prev.get(j));
            }
            tmp.add(1);
            result.add(tmp);
        }
        return result;
    }
}