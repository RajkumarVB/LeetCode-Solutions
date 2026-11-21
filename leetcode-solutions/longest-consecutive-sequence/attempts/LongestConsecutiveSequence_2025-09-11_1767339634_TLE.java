class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int result = 0; 
        for(int num : nums){
            if(set.contains(num-1)) continue; 

            int count = 1; 
            int currentStartingPoint = num ; 
            while(set.contains(currentStartingPoint+count)){
                count++; 
            }
            result = Math.max(result, count);
        }
        return result; 
    }
}


// put nums[i] to a hashset