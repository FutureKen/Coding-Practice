public class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        int i = 0;
         for (Character c : s.toCharArray()) {
            if ("({[".contains(String.valueOf(c))) {
                st.push(c);
            } else {
                if (!st.isEmpty() && (c == ')' && st.peek() == '(' || c == '}' && st.peek() == '{' || c == ']' && st.peek() == '[')) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}