class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min_stack;

    public MinStack() {
        stack = new Stack<>();
        min_stack = new Stack<>(); // stores minimum value
    }
    
    public void push(int val) {
        stack.push(val);
        if(min_stack.isEmpty() || val<=min_stack.peek()){
            min_stack.push(val);
        }
    }
    
    public void pop() {
        if(!stack.isEmpty()){
            int val = stack.pop();
            if(!min_stack.isEmpty() && min_stack.peek() == val){
                min_stack.pop();
            }
        }
    }
    
    public int top() {
        if(!stack.isEmpty())
            return stack.peek();
        return -1;
    }
    
    public int getMin() {
        if(!min_stack.isEmpty())
            return min_stack.peek();
        return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */