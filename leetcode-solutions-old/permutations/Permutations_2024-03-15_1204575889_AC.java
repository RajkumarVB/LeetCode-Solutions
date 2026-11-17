class Solution {
    List<List<Integer>> result = new LinkedList<>(); 
    int n ; 
    int[] nums; 
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums; 
        this.n = nums.length; 
        backtrack(new LinkedHashSet<>()); 
        return result; 
    }
    public void backtrack(LinkedHashSet<Integer> set){
        if(set.size() == n){
            result.add(new LinkedList<>(set));
            return; 
        }
        for(int i=0; i<n; i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]); 
                backtrack(set); 
                set.remove(nums[i]);
            }
        }
    }
}