class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length; 
        int subsets = 1 << n; 
        HashSet<List<Integer>> result = new HashSet<>(); 
        for(int i=0; i<subsets; i++){
            List<Integer> tempResult = new LinkedList<>(); 
            for(int j=0; j<n; j++){
                // Check whether j'th bit is set or not in i 
                if(((1 << j) & i) != 0) tempResult.add(nums[j]); 
            }
            tempResult.sort(null); 
            result.add(tempResult);
        }
        return new LinkedList<>(result); 
    }
}