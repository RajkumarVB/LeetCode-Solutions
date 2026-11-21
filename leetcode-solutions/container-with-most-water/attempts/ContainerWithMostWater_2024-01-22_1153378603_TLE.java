class Solution {
    public int maxArea(int[] height) {
        int result =0; 
        int n = height.length; 
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int area = Math.min(height[i], height[j]) * (j-i); 
                result = Math.max(result,area);
            }
        }
        return result; 
    }
}