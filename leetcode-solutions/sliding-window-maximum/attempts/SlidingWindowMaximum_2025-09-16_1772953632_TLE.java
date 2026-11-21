class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length; 
        List<Integer> result = new LinkedList<>(); 
        int windowStart = 0, windowEnd = k-1; 
        for(; windowEnd < n; windowEnd++){
            // compute the max element in this window
            result.add(computeMaxElement(nums, windowStart, windowEnd));
            windowStart ++; 
        }
        return result.stream().mapToInt(ele -> ele.intValue()).toArray();

    }
    private int computeMaxElement(int[] nums, int windowStart, int windowEnd){
        int max = Integer.MIN_VALUE; 
        for(int i=windowStart; i<=windowEnd; i++){
            max = Math.max(max, nums[i]);
        }
        return max; 
    }
}