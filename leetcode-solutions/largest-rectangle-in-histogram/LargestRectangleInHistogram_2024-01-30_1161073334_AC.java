class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length; 
        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n]; 
        LinkedList<Integer> stack = new LinkedList<>(); 

        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && heights[i] <heights[stack.getLast()]){
                stack.removeLast(); 
            }
            if(stack.isEmpty()){
                leftSmall[i] = 0; 
            } else{
                leftSmall[i] = stack.getLast() + 1 ; 
            }
            stack.addLast(i);
        }

        stack.clear();

        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && heights[i] <= heights[stack.getLast()]){
                stack.removeLast(); 
            }
            if(stack.isEmpty()){
                rightSmall[i] = n-1; 
            } else{
                rightSmall[i] = stack.getLast() - 1; 
            }
            stack.addLast(i);
        }

        Arrays.stream(leftSmall).forEach(ele -> System.out.print(ele + " "));
        System.out.println(); 
        Arrays.stream(rightSmall).forEach(ele -> System.out.print(ele + " "));

        int maxArea = 0; 
        for(int i=0; i<n; i++){
            int area = (rightSmall[i] - leftSmall[i] + 1) * heights[i]; 
            maxArea = Math.max(maxArea,area); 
        }

        return maxArea; 
    }
}