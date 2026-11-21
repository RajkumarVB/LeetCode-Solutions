class Solution {
    private HashSet<List<Integer>> ans = new HashSet<>(); 
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); 
        computeCombinationSum(candidates, target, 0, new LinkedList<>()); 
        return new LinkedList<>(ans); 
    }
    private void computeCombinationSum(int[] candidates, int target, int i, List<Integer> tempAns){
        if(target == 0){
            ans.add(new LinkedList<>(tempAns)); 
            return; 
        }
        if(target < 0 || i >= candidates.length) return; 
        tempAns.add(candidates[i]); 
        computeCombinationSum(candidates, target - candidates[i], i+1, tempAns); 
        tempAns.removeLast(); 
        computeCombinationSum(candidates, target, i+1, tempAns); 
    }
}