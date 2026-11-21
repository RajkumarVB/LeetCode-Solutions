/*
 * 155. Min Stack  [Medium]
 * https://leetcode.com/problems/min-stack/
 * Topics: Stack, Design
 *
 * Problem:     Design a stack supporting push, pop, top and getMin, all in O(1).
 * Example:     push -2, push 0, push -3, getMin -> -3, pop, getMin -> -2
 * Constraints: <= 3e4 calls
 *
 * Key idea:    Store each element together with the minimum of the stack at the time it was
 *              pushed; getMin reads the top's stored minimum.
 *
 * Approach:    Stack of (value, minSoFar) pairs
 * Complexity:  time O(1), space O(n)
 * Submitted:   2025-09-16 (submission 1773089212, AC)
 */

class MinStack {
    private LinkedList<Pair> list; 

    public MinStack() {
        this.list = new LinkedList<>(); 
    }
    
    public void push(int val) {
        int minValueSoFar; 
        if(list.isEmpty()){
            minValueSoFar = val; 
        }else{
            minValueSoFar = Math.min(val,list.getLast().minValueSoFar); 
        }
        list.addLast(new Pair(val, minValueSoFar)); 
    }
    
    public void pop() {
        list.removeLast(); 
    }
    
    public int top() {
        return !list.isEmpty() ? list.getLast().value  : -1; 
    }
    
    public int getMin() {
        return list.getLast().minValueSoFar; 
    }
}

class Pair{
    int value; 
    int minValueSoFar; 
    public Pair(int value, int minValueSoFar){
        this.value = value; 
        this.minValueSoFar = minValueSoFar; 
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