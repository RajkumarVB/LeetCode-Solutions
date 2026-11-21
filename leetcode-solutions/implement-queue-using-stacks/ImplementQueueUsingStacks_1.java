/*
 * 232. Implement Queue using Stacks  [Easy]
 * https://leetcode.com/problems/implement-queue-using-stacks/
 * Topics: Stack, Design, Queue
 *
 * Problem:     Implement a FIFO queue (push, pop, peek, empty) using only two stacks.
 * Example:     push 1, push 2, peek -> 1, pop -> 1, empty -> false
 * Constraints: <= 100 calls
 *
 * Key idea:    Push onto an 'in' stack. For pop/peek, if the 'out' stack is empty, pour
 *              everything from 'in' into it (this reverses the order). Each element moves
 *              at most once: amortised O(1).
 *
 * Approach:    Lazy transfer in -> out (amortised O(1))
 * Complexity:  time O(1) amortised, space O(n)
 * Also see:    _2: Reorder on every push (O(n) push)
 * Submitted:   2024-02-08 (submission 1169961066, AC)
 */

class MyQueue {
    List<Integer> s1;
    List<Integer> s2;

    public MyQueue() {
        s1 = new LinkedList<>();
        s2 = new LinkedList<>();
    }
    
    public void push(int x) {
        s1.addLast(x); 
    }
    
    public int pop() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.addLast(s1.removeLast()); 
            }
            return s2.removeLast(); 
        } else{
            return s2.removeLast(); 
        }
    }
    
    public int peek() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.addLast(s1.removeLast()); 
            }
            return s2.getLast(); 
        } else{
            return s2.getLast(); 
        }
    }
    
    public boolean empty() {
        return s1.size() == 0 && s2.size() == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */