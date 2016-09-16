public class MinStack {
    Stack<Integer> stackPos;
    Stack<Integer> stackMin;

    /** initialize your data structure here. */
    public MinStack() {
        stackPos = new Stack<>();
        stackMin = new Stack<>();
    }
    
    public void push(int x) {
        stackPos.push(x);
        if (stackMin.isEmpty() || x <= stackMin.peek()) {
            stackMin.push(x);
        }
    }
    
    public void pop() {
        if (stackPos.pop() <= stackMin.peek()) {
            stackMin.pop();
        }
    }
    
    public int top() {
        return stackPos.peek();
    }
    
    public int getMin() {
        return stackMin.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */