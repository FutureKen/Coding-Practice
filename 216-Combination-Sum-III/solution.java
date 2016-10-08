public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        helper(k, n, 1, new ArrayList<>());
        return res;
    }
    private void helper(int k, int n, int index, ArrayList<Integer> cur) {
        if (cur.size() > k) {
            return;
        }
        if (cur.size() == k && n == 0) {
            List<Integer> list = new ArrayList<>(cur);
            res.add(list);
            return;
        }
        for (int i = index; i <= 9; i++) {
            cur.add(i);
            helper(k, n - i, i + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
}