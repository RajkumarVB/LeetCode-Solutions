class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length; 
        List<List<Integer>> ans = new LinkedList<>(); 
        for(int i=0; i<= ((1 << n) - 1); i++){
            List<Integer> tempAns = new LinkedList<>(); 
            for(int j=0; j<n; j++){
                if((i & (1 << j)) != 0){
                    tempAns.add(nums[j]); 
                }
            }
            ans.add(tempAns); 
        }
        return ans; 
    }
}