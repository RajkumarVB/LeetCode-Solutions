class Solution {
    public int trap(int[] height) {
        int n = height.length; 
        if(n < 1) return 0; 
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        for(int i=1; i<n-1; i++){
            leftMax[i] = Math.max(height[i-1],leftMax[i-1]);
        }
        for(int i=n-2; i>=1 ;i--){
            rightMax[i] = Math.max(rightMax[i+1],height[i+1]); 
        }
        int maxWater =0; 
        for(int i=1; i<n-1; i++){
            int water = Math.min(leftMax[i], rightMax[i]) - height[i];
            maxWater += (water > 0) ? water : 0; 
        }
        return maxWater; 
    }
}