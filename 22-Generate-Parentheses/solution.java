public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void helper(List<String> result, StringBuilder sb, int open, int close, int n) {
        if (open == n && close == n) {
            result.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append("(");
            helper(result, sb, open + 1, close, n);
            sb.setLength(sb.length() - 1); //backtrack;
        }
        if (close < open) {
            sb.append(")");
            helper(result, sb, open, close + 1, n);
            sb.setLength(sb.length() - 1);
        }
    }
}