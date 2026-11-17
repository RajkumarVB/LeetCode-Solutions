class Solution {
    private List<List<Integer>> ans = new LinkedList<>(); 
    private int[] nums; 
    private int n; 
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums; 
        this.n = nums.length; 
        //ans.add(new LinkedList<>())
        backtrack(new LinkedList<>(),0);
        return ans; 
    }

    public void backtrack(List<Integer> tempAns, int i){
        int tempAnsLength = tempAns.size(); 
        if(i >= n){
            ans.add(new LinkedList<>(tempAns)); 
            return; 
        }
        

        
        backtrack(tempAns, i+1); 

        if(tempAnsLength != tempAns.size()){
            tempAns.remove(tempAns.size() -1); 
        }

        tempAns.add(nums[i]); 

        backtrack(tempAns, i+1); 

        if(tempAnsLength != tempAns.size()){
            tempAns.remove(tempAns.size() -1); 
        }
    }
}