public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        helper(n, k, 1, new ArrayList<Integer>()); 
        return res;
    }
    private void helper(int n, int k, int start, ArrayList<Integer> cur) {
        if (k == 0) {
            res.add(new ArrayList<Integer>(cur));
            return;
        } 
        for (int i = start; i <= n; i++) {
            cur.add(i);
            helper(n, k - 1, i + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
}