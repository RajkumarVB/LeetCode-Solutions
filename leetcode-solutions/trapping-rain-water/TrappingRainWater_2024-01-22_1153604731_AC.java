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
                maxLeft = Math.max(maxLeft, height[left]); 
                int water = maxLeft - height[left];
                waterTrapped += water; 
                
            } else {
                right --; 
                maxRight = Math.max(maxRight, height[right]); 
                int water = maxRight - height[right]; 
                waterTrapped += water; 
            }
        }
        return waterTrapped; 
    }
}