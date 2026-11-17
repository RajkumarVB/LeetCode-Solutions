class Solution {
    public int trap(int[] height) {
        int n = height.length; 
        if(n < 2) return 0; 
        int waterTrapped = 0; 
        int left =0;
        int right = n-1; 
        int maxLeft = height[0];
        int maxRight = height[n-1]; 
        while(left < right) {
            if(maxLeft < maxRight){
                left ++; 
                int water = maxLeft - height[left]; 
                waterTrapped += (water > 0) ? water : 0; 
                maxLeft = Math.max(maxLeft, height[left]); 
            } else {
                right --; 
                int water = maxRight - height[right]; 
                waterTrapped += (water > 0) ? water : 0; 
                maxRight = Math.max(maxRight, height[right]); 
            }
        }
        return waterTrapped; 
    }
}