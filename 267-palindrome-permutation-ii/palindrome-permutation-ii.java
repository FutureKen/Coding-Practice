// Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.
//
//
// For example:
//
//
// Given s = "aabb", return ["abba", "baab"].
//
//
// Given s = "abc", return [].
//
//
//
//   If a palindromic permutation exists, we just need to generate the first half of the string.
//   To generate all distinct permutations of a (half of) string, use a similar approach from: Permutations II or Next Permutation.


public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        List<Character> chars = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        if (set.size() > 1) {
            return res;
        } else {
            String mid = set.size() == 0 ? "" : set.iterator().next().toString();
            for (char key : map.keySet()) {
                int val = map.get(key);
                for (int i = 0; i < val / 2; i++) {
                    chars.add(key);
                }
            }
            boolean[] used = new boolean[chars.size()];
            helper(res, chars, new StringBuilder(), mid, used);
        }
        return res;
    }

    private void helper(List<String> res, List<Character> chars, StringBuilder sb, String mid, boolean[] used) {
        if (sb.length() == chars.size()) {
            String left = sb.toString();
            String right = sb.reverse().toString();
            res.add(left + mid + right);
            sb.reverse();
            return;
        }

        for (int i = 0; i < chars.size(); i++) {
            if (used[i] || (i > 0 && chars.get(i) == chars.get(i - 1) && !used[i - 1])) {
                continue;
            }
            sb.append(chars.get(i));
            used[i] = true;
            helper(res, chars, sb, mid, used);
            used[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
