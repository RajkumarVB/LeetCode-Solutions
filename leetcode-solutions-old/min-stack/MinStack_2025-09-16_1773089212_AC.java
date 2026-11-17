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