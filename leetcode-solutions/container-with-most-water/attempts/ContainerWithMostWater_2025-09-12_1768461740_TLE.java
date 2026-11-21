class Solution {
    public int maxArea(int[] height) {
        int n = height.length; 
        int maxArea = Integer.MIN_VALUE; 
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                int area = Math.min(height[i], height[j]) * (j-i) ; 
                maxArea = Math.max(area, maxArea); 
            }
        }
        return maxArea; 
    }
}

//  0 1 2 3 4 5 6 7 8 
// [1,8,6,2,5,4,8,3,7]