public class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        helper(s, new ArrayList<>());
        return res;
    }

    private void helper(String s, List<String> cur) {
        if (s.length() == 0) {
            res.add(new ArrayList<String>(cur));
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            if (isPalin(s.substring(0, i))) {
                cur.add(s.substring(0,i));
                helper(s.substring(i), cur);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean isPalin(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}