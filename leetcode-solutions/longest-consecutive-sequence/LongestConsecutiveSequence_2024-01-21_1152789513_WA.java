class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length; 
        HashSet<Integer> set = new HashSet<>(); 
        
        for(int element : nums) set.add(element);
        
        int result = 1; 
        for(int i=0; i<n; i++){
            if(set.contains(nums[i] + 1)) continue; 
            int seqCount = 1; 
            int num = nums[i]; 
            while(set.contains(num -1)){
                seqCount ++;
                num --; 
            }
            result = Math.max(result, seqCount); 
        }
        return result; 
    }
}