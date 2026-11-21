class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        LinkedList<Integer> stack = new LinkedList<>(); 
        int n = temperatures.length; 
        int[] result = new int[n];
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && temperatures[stack.getLast()] < temperatures[i]){
                stack.removeLast(); 
            }
            result[i] = !stack.isEmpty() ? (stack.getLast() - i) : 0; 
            stack.addLast(i);
        }
        return result; 
    }
}