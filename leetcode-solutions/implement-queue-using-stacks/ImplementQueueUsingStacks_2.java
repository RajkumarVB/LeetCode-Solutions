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
 * Approach:    Reorder on every push (O(n) push)
 * Complexity:  time O(n) push, O(1) pop, space O(n)
 * Also see:    _1: Lazy transfer in -> out (amortised O(1))
 * Submitted:   2024-02-08 (submission 1169955138, AC)
 */

class MyQueue {
    List<Integer> s1;
    List<Integer> s2;

    public MyQueue() {
        s1 = new LinkedList<>();
        s2 = new LinkedList<>();
    }
    
    public void push(int x) {
        while(!s1.isEmpty()){
            s2.addLast(s1.removeLast());
        }
        s1.addLast(x); 
        while(!s2.isEmpty()){
            s1.addLast(s2.removeLast());
        }
    }
    
    public int pop() {
        return s1.removeLast(); 
    }
    
    public int peek() {
        return s1.getLast(); 
    }
    
    public boolean empty() {
        return s1.size() == 0;
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