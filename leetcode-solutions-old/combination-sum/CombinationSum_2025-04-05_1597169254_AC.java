class Solution {
    private List<List<Integer>> ans = new LinkedList<>(); 
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length; 
        computeCombinationSum(candidates, target,n-1, new LinkedList<>()); 
        return ans; 
    }

    private void computeCombinationSum(int[] candidates, int target, int i, List<Integer> tempAns){
        if(target == 0){
            ans.add(new LinkedList<>(tempAns)); 
            return; 
        }
        if(i < 0 || target < 0){
            return; 
        }
        tempAns.add(candidates[i]); 
        computeCombinationSum(candidates, target - candidates[i], i, tempAns); 
        tempAns.remove(tempAns.size() -1); 
        computeCombinationSum(candidates, target, i-1, tempAns); 
    }
}