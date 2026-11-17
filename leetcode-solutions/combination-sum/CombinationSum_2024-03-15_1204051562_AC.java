class Solution {
    List<List<Integer>> result = new LinkedList<>(); 
    int[] candidates; 
    int target; 
    int n; 
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates; 
        this.target = target; 
        this.n = candidates.length; 
        backtrack(0,0,new LinkedList<>()); 
        return result; 
    }
    public void backtrack(int i, long sum, List<Integer> tempResult){
        if(sum > target || i >=n) return; 
        if(sum == target){
            result.add(new LinkedList<>(tempResult));
            return;
        }
        tempResult.add(candidates[i]); 
        backtrack(i, sum+candidates[i],tempResult);
        tempResult.removeLast();
        backtrack(i+1,sum,tempResult); 
    }
}