class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> result = new ArrayList<>(); 
        int i=0, j=k-1, n = nums.length;
        while(j < n){
            int max = findMax(nums,i,j); 
            result.add(max); 
            i++; 
            j++; 
        }
        return result.stream().mapToInt(Integer::intValue).toArray(); 
    }
    public int findMax(int[] nums, int i, int j){
        int max = Integer.MIN_VALUE;
        for(int k =i; k<=j; k++){
            max = Math.max(max,nums[k]); 
        }
        return max; 
    }
}