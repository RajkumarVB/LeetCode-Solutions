class Solution {
    public int trap(int[] height) {
        int n = height.length; 
        int leftMax = height[0], rightMax = height[n-1], left = 0, right = n-1; 

        int totalWaterTrapped = 0; 
        while(left < right){
            if(leftMax < rightMax){
                left ++; 
                int waterTrapped = leftMax - height[left]; 
                waterTrapped = (waterTrapped < 0) ? 0 : waterTrapped; 
                totalWaterTrapped += waterTrapped; 
                leftMax = Math.max(leftMax, height[left]);
            }else{
                right --; 
                int waterTrapped = rightMax - height[right]; 
                waterTrapped = (waterTrapped < 0) ? 0 : waterTrapped; 
                totalWaterTrapped += waterTrapped; 
                rightMax = Math.max(rightMax, height[right]);
            }
        }
        return totalWaterTrapped; 
    }
}