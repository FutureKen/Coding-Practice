// Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//
//
//
// Valid operators are +, -, *, /. Each operand may be an integer or another expression.
//
//
//
// Some examples:
//
//   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6


public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String str : tokens) {                
            switch (str) {
                case "+":
                    st.push(st.pop() + st.pop());
                    break;
                case "-": 
                    st.push(-st.pop() + st.pop());
                    break;
                case "*":
                    st.push(st.pop() * st.pop());
                    break;
                case "/":
                    int r = st.pop();
                    int l = st.pop();
                    st.push(l / r);
                    break;
                default:
                    st.push(Integer.parseInt(str));
            }   
        }
        return st.pop();
    }
}
