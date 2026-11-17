class Solution {
    List<List<Integer>> ans = new LinkedList<>(); 
    public List<List<Integer>> subsets(int[] nums) {
        computeSubsets(nums,0,new LinkedList<>()); 
        return ans; 
    }
    private void computeSubsets(int[] nums, int i ,List<Integer> tempAns){
        if(i == nums.length){
            ans.add(new LinkedList<>(tempAns)); 
            return; 
        }
        tempAns.add(nums[i]);
        computeSubsets(nums,i+1,tempAns); 
        tempAns.remove(tempAns.size() -1 ); 
        computeSubsets(nums,i+1,tempAns); 
    }
}