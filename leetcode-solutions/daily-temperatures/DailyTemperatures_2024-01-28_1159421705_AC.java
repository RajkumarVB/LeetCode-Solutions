class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length; 
        int[] ans = new int[n]; 
        LinkedList<Integer> stack = new LinkedList<>();
        for(int i=n -1; i>=0; i--){
            while(!stack.isEmpty() && temperatures[stack.getLast()] <= temperatures[i]){
                stack.removeLast(); 
            }
            if(!stack.isEmpty()){
                ans[i] = stack.getLast() - i ; 
            }
            stack.addLast(i); 
        }
        return ans; 
    }
}