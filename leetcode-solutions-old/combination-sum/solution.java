class Solution {
    private List<List<Integer>> result ; 
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new LinkedList<>();
        Arrays.sort(candidates); 
        computeCombinationSum(candidates, 0, target, new LinkedList<>()); 
        return result; 
    }

    private void computeCombinationSum(int[] candidates, int idx , int target, LinkedList<Integer> takenNums){
        int n = candidates.length; 
        if(idx >= n || target - candidates[idx] < 0) return; 
        if(target - candidates[idx] == 0){
            takenNums.add(candidates[idx]);
            result.add(new LinkedList<>(takenNums));
            takenNums.removeLast();
            return; 
        }
        int newTarget = target - candidates[idx]; 
        takenNums.add(candidates[idx]);
        computeCombinationSum(candidates, idx, newTarget, takenNums);
        takenNums.removeLast();
        computeCombinationSum(candidates, idx + 1, target, takenNums);
    }
}


