class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        int n = nums.length; 
        for(var element : nums){
            hs.add(element);
        }
        int result = 1;
        for(var element : hs){
            if(!hs.contains(element-1)){
                int count = 1; 
                int item = element; 
                while(hs.contains(item +1)){
                    count ++;
                    item ++; 
                }
                result = Math.max(result,count); 
            }
        }
        return result; 
    }
}