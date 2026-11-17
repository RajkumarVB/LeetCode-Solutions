class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> result = new ArrayList<>(); 
        int maxInWindow = Integer.MIN_VALUE;
        for(int i=0; i<k; i++){
            maxInWindow = Math.max(maxInWindow,nums[i]); 
        }
        result.add(maxInWindow); 
        int i=0, j=k, n = nums.length;
        while(j < n){
            int max = findMax(nums,i+1,j); 
            result.add(max); 
            i++; 
            j++; 
        }
        return result.stream().mapToInt(Integer::intValue).toArray(); 
    }
    public int findMax(int[] nums, int i, int j){
        int max = Integer.MIN_VALUE;
        for(int k=0; k<=j ;k++) max = Math.max(max,nums[k]);
        return max; 
    }
}