class Solution {
    int[] nums;
    List<List<Integer>> result = new LinkedList<>();
    int n ;  
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); 
        this.nums = nums; 
        this.n = nums.length; 
        backtrack(0, new LinkedList<>()); 
        return result; 
    }
    public void backtrack(int i, List<Integer> tempResult){
        if(i==n){
            result.add(new ArrayList<>(tempResult));
            return;
        }
        tempResult.add(nums[i]);
        backtrack(i+1, tempResult);
        tempResult.removeLast(); 
        while((i < n-1) && (nums[i] == nums[i+1])){
            i++; 
        }
        backtrack(i+1, tempResult);
    }
}