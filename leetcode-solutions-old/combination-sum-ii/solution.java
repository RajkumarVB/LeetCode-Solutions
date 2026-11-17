class Solution {
    int[] candidates;
    int target; 
    List<List<Integer>> result = new LinkedList<>(); 
    int n;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates; 
        this.target = target; 
        this.n = candidates.length; 
        backtrack(0,0,new LinkedList<>()); 
        return result; 
    }
    public void backtrack(int i, long sum, List<Integer> tempResult){
        if(sum == target){
            result.add(new LinkedList<>(tempResult));
            return; 
        }
        for(int k=i; k<n; k++){
            if(sum + candidates[k] > target) break;
            if(k != i && candidates[k] == candidates[k-1]) continue; 
            tempResult.add(candidates[k]);
            backtrack(k+1, sum + candidates[k], tempResult);
            tempResult.removeLast(); 
        }
    }
}