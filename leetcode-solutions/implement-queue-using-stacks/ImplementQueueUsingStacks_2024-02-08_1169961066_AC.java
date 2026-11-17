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