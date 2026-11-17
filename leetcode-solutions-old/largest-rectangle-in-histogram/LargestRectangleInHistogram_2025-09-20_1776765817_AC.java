class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length; 
        LinkedList<Integer> stack = new LinkedList<>(); 
        int result = 0; 
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && heights[i] <= heights[stack.getLast()]){
                int element = heights[stack.getLast()]; 
                stack.removeLast();
                int previousSmaller = stack.isEmpty() ? -1 : stack.getLast(); 
                int nextSmaller = i; 
                int width = nextSmaller - previousSmaller -1 ; 
                int area = width * element; 
                result = Math.max(area, result); 
            }
            stack.addLast(i); 
        }
        while(!stack.isEmpty()){
            int element = heights[stack.getLast()]; 
            stack.removeLast(); 
            int previousSmaller = stack.isEmpty() ? -1 : stack.getLast(); 
            int nextSmaller = n; 
            int width = nextSmaller - previousSmaller -1 ; 
            int area = width * element; 
            result = Math.max(area, result); 
        }
        return result; 
    }
}