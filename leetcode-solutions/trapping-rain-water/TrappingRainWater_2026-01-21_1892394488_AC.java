class Solution {
    public int trap(int[] height) {
        int n = height.length; 

        if(n <= 2) return 0; 

        int left = 0, right = n-1, leftMax = height[0], rightMax = height[n-1]; 
        int waterTrapped = 0; 

        while(left < right){
            if(height[left] <= height[right]){

                // since we're concerned with min of leftmax, rightmax
                left ++; 
                int water = (leftMax - height[left] > 0) ? (leftMax - height[left]) : 0; 
                waterTrapped += water; 
                leftMax = Math.max(leftMax, height[left]);
            }else{
                right --; 
                // since we are coming from right, we'll be pretty sure that rightMax is min(leftMax, rightMax)
                int water = (rightMax - height[right] > 0) ? (rightMax - height[right]) : 0; 
                waterTrapped += water; 
                rightMax = Math.max(rightMax, height[right]);
            }
        }
        return waterTrapped; 
    }
}