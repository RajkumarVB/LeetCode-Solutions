class Solution {
        private List<List<Integer>> ans = new LinkedList<>(); 
        private int[] nums ; 
        
        public List<List<Integer>> permute(int[] nums) {
            this.nums = nums; 
            backtrack(new LinkedHashSet<>());
            return ans; 
        }

        public void backtrack(LinkedHashSet<Integer> tempAns){
            // Base case is everything is considered
            if(tempAns.size() == nums.length) {
                ans.add(new LinkedList<>(tempAns));
                return; 
            }

            for(int i=0; i<nums.length; i++){
                if(!tempAns.contains(nums[i])){
                    tempAns.add(nums[i]); 
                    backtrack(tempAns);
                    tempAns.remove(nums[i]); 
                }
            }
        }
}