class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<List<Integer>> ans = new HashSet<>(); 
        int n = nums.length; 
        
        HashSet<Integer> set = new HashSet<>(); 

        for(int i=0; i<n; i++){
            for(int j = i+1; j<n; j++){
                set.clear(); 
                for(int k = j+1; k<n; k++){
                    int fourthNumber = target - nums[i] - nums[j] - nums[k] ;
                    if(set.contains(fourthNumber)){
                        List<Integer> tempAns = Arrays.asList(nums[i],nums[j],nums[k], fourthNumber); 
                        tempAns.sort(null); 
                        ans.add(tempAns); 
                    }
                    set.add(nums[k]); 
                }
            }
        }

        return new LinkedList<>(ans); 
    }
}