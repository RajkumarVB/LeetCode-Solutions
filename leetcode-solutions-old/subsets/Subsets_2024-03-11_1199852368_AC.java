class Solution {
    int[] nums; 
    List<List<Integer>> ans = new LinkedList<>(); 
    int n; 
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums; 
        this.n = nums.length;
        backtrack(new LinkedList<>(), 0);
        return ans; 
    }
    public void backtrack(List<Integer> tempAns, int i){
        if(i == n){
            ans.add(new LinkedList<>(tempAns)); 
            return; 
        }
        tempAns.add(nums[i]); 
        backtrack(tempAns,i+1); 
        tempAns.removeLast(); 
        backtrack(tempAns,i+1); 
    }
}