class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length; 
        HashSet<List<Integer>> result = new HashSet<>();
        for(int i=0; i<n; i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j=i+1; j<n; j++){
                int thirdElement = -(nums[i] + nums[j]); 
                if(set.contains(thirdElement)){
                    List<Integer> tempAns = new LinkedList<>(Arrays.asList(nums[i],nums[j],thirdElement)); 
                    tempAns.sort(null);
                    result.add(tempAns); 
                }
                set.add(nums[j]); 
            }
        }
        return new LinkedList<>(result); 
    }
}