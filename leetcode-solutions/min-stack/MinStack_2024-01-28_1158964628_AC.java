class MinStack {

    private List<Pair> stack; 

    public MinStack() {
        this.stack = new LinkedList<>(); 
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.addLast(new Pair(val, val)); 
            return; 
        }
        int minSoFar = Math.min(stack.getLast().minSoFar, val); 
        stack.addLast(new Pair(val,minSoFar)); 
    }
    
    public void pop() {
        stack.removeLast(); 
    }
    
    public int top() {
        return stack.getLast().value; 
    }
    
    public int getMin() {
        return stack.getLast().minSoFar; 
    }

    record Pair(int value, int minSoFar){

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