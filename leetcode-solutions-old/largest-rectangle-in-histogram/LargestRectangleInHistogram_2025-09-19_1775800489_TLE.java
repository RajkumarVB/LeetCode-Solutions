class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length; 
        int result = Integer.MIN_VALUE; 

        for(int i=0; i<n; i++){
            int left =i; 
            while(left >=0){
                if(heights[left] >= heights[i]){
                    left --; 
                }else{
                    break; 
                }
            }
            left ++; // just to make sure it stands on the height where it's possible to include in area
            int right = i; 
            while(right < n){
                if(heights[right] >= heights[i]){
                    right ++; 
                }else{
                    break; 
                }
            }
            right --;  // just to make sure it stands on the height where it's possible to include in area

            int area = (right -left + 1) * heights[i]; 
            result = Math.max(area, result); 

        }
        return result; 
    }
}