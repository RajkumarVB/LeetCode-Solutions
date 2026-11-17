class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0; 
        HashSet<Integer> set = new HashSet<>();
        for(int ele : nums){
            set.add(ele); 
        }
        int ans = 1; 
        for(int ele : set){
           if(set.contains(ele -1)) continue; 
           int startingPoint = ele; 
           int count = 1; 
           while(set.contains(startingPoint + 1)){
                count ++; 
                startingPoint++; 
           }
           ans = Math.max(count, ans); 
        }
        return ans; 
    }
}