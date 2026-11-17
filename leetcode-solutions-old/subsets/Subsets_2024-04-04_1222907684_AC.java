class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length; 
        int subsets = 1 << n;
        List<List<Integer>> result = new LinkedList<>(); 
        for(int i=0; i<subsets; i++) {
            List<Integer> subset = new LinkedList<>(); 
            for(int j=0; j<n; j++){
                if(((1 << j) & i) != 0){
                    subset.add(nums[j]); 
                }
            }
            result.add(subset); 
        }
        return result; 
    }
}