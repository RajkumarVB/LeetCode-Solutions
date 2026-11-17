class Solution {
    public int trap(int[] height) {
        int n = height.length; 
        if(n <=2) return 0; 

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        
        int maxSoFar = height[0];
        for(int i=0; i<n; i++){
            leftMax[i] = maxSoFar; 
            maxSoFar = Math.max(maxSoFar, height[i]);
        }

        maxSoFar = height[n-1];
        for(int i=n-1; i>=0; i--){
            rightMax[i] = maxSoFar; 
            maxSoFar = Math.max(maxSoFar, height[i]);
        }

        int waterTrapped = 0; 
        for(int i=1; i<n-1; i++){
            int water = Math.min(leftMax[i], rightMax[i]) - height[i];
            if(water > 0) waterTrapped += water; 
        }
        return waterTrapped; 
    }
}

// 1st and last places cannot hold water 
// water at current location => Math.min(leftMax, rightMax) - currentHeight[i]
// Math.min(leftMax, rightMax) - currentHeight[i] <= 0, which means it cannot hold anywater