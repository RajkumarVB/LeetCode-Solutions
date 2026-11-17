class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length; 
        LinkedList<Integer> stack = new LinkedList<>(); 
        int maxArea = 0; 
        for(int i=0; i<=n; i++){
            while(!stack.isEmpty() && ((i==n) || heights[i] < heights[stack.getLast()])){
                int height = stack.removeLast(); 
                int width; 
                if(stack.isEmpty()) width = i; 
                else width = i - stack.getLast() -1; 
                int area = width * heights[height]; 
                maxArea = Math.max(area,maxArea); 
            }
            stack.addLast(i); 
        }
        return maxArea; 
    }
}