class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length; 
        int subsets = 1 << n; 
        List<List<Integer>> result = new LinkedList<>(); 
        for(int i=0; i<subsets; i++){
            List<Integer> tempResult = new LinkedList<>(); 
            for(int j=0; j<n; j++){
                // Check whether j'th bit is set or not in i 
                if(((1 << j) & i) != 0) tempResult.add(nums[j]); 
            }
            result.add(tempResult);
        }
        return result; 
    }
}