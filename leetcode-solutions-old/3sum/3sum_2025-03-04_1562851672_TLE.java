class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length; 
        HashSet<List<Integer>> ans = new HashSet<>(); 
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> temp = new LinkedList<>(); 
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);

                        
                        temp.sort(null); 
                        ans.add(temp); 
                    }
                }
            }
        }
        return new LinkedList<>(ans); 
    }
}