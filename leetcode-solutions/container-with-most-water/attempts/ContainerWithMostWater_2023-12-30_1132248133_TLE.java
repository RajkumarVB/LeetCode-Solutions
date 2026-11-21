class Solution {
    public int maxArea(int[] height) {
        int n = height.length; 
        int maxArea = 0; 
        for(int i=0; i<n-1; i++){
            for(int j =i+1; j<n; j++){
                int area = (j - i) * Math.min(height[i], height[j]); 
                maxArea = Math.max(maxArea, area); 
            }
        }
        return maxArea; 
    }
}